// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/prabal/Workspace/codebase/java/play-email/email-ws/conf/routes
// @DATE:Mon Jan 21 20:49:19 IST 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseEmailController EmailController = new controllers.ReverseEmailController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserAuthController UserAuthController = new controllers.ReverseUserAuthController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseEmailController EmailController = new controllers.javascript.ReverseEmailController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserAuthController UserAuthController = new controllers.javascript.ReverseUserAuthController(RoutesPrefix.byNamePrefix());
  }

}
