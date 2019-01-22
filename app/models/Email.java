package models;

import io.ebean.Model;
import io.ebean.annotation.Index;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "emails")
public class Email extends Model {
    @Id
    public Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_email", referencedColumnName = "email")
    @Index
    public User fromEmail;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Index
    public Set<User> toEmails;

    @Constraints.Required
    @Constraints.MinLength(3)
    @Constraints.MaxLength(256)
    public String subject;

    @Lob
    @Constraints.Required
    public String body;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_email", referencedColumnName = "id")
    public Email parentEmail;

    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt;

    public Email(User from, Set<User> to, String subject, String body) {
        this.fromEmail = from;
        this.toEmails = to;
        this.subject = subject;
        this.body = body;
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
