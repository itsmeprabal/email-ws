package service;

import com.google.inject.ImplementedBy;
import models.User;
import serviceimpl.UserService;

import java.util.Set;

@ImplementedBy(UserService.class)
public interface IUserService {
    User findByEmail(String email);
    User createNew(String email, String name, String password);
    User authenticate(String email, String password);
    User findByAuthToken(String authToken);
    Set<User> findByEmailSet(Set<String> emails);
}
