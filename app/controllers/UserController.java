package controllers;

import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import service.IUserService;
import utils.Utility;

import javax.inject.Inject;
import java.util.Map;

import static utils.Constants.*;

public class UserController extends Controller {
    @Inject
    IUserService userService;

    public Result createUser() {
        Map<String, String> params = Utility.getQueryParamsMapFromJsonBody(request());
        String email = params.get(USER_EMAIL_KEY);
        String name = params.get(USER_NAME_KEY);
        String password = params.get(USER_PASSWORD_KEY);

        try {
            User user = userService.createNew(email, name, password);
            return ok(Json.toJson(user));
        } catch(RuntimeException re) {
            //TODO encapsulation of error messages
            return badRequest(Json.toJson(re.getMessage()));
        }

    }
}
