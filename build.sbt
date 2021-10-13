import sbt.Keys._

inThisBuild(Def.settings(
  version := "0.5.0",
  organization := "com.lihaoyi",
  scalaVersion := "2.12.11",
  scalacOptions ++= Seq("-feature", "-deprecation", "-Ywarn-unused-import"),
  semanticdbEnabled := true, // enable SemanticDB
  semanticdbVersion := scalafixSemanticdb.revision, // only required for Scala 2.x
))

lazy val root = project.in(file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    name := "workbench",
    unmanagedSourceDirectories in Compile += baseDirectory.value /  "shared" / "main" / "scala",
    unmanagedSourceDirectories in Test += baseDirectory.value / "shared" / "test" / "scala",
    publishArtifact in Test := false,
    (resources in Compile) += {
      (fullOptJS in (client, Compile)).value
      (artifactPath in (client, Compile, fullOptJS)).value
    },
    addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.7.1"),
    libraryDependencies ++= Seq(
      Dependencies.akkaHttp,
      Dependencies.akka,
      Dependencies.akkaStream,
      Dependencies.autowire.value,
      Dependencies.upickle.value
    )
  )

lazy val client = project.in(file("client"))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    unmanagedSourceDirectories in Compile += baseDirectory.value / ".." / "shared" / "main" / "scala",
    libraryDependencies ++= Seq(
      Dependencies.autowire.value,
      Dependencies.dom.value,
      Dependencies.upickle.value
    ),
  )
