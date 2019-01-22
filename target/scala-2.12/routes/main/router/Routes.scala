// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/prabal/Workspace/codebase/java/play-email/email-ws/conf/routes
// @DATE:Mon Jan 21 20:49:19 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:9
  Assets_4: controllers.Assets,
  // @LINE:11
  UserController_2: controllers.UserController,
  // @LINE:13
  UserAuthController_3: controllers.UserAuthController,
  // @LINE:16
  EmailController_0: controllers.EmailController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:9
    Assets_4: controllers.Assets,
    // @LINE:11
    UserController_2: controllers.UserController,
    // @LINE:13
    UserAuthController_3: controllers.UserAuthController,
    // @LINE:16
    EmailController_0: controllers.EmailController
  ) = this(errorHandler, HomeController_1, Assets_4, UserController_2, UserAuthController_3, EmailController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, Assets_4, UserController_2, UserAuthController_3, EmailController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/create""", """controllers.UserController.createUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.UserAuthController.login()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.UserAuthController.logout()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """emails/send""", """controllers.EmailController.send()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """emails/saveDraft""", """controllers.EmailController.saveDraft()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """emails/markAsRead""", """controllers.EmailController.markAsRead()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """emails/deleteEmail""", """controllers.EmailController.deleteEmail()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """emails/deleteDraft""", """controllers.EmailController.deleteDraft()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """emails/inbox/all/user/""" + "$" + """email<[^/]+>/page/""" + "$" + """pageCount<[^/]+>""", """controllers.EmailController.inbox(email:String, pageCount:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """emails/inbox/unread/user/""" + "$" + """email<[^/]+>/page/""" + "$" + """pageCount<[^/]+>""", """controllers.EmailController.inboxUnread(email:String, pageCount:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """emails/sent/user/""" + "$" + """email<[^/]+>/page/""" + "$" + """pageCount<[^/]+>""", """controllers.EmailController.sent(email:String, pageCount:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """emails/trash/user/""" + "$" + """email<[^/]+>/page/""" + "$" + """pageCount<[^/]+>""", """controllers.EmailController.trash(email:String, pageCount:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """emails/drafts/user/""" + "$" + """email<[^/]+>/page/""" + "$" + """pageCount<[^/]+>""", """controllers.EmailController.drafts(email:String, pageCount:Integer)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_UserController_createUser2_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/create")))
  )
  private[this] lazy val controllers_UserController_createUser2_invoker = createInvoker(
    UserController_2.createUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "createUser",
      Nil,
      "PUT",
      this.prefix + """users/create""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UserAuthController_login3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_UserAuthController_login3_invoker = createInvoker(
    UserAuthController_3.login(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserAuthController",
      "login",
      Nil,
      "POST",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_UserAuthController_logout4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_UserAuthController_logout4_invoker = createInvoker(
    UserAuthController_3.logout(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserAuthController",
      "logout",
      Nil,
      "POST",
      this.prefix + """logout""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_EmailController_send5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("emails/send")))
  )
  private[this] lazy val controllers_EmailController_send5_invoker = createInvoker(
    EmailController_0.send(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmailController",
      "send",
      Nil,
      "POST",
      this.prefix + """emails/send""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_EmailController_saveDraft6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("emails/saveDraft")))
  )
  private[this] lazy val controllers_EmailController_saveDraft6_invoker = createInvoker(
    EmailController_0.saveDraft(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmailController",
      "saveDraft",
      Nil,
      "POST",
      this.prefix + """emails/saveDraft""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_EmailController_markAsRead7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("emails/markAsRead")))
  )
  private[this] lazy val controllers_EmailController_markAsRead7_invoker = createInvoker(
    EmailController_0.markAsRead(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmailController",
      "markAsRead",
      Nil,
      "POST",
      this.prefix + """emails/markAsRead""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_EmailController_deleteEmail8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("emails/deleteEmail")))
  )
  private[this] lazy val controllers_EmailController_deleteEmail8_invoker = createInvoker(
    EmailController_0.deleteEmail(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmailController",
      "deleteEmail",
      Nil,
      "POST",
      this.prefix + """emails/deleteEmail""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_EmailController_deleteDraft9_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("emails/deleteDraft")))
  )
  private[this] lazy val controllers_EmailController_deleteDraft9_invoker = createInvoker(
    EmailController_0.deleteDraft(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmailController",
      "deleteDraft",
      Nil,
      "DELETE",
      this.prefix + """emails/deleteDraft""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_EmailController_inbox10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("emails/inbox/all/user/"), DynamicPart("email", """[^/]+""",true), StaticPart("/page/"), DynamicPart("pageCount", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EmailController_inbox10_invoker = createInvoker(
    EmailController_0.inbox(fakeValue[String], fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmailController",
      "inbox",
      Seq(classOf[String], classOf[Integer]),
      "GET",
      this.prefix + """emails/inbox/all/user/""" + "$" + """email<[^/]+>/page/""" + "$" + """pageCount<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_EmailController_inboxUnread11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("emails/inbox/unread/user/"), DynamicPart("email", """[^/]+""",true), StaticPart("/page/"), DynamicPart("pageCount", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EmailController_inboxUnread11_invoker = createInvoker(
    EmailController_0.inboxUnread(fakeValue[String], fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmailController",
      "inboxUnread",
      Seq(classOf[String], classOf[Integer]),
      "GET",
      this.prefix + """emails/inbox/unread/user/""" + "$" + """email<[^/]+>/page/""" + "$" + """pageCount<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_EmailController_sent12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("emails/sent/user/"), DynamicPart("email", """[^/]+""",true), StaticPart("/page/"), DynamicPart("pageCount", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EmailController_sent12_invoker = createInvoker(
    EmailController_0.sent(fakeValue[String], fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmailController",
      "sent",
      Seq(classOf[String], classOf[Integer]),
      "GET",
      this.prefix + """emails/sent/user/""" + "$" + """email<[^/]+>/page/""" + "$" + """pageCount<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_EmailController_trash13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("emails/trash/user/"), DynamicPart("email", """[^/]+""",true), StaticPart("/page/"), DynamicPart("pageCount", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EmailController_trash13_invoker = createInvoker(
    EmailController_0.trash(fakeValue[String], fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmailController",
      "trash",
      Seq(classOf[String], classOf[Integer]),
      "GET",
      this.prefix + """emails/trash/user/""" + "$" + """email<[^/]+>/page/""" + "$" + """pageCount<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_EmailController_drafts14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("emails/drafts/user/"), DynamicPart("email", """[^/]+""",true), StaticPart("/page/"), DynamicPart("pageCount", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EmailController_drafts14_invoker = createInvoker(
    EmailController_0.drafts(fakeValue[String], fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmailController",
      "drafts",
      Seq(classOf[String], classOf[Integer]),
      "GET",
      this.prefix + """emails/drafts/user/""" + "$" + """email<[^/]+>/page/""" + "$" + """pageCount<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:9
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_4.versioned(path, file))
      }
  
    // @LINE:11
    case controllers_UserController_createUser2_route(params@_) =>
      call { 
        controllers_UserController_createUser2_invoker.call(UserController_2.createUser())
      }
  
    // @LINE:13
    case controllers_UserAuthController_login3_route(params@_) =>
      call { 
        controllers_UserAuthController_login3_invoker.call(UserAuthController_3.login())
      }
  
    // @LINE:14
    case controllers_UserAuthController_logout4_route(params@_) =>
      call { 
        controllers_UserAuthController_logout4_invoker.call(UserAuthController_3.logout())
      }
  
    // @LINE:16
    case controllers_EmailController_send5_route(params@_) =>
      call { 
        controllers_EmailController_send5_invoker.call(EmailController_0.send())
      }
  
    // @LINE:17
    case controllers_EmailController_saveDraft6_route(params@_) =>
      call { 
        controllers_EmailController_saveDraft6_invoker.call(EmailController_0.saveDraft())
      }
  
    // @LINE:18
    case controllers_EmailController_markAsRead7_route(params@_) =>
      call { 
        controllers_EmailController_markAsRead7_invoker.call(EmailController_0.markAsRead())
      }
  
    // @LINE:19
    case controllers_EmailController_deleteEmail8_route(params@_) =>
      call { 
        controllers_EmailController_deleteEmail8_invoker.call(EmailController_0.deleteEmail())
      }
  
    // @LINE:21
    case controllers_EmailController_deleteDraft9_route(params@_) =>
      call { 
        controllers_EmailController_deleteDraft9_invoker.call(EmailController_0.deleteDraft())
      }
  
    // @LINE:23
    case controllers_EmailController_inbox10_route(params@_) =>
      call(params.fromPath[String]("email", None), params.fromPath[Integer]("pageCount", None)) { (email, pageCount) =>
        controllers_EmailController_inbox10_invoker.call(EmailController_0.inbox(email, pageCount))
      }
  
    // @LINE:24
    case controllers_EmailController_inboxUnread11_route(params@_) =>
      call(params.fromPath[String]("email", None), params.fromPath[Integer]("pageCount", None)) { (email, pageCount) =>
        controllers_EmailController_inboxUnread11_invoker.call(EmailController_0.inboxUnread(email, pageCount))
      }
  
    // @LINE:25
    case controllers_EmailController_sent12_route(params@_) =>
      call(params.fromPath[String]("email", None), params.fromPath[Integer]("pageCount", None)) { (email, pageCount) =>
        controllers_EmailController_sent12_invoker.call(EmailController_0.sent(email, pageCount))
      }
  
    // @LINE:26
    case controllers_EmailController_trash13_route(params@_) =>
      call(params.fromPath[String]("email", None), params.fromPath[Integer]("pageCount", None)) { (email, pageCount) =>
        controllers_EmailController_trash13_invoker.call(EmailController_0.trash(email, pageCount))
      }
  
    // @LINE:28
    case controllers_EmailController_drafts14_route(params@_) =>
      call(params.fromPath[String]("email", None), params.fromPath[Integer]("pageCount", None)) { (email, pageCount) =>
        controllers_EmailController_drafts14_invoker.call(EmailController_0.drafts(email, pageCount))
      }
  }
}
