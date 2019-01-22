package serviceimpl;

import io.ebean.Finder;
import models.User;
import service.IUserService;

import java.util.Set;

import static utils.Utility.getSha512;

public class UserService implements IUserService {
    private static final Finder<Long, User> find = new Finder<>(User.class);

    @Override
    public User findByEmail(String email) {
        return find.query().where().eq("email", email).findUnique();
    }

    @Override
    public User createNew(String email, String name, String password) {
        if (email == null || email.length() == 0) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (password == null || password.length() == 0) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        User newUser = new User(email, name, password);
        newUser.save();
        return newUser;
    }

    @Override
    public User authenticate(String email, String password) {
        return find.query().where().eq("email", email).eq("shaPassword", getSha512(password)).findUnique();
    }

    @Override
    public User findByAuthToken(String authToken) {
        if (authToken == null) {
            return null;
        }

        try {
            return find.query().where().eq("authToken", authToken).findUnique();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Set<User> findByEmailSet(Set<String> emails) {
        return find.query().where().idIn(emails).findSet();
    }
}
