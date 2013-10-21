name := "functional-programming"

version := "1.0-SNAPSHOT"

resolvers ++= Seq(
  "namin.github.com/maven-repository" at "http://namin.github.com/maven-repository/",
  "Spray Repository" at "http://repo.spray.cc/"
)

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "net.databinder" %% "dispatch-http" % "0.8.8",
  "org.scalastyle" % "scalastyle_2.9.1" % "0.1.3-SNAPSHOT",
  "cc.spray" %%  "spray-json" % "1.1.1",
  "org.scalatest" %% "scalatest" % "1.9.1",
  "org.apache.commons" % "commons-lang3" % "3.1"
)     

play.Project.playScalaSettings
