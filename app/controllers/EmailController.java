package controllers;

import models.Draft;
import models.Email;
import models.UserEmail;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import service.IEmailService;
import utils.Utility;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static utils.Constants.*;

@Security.Authenticated(UserAuthenticator.class)
public class EmailController extends Controller {
    @Inject
    IEmailService emailService;

    public Result inbox(String email, Integer pageCount) {
        List<UserEmail> emails = emailService.findByRecepient(email, pageCount);
        return ok(Json.toJson(emails));
    }

    public Result inboxUnread(String email, Integer pageCount) {
        List<UserEmail> emails = emailService.findUnreadByRecepient(email, pageCount);
        return ok(Json.toJson(emails));
    }

    public Result sent(String email, Integer pageCount) {
        List<Email> emails = emailService.findBySender(email, pageCount);
        return ok(Json.toJson(emails));
    }

    public Result trash(String email, Integer pageCount) {
        List<UserEmail> emails = emailService.findTrashByRecepient(email, pageCount);
        return ok(Json.toJson(emails));
    }

    public Result drafts(String email, Integer pageCount) {
        List<Draft> emails = emailService.findDrafts(email, pageCount);
        return ok(Json.toJson(emails));
    }

    //FIXME we can avoid asking for user email and use the auth key instead
    public Result send() {
        Map<String, String> queryParams = Utility.getQueryParamsMapFromJsonBody(request());
        String from = queryParams.get(EMAIL_SENDER_KEY);
        List<String> to = Arrays.asList(queryParams.get(EMAIL_RECEPIENTS_KEY).split(","));
        String subject = queryParams.get(EMAIL_SUBJECT_KEY);
        String body = queryParams.get(EMAIL_BODY_KEY);

        try {
            Email email = emailService.send(from, to, subject, body);
            return ok("Email Success");
        } catch (RuntimeException re) {
            //TODO encapsulation of error messages
            return badRequest(re.getMessage());
        }

    }

    //FIXME we can avoid asking for user email and use the auth key instead
    public Result saveDraft() {
        Map<String, String> queryParams = Utility.getQueryParamsMapFromJsonBody(request());
        Long draftId = null;
        try {
            draftId = Long.parseLong(queryParams.get(DRAFT_ID_KEY));
        } catch (Exception e) {
            //new draft creation
        }

        String from = queryParams.get(EMAIL_SENDER_KEY);
        String to = queryParams.get(EMAIL_RECEPIENTS_KEY);
        String subject = queryParams.get(EMAIL_SUBJECT_KEY);
        String body = queryParams.get(EMAIL_BODY_KEY);

        try {
            Draft email;
            if (draftId != null) {
                email = emailService.updateDraft(draftId, to, subject, body, UserAuthController.getUser());
            } else {
                email = emailService.saveDraft(from, to, subject, body);
            }
            if (email != null)
                return ok(Json.toJson(email));
            return badRequest("Could not find Draft to save");
        } catch (RuntimeException re) {
            //TODO encapsulation of error messages
            return badRequest(re.getMessage());
        }
    }

    public Result deleteDraft() {
        Map<String, String> queryParams = Utility.getQueryParamsMapFromJsonBody(request());
        Long draftId = null;
        try {
            draftId = Long.parseLong(queryParams.get(DRAFT_ID_KEY));
        } catch (Exception e) {
            return badRequest("Couldn't find draft to delete");
        }

        if (emailService.deleteDraft(draftId, UserAuthController.getUser()))
            return ok("Draft deleted");
        return badRequest("Could not find Draft to delete");
    }

    public Result markAsRead() {
        Map<String, String> queryParams = Utility.getQueryParamsMapFromJsonBody(request());
        Long emailId;
        try {
            emailId = Long.parseLong(queryParams.get(EMAIL_ID_KEY));
        } catch (NumberFormatException nfe) {
            return badRequest("Improper ID for email to mark as read");
        }

        if (emailService.markAsRead(emailId, UserAuthController.getUser()))
            return ok("Marked as Read");
        return badRequest("Email not found by ID");
    }

    //TODO delete is only supported for received emails, not for sent ones
    //TODO permanent delete isn't supported yet
    public Result deleteEmail() {
        Map<String, String> queryParams = Utility.getQueryParamsMapFromJsonBody(request());
        Long emailId = null;
        try {
            emailId = Long.parseLong(queryParams.get(EMAIL_ID_KEY));
        } catch (Exception e) {
            return badRequest("Couldn't find email to delete");
        }

        if (emailService.deleteEmail(emailId, UserAuthController.getUser()))
            return ok("Email deleted");
        return badRequest("Could not find Email to delete");
    }

    public Result replyToEmail() {
        Map<String, String> queryParams = Utility.getQueryParamsMapFromJsonBody(request());
        Long userEmailId = null;
        try {
            userEmailId = Long.parseLong(queryParams.get(USER_EMAIL_ID_KEY));
        } catch (Exception e) {
            return badRequest("Couldn't find user email ID to reply to");
        }

        String subject = queryParams.get(EMAIL_SUBJECT_KEY);    //could be null
        String body = queryParams.get(EMAIL_BODY_KEY);
        Email replyEmail = emailService.replyToEmail(userEmailId, UserAuthController.getUser(), subject, body);
        if (replyEmail != null) {
            return ok(Json.toJson(replyEmail));
        }
        return badRequest("Could not find email to reply to");
    }
}
