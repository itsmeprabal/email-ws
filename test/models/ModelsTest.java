package models;

import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

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

    /*@Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
        user = User.create(email, name, password);
    }

    @Test
    public void testCreate() {
        User user = new User("foo@foo.com","John Doe", "password");
        user.save();
        assertNotNull(user.email);
        assertEquals("John Doe", user.name);

        try {
            // check the private shaPassword
            Field field = User.class.getDeclaredField("shaPassword");
            field.setAccessible(true);
            assertArrayEquals(User.getSha512("password"), (byte[])field.get(user));
            assertEquals(64, ((byte[])field.get(user)).length); // 512 bits = 64 bytes
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void userCreateAndFetchTest() {
        User pc = User.find.query().where().eq("email", email).findUnique();
        assertNotNull(pc);
        assertEquals(name, pc.name);
    }

    @Test
    public void authenticateUserTest() {
        assertNotNull(User.authenticate(email, password));
        assertNull(User.authenticate(email, "wrong"));
        assertNull(User.authenticate("pc@gmail.com", password));
    }

    @Test
    public void findEmailBySenderTest() {
        User.create("xyz@gmail.com", "XYZ", "xxyyzz");

        List<String> rec = new ArrayList<>();
        rec.add("xyz@gmail.com");
        Email.create(email, rec, "subj1", "email send out to someone");
        rec.add(email);
        Email.create(email, rec, "subj2", "email sent out to someone and myself");

        List<Email> sentByMe = Email.findBySender(email);
        assertEquals(2, sentByMe.size());
    }

    @Test
    public void findEmailsByRecepientTest1() {
        new User("xyz@gmail.com", "XYZ", "xxyyzz").save();

        List<String> rec = new ArrayList<>();
        rec.add("xyz@gmail.com");
        Email.create(email, rec, "subj1", "email send out to someone");

        List<Email> recvcByOther = Email.findByRecepient("xyz@gmail.com");
        assertEquals(1, recvcByOther.size());
    }

    @Test
    public void findEmailsByRecepientTest2() {
        new User("xyz@gmail.com", "XYZ", "xxyyzz").save();

        List<String> rec = new ArrayList<>();
        rec.add("xyz@gmail.com");
        rec.add(email);
        Email.create(email, rec, "subj1", "email send out to someone and myself");

        List<Email> recvdByMe = Email.findByRecepient(email);
        assertEquals(1, recvdByMe.size());
    }*/
}
