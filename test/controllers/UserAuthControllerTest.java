package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.User;
import org.junit.Before;
import org.junit.Test;
import play.libs.Json;
import play.mvc.Result;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;
import static utils.Constants.AUTH_TOKEN_HEADER_KEY;

public class UserAuthControllerTest extends WithApplication {
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
    public void login() {
        ObjectNode loginJson = Json.newObject();
        loginJson.put("email", email);
        loginJson.put("password", password);

        Result result = route(fakeRequest(routes.UserAuthController.login()).bodyJson(loginJson));
        assertEquals(OK, result.status());

        JsonNode json = Json.parse(contentAsString(result));
        assertNotNull(json.get("authToken"));
    }

    @Test
    public void loginWithBadPassword() {
        ObjectNode loginJson = Json.newObject();
        loginJson.put("emailAddress", email);
        loginJson.put("password", "wrong");

        Result result = route(fakeRequest(routes.UserAuthController.login()).bodyJson(loginJson));

        assertEquals(UNAUTHORIZED, result.status());
    }

    @Test
    public void loginWithBadUsername() {
        ObjectNode loginJson = Json.newObject();
        loginJson.put("emailAddress", "email");
        loginJson.put("password", password);

        Result result = route(fakeRequest(routes.UserAuthController.login()).bodyJson(loginJson));

        assertEquals(UNAUTHORIZED, result.status());
    }

    @Test
    public void logout() {
        String authToken = user.createAndGetAuthToken();

        Result result = route(fakeRequest(routes.UserAuthController.logout()).header(AUTH_TOKEN_HEADER_KEY, authToken));

        assertEquals(SEE_OTHER, result.status());
    }*/

}
