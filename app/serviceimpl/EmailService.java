package serviceimpl;

import io.ebean.Finder;
import models.*;
import service.IEmailService;
import service.IUserService;

import javax.inject.Inject;
import java.util.*;

import static utils.Constants.EMAILS_PER_PAGE;

public class EmailService implements IEmailService {
    //@Inject
    IUserService userService;

    private static Finder<Long, Email> findEmail = new Finder(Email.class);
    private static Finder<Long, Draft> findDraft = new Finder<>(Draft.class);
    private static Finder<Long, UserEmail> findUserEmail = new Finder<>(UserEmail.class);

    @Inject
    public EmailService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public Email send(String from, List<String> to, String subject, String body) {
        User fromUser = userService.findByEmail(from);
        if (fromUser == null) {
            throw new IllegalArgumentException("Wrong sender email "+from);
        }

        Set<User> toUsers;
        try {
            toUsers = userService.findByEmailSet(new HashSet<>(to));
        } catch (RuntimeException re) {
            throw new IllegalArgumentException("Wrong recipient email list "+ to);
        }

        if (toUsers.isEmpty()) {
            throw new IllegalArgumentException("Wrong recipient email list "+ to);
        }

        if (subject == null || subject.length()==0) {
            throw new IllegalArgumentException("Subject cannot be empty");
        }

        if (body == null || body.length()==0) {
            throw new IllegalArgumentException("Body cannot be empty");
        }

        Email email = new Email(fromUser, toUsers, subject, body);
        email.save();

        toUsers.forEach(user -> {
            UserEmail userEmail = new UserEmail(user, email);
            userEmail.save();
        });

        return email;
    }

    @Override
    public Draft saveDraft(String from, String to, String subject, String body) {
        User fromUser = userService.findByEmail(from);
        if (fromUser == null) {
            throw new IllegalArgumentException("Wrong sender email "+from);
        }

        Draft draft = new Draft(fromUser, to, subject, body);
        draft.save();
        return draft;
    }

    //TODO better error return so we can differentiate between draft not found and unauthorized access
    @Override
    public Draft updateDraft(Long id, String to, String subject, String body, User user) {
        Draft draft = findDraft.byId(id);
        if (draft == null)
            return null;
        if (!draft.fromEmail.email.equals(user.email)) {
            return null;
        }
        draft.toEmails = to;
        draft.subject = subject;
        draft.body = body;
        draft.save();
        return draft;
    }

    @Override
    public Boolean deleteDraft(Long id, User user) {
        Draft draft = findDraft.byId(id);
        if (!draft.fromEmail.email.equals(user.email)) {
            return false;
        }
        if (draft != null)
            return draft.delete();
        return false;
    }

    @Override
    public List<Email> findBySender(String email, Integer pageCount) {
        List<Email> emails = findEmail.query().where().eq("fromEmail.email", email).orderBy("updatedAt desc").findList();
        if (emails.size() >= EMAILS_PER_PAGE*pageCount) {
            return emails.subList((pageCount - 1)*EMAILS_PER_PAGE, (pageCount*EMAILS_PER_PAGE));
        }
        if (emails.size() > EMAILS_PER_PAGE*(pageCount -1)) {
            return emails.subList((pageCount - 1)*EMAILS_PER_PAGE, emails.size());
        }
        return new ArrayList<>();
    }

    @Override
    public List<UserEmail> findByRecepient(String email, Integer pageCount) {
        List<UserEmail> emails = findUserEmail.query().where().eq("userEmail.email", email).orderBy("updatedAt desc").findList();
        if (emails.size() >= EMAILS_PER_PAGE*pageCount) {
            return emails.subList((pageCount - 1)*EMAILS_PER_PAGE, (pageCount*EMAILS_PER_PAGE));
        }
        if (emails.size() > EMAILS_PER_PAGE*(pageCount -1)) {
            return emails.subList((pageCount - 1)*EMAILS_PER_PAGE, emails.size());
        }
        return new ArrayList<>();
    }

    @Override
    public List<UserEmail> findUnreadByRecepient(String email, Integer pageCount) {
        List<UserEmail> emails = findUserEmail.query().where().eq("userEmail.email", email)
                .eq("readState", ReadState.UNREAD).orderBy("updatedAt desc").findList();
        if (emails.size() >= EMAILS_PER_PAGE*pageCount) {
            return emails.subList((pageCount - 1)*EMAILS_PER_PAGE, (pageCount*EMAILS_PER_PAGE));
        }
        if (emails.size() > EMAILS_PER_PAGE*(pageCount -1)) {
            return emails.subList((pageCount - 1)*EMAILS_PER_PAGE, emails.size());
        }
        return new ArrayList<>();
    }

    @Override
    public List<UserEmail> findTrashByRecepient(String email, Integer pageCount) {
        List<UserEmail> emails = findUserEmail.query().where().eq("userEmail.email", email)
                .eq("deleted", true).orderBy("updatedAt desc").findList();
        if (emails.size() >= EMAILS_PER_PAGE*pageCount) {
            return emails.subList((pageCount - 1)*EMAILS_PER_PAGE, (pageCount*EMAILS_PER_PAGE));
        }
        if (emails.size() > EMAILS_PER_PAGE*(pageCount -1)) {
            return emails.subList((pageCount - 1)*EMAILS_PER_PAGE, emails.size());
        }
        return new ArrayList<>();
    }

    @Override
    public List<Draft> findDrafts(String email, Integer pageCount) {
        List<Draft> emails =  findDraft.query().where().eq("fromEmail.email", email).orderBy("updatedAt desc").findList();
        if (emails.size() >= EMAILS_PER_PAGE*pageCount) {
            return emails.subList((pageCount - 1)*EMAILS_PER_PAGE, (pageCount*EMAILS_PER_PAGE));
        }
        if (emails.size() > EMAILS_PER_PAGE*(pageCount -1)) {
            return emails.subList((pageCount - 1)*EMAILS_PER_PAGE, emails.size());
        }
        return new ArrayList<>();
    }

    @Override
    public Boolean markAsRead(Long emailId, User user) {
        UserEmail userEmail = findUserEmail.query().where().eq("userEmail.email", user.email).eq("email.id", emailId).findUnique();
        if (userEmail != null && userEmail.readState == ReadState.UNREAD) {
            userEmail.readState = ReadState.READ;
            userEmail.save();
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteEmail(Long id, User user) {
        UserEmail userEmail = findUserEmail.query().where().eq("userEmail.email", user.email).eq("email.id", id).findUnique();
        if (userEmail != null ) {
            userEmail.deleted = true;
            userEmail.save();
            return true;
        }
        return false;
    }

    @Override
    public Email replyToEmail(Long id, User user, String subject, String body) {
        UserEmail userEmail = findUserEmail.byId(id);
        if (userEmail != null ) {
            String from = user.email;
            List<String> to = new ArrayList<>();
            to.add(userEmail.email.fromEmail.email);
            if (subject == null) {
                subject = "Re:" +userEmail.email.subject;
            }
            Email replyMail = this.send(from, to, subject, body);
            replyMail.parentEmail = userEmail.email;
            replyMail.save();
            return replyMail;
        }
        return null;
    }
}
