package models;

import io.ebean.Model;
import io.ebean.annotation.Index;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "drafts")
public class Draft extends Model {
    @Id
    public Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_email", referencedColumnName = "email")
    @Index
    public User fromEmail;

    public String toEmails;

    public String subject;

    @Lob
    public String body;

    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt;

    public Draft(User from, String toEmails, String subject, String body) {
        this.fromEmail = from;
        this.toEmails = toEmails;
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
