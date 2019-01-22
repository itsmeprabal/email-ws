// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/prabal/Workspace/codebase/java/play-email/email-ws/conf/routes
// @DATE:Mon Jan 21 20:49:19 IST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:11
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def createUser(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users/create")
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:16
  class ReverseEmailController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def inbox(email:String, pageCount:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "emails/inbox/all/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("email", email)) + "/page/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("pageCount", pageCount)))
    }
  
    // @LINE:24
    def inboxUnread(email:String, pageCount:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "emails/inbox/unread/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("email", email)) + "/page/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("pageCount", pageCount)))
    }
  
    // @LINE:25
    def sent(email:String, pageCount:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "emails/sent/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("email", email)) + "/page/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("pageCount", pageCount)))
    }
  
    // @LINE:18
    def markAsRead(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "emails/markAsRead")
    }
  
    // @LINE:28
    def drafts(email:String, pageCount:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "emails/drafts/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("email", email)) + "/page/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("pageCount", pageCount)))
    }
  
    // @LINE:17
    def saveDraft(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "emails/saveDraft")
    }
  
    // @LINE:19
    def deleteEmail(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "emails/deleteEmail")
    }
  
    // @LINE:26
    def trash(email:String, pageCount:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "emails/trash/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("email", email)) + "/page/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("pageCount", pageCount)))
    }
  
    // @LINE:16
    def send(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "emails/send")
    }
  
    // @LINE:21
    def deleteDraft(): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "emails/deleteDraft")
    }
  
  }

  // @LINE:13
  class ReverseUserAuthController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def logout(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "logout")
    }
  
    // @LINE:13
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
  }


}
