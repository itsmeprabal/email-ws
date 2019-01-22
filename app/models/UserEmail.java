package models;

import io.ebean.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "user_emails")
public class UserEmail extends Model {
    @Id
    public Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    @io.ebean.annotation.Index
    public User userEmail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "email_id", referencedColumnName = "id")
    @io.ebean.annotation.Index
    public Email email;

    @Enumerated(EnumType.STRING)
    public ReadState readState;

    public Boolean deleted;

    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt;

    public UserEmail(User user, Email email) {
        this.userEmail = user;
        this.email = email;
        this.readState = ReadState.UNREAD;
        this.deleted = false;
    }

    @PrePersist
    public void onPrePersist(){
        this.createdAt = new Date();
        this.updatedAt = createdAt;
    }

    @PreUpdate
    public void onPreUpdate(){
        this.updatedAt = new Date();
    }
}
