addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.7.1")
addSbtPlugin("com.lucidchart" % "sbt-scalafmt" % "1.16")
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.9.31")

lazy val workbench = RootProject(file("../.."))
lazy val root = project.in(file(".")).dependsOn(workbench)
