// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/prabal/Workspace/codebase/java/play-email/email-ws/conf/routes
// @DATE:Mon Jan 21 20:49:19 IST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
