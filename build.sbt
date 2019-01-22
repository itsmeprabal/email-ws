
name := """email-ws"""

organization := "com.pc"
version := "1.0-SNAPSHOT"
scalaVersion := "2.12.8"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

libraryDependencies += guice
libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  javaWs,
  evolutions
)

libraryDependencies += "mysql" %  "mysql-connector-java" % "5.1.35"

playEbeanDebugLevel := 4
inConfig(Test)(PlayEbean.scopedSettings)
playEbeanModels in Test := Seq("models.*")