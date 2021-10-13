addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.7.1")

lazy val workbench = RootProject(file("../.."))
lazy val root = project.in(file(".")).dependsOn(workbench)
