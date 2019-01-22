package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;
import service.IUserService;
import utils.Login;

import javax.inject.Inject;

import static utils.Constants.AUTH_TOKEN;

public class UserAuthController extends Controller {

    @Inject
    FormFactory formFactory;
    @Inject
    IUserService userService;

    public static User getUser() {
        return (User)Http.Context.current().args.get("user");
    }

    // returns an authToken
    public Result login() {
        Form<Login> loginForm = formFactory.form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(loginForm.errorsAsJson());
        }

        Login login = loginForm.get();
        User user = userService.authenticate(login.email, login.password);

        if (user == null) {
            return unauthorized("Wrong username or password");
        }
        else {
            String userAuthToken = user.createAndGetAuthToken();
            ObjectNode authTokenJson = Json.newObject();
            authTokenJson.put(AUTH_TOKEN, userAuthToken);
            response().setCookie(Http.Cookie.builder(AUTH_TOKEN, userAuthToken).withSecure(ctx().request().secure()).build());
            return ok(authTokenJson);
        }
    }

    @Security.Authenticated(UserAuthenticator.class)
    public Result logout() {
        response().discardCookie(AUTH_TOKEN);
        getUser().deleteAuthToken();
        return redirect("/");
    }

}
