package controllers;

import models.User;
import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;
import service.IUserService;

import javax.inject.Inject;

import static utils.Constants.AUTH_TOKEN_HEADER_KEY;

public class UserAuthenticator extends Security.Authenticator {
    @Inject
    IUserService userService;

    @Override
    public String getUsername(Context context) {
        String[] authTokenHeaderFound = context.request().headers().get(AUTH_TOKEN_HEADER_KEY);
        if ((authTokenHeaderFound != null) && (authTokenHeaderFound.length == 1) && (authTokenHeaderFound[0] != null)) {
            User user = userService.findByAuthToken(authTokenHeaderFound[0]);
            if (user != null) {
                context.args.put("user", user);
                return user.email;
            }
        }
        return null;
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return unauthorized("Could not authorize user with provided email and password");
    }

}
