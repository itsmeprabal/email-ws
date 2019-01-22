// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/prabal/Workspace/codebase/java/play-email/email-ws/conf/routes
// @DATE:Mon Jan 21 20:49:19 IST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:11
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def createUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.createUser",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "users/create"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseEmailController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def inbox: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EmailController.inbox",
      """
        function(email0,pageCount1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "emails/inbox/all/user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("email", email0)) + "/page/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("pageCount", pageCount1))})
        }
      """
    )
  
    // @LINE:24
    def inboxUnread: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EmailController.inboxUnread",
      """
        function(email0,pageCount1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "emails/inbox/unread/user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("email", email0)) + "/page/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("pageCount", pageCount1))})
        }
      """
    )
  
    // @LINE:25
    def sent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EmailController.sent",
      """
        function(email0,pageCount1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "emails/sent/user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("email", email0)) + "/page/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("pageCount", pageCount1))})
        }
      """
    )
  
    // @LINE:18
    def markAsRead: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EmailController.markAsRead",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "emails/markAsRead"})
        }
      """
    )
  
    // @LINE:28
    def drafts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EmailController.drafts",
      """
        function(email0,pageCount1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "emails/drafts/user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("email", email0)) + "/page/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("pageCount", pageCount1))})
        }
      """
    )
  
    // @LINE:17
    def saveDraft: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EmailController.saveDraft",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "emails/saveDraft"})
        }
      """
    )
  
    // @LINE:19
    def deleteEmail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EmailController.deleteEmail",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "emails/deleteEmail"})
        }
      """
    )
  
    // @LINE:26
    def trash: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EmailController.trash",
      """
        function(email0,pageCount1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "emails/trash/user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("email", email0)) + "/page/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("pageCount", pageCount1))})
        }
      """
    )
  
    // @LINE:16
    def send: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EmailController.send",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "emails/send"})
        }
      """
    )
  
    // @LINE:21
    def deleteDraft: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EmailController.deleteDraft",
      """
        function() {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "emails/deleteDraft"})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseUserAuthController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserAuthController.logout",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
        }
      """
    )
  
    // @LINE:13
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserAuthController.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }


}
