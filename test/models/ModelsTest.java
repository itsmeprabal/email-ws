package models;

import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;
import serviceimpl.EmailService;
import serviceimpl.UserService;
import utils.Utility;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static play.test.Helpers.*;

public class ModelsTest extends WithApplication {
    private static final String email = "prabal@gmail.com";
    private static final String password = "password";
    private static final String name = "Prabal";
    private static User user;
    private static UserService userService;
    private static EmailService emailService;

    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
        userService = new UserService();
        user = userService.createNew(email, name, password);
        emailService = new EmailService(userService);
    }

    @Test
    public void userCreateAndFetchTest() {
        User user = new User("foo@foo.com","John Doe", "password");
        user.save();
        assertNotNull(user.email);
        assertEquals("John Doe", user.name);

        try {
            Field field = User.class.getDeclaredField("shaPassword");
            field.setAccessible(true);
            assertArrayEquals(Utility.getSha512("password"), (byte[])field.get(user));
            assertEquals(64, ((byte[])field.get(user)).length); // 512 bits = 64 bytes
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void authenticateUserTest() {
        assertNotNull(userService.authenticate(email, password));
        assertEquals(userService.authenticate(email, password).email, email);
        assertNull(userService.authenticate(email, "wrong"));
        assertNull(userService.authenticate("pc@gmail.com", password));
    }

    @Test
    public void findEmailBySenderTest() {
        User receiver = userService.createNew("xyz@gmail.com", "XYZ", "xxyyzz");

        List<String> rec = new ArrayList<>();
        rec.add(receiver.email);
        emailService.send(user.email, rec, "subject1", "email send out to someone");

        rec.add(email);
        emailService.send(user.email, rec, "subject2", "email sent out to someone and myself");

        List<Email> sentByMe = emailService.findBySender(user.email, 1);
        assertEquals(2, sentByMe.size());
    }

    @Test
    public void findEmailsByRecepientTest1() {
        User receiver = userService.createNew("xyz@gmail.com", "XYZ", "xxyyzz");

        List<String> rec = new ArrayList<>();
        rec.add(receiver.email);
        emailService.send(user.email, rec, "subj1", "email send out to someone");

        List<UserEmail> recvcByOther = emailService.findByRecepient(receiver.email, 1);
        assertEquals(1, recvcByOther.size());
    }
}
