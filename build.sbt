name := "functional-programming"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "net.databinder" %% "dispatch-http" % "0.8.8",
  "org.scalastyle" %% "scalastyle" % "0.3.2",
  "org.scalatest" %% "scalatest" % "2.0.RC2",
  "org.apache.commons" % "commons-lang3" % "3.1"
)     

play.Project.playScalaSettings
