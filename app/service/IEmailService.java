package service;

import com.google.inject.ImplementedBy;
import models.Draft;
import models.Email;
import models.User;
import models.UserEmail;
import serviceimpl.EmailService;

import java.util.List;

@ImplementedBy(EmailService.class)
public interface IEmailService {
    Draft saveDraft(String from, String to, String subject, String body);
    Draft updateDraft(Long id, String to, String subject, String body, User user);
    Boolean deleteDraft(Long id, User user);

    Boolean markAsRead(Long emailId, User user);
    Email send(String from, List<String> to, String subject, String body);
    Boolean deleteEmail(Long id, User user);

    List<Email> findBySender(String email, Integer pageCount);
    List<UserEmail> findByRecepient(String email, Integer pageCount);
    List<UserEmail> findUnreadByRecepient(String email, Integer pageCount);
    List<UserEmail> findTrashByRecepient(String email, Integer pageCount);

    List<Draft> findDrafts(String email, Integer pageCount);

}
