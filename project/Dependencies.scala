import sbt._
import Keys._

object Dependencies {

  lazy val logbackClassic = "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime"
  lazy val slf4jApi = "org.slf4j" % "slf4j-api" % "1.7.25"
  lazy val scalatest = "org.scalatest" %% "scalatest" % "3.0.8" % "test"
  lazy val seleniumJava = "org.seleniumhq.selenium" % "selenium-java" % "3.141.59"

  lazy val fragnosticConf = "com.fragnostic" % "fragnostic-conf_2.13" % "0.1.11"
  lazy val fragnosticSupport = "com.fragnostic" % "fragnostic-support_2.13" % "0.1.12"

}
