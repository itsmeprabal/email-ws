package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

import static utils.Utility.getSha512;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(value = { "password", "authToken" })
public class User extends Model {
    @Id
    @Column(length = 256, unique = true, nullable = false)
    @Constraints.MaxLength(256)
    @Constraints.Required
    @Constraints.Email
    public String email;

    public String authToken;

    @Column(length = 256, nullable = false)
    @Constraints.Required
    @Constraints.MaxLength(256)
    public String name;

    @Transient
    @Constraints.Required
    @Constraints.MinLength(6)
    @Constraints.MaxLength(256)
    @JsonIgnore
    public String password;

    @Column(length = 64, nullable = false)
    @JsonIgnore
    public byte[] shaPassword;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt;

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.shaPassword = getSha512(password);
    }

    public String createAndGetAuthToken() {
        authToken = UUID.randomUUID().toString();
        save();
        return authToken;
    }

    public void deleteAuthToken() {
        authToken = null;
        save();
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
