ThisBuild / scalaVersion := "2.13.3"
ThisBuild / version := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  // (experimental feature) in-place code update with state preservation
  // enablePlugins(WorkbenchSplicePlugin) // disable WorkbenchPlugin when activating
  .enablePlugins(ScalaJSPlugin, WorkbenchPlugin)
  .settings(
    name := "example",
    // Warn if an import selector is not referenced.
    scalacOptions += "-Wunused:imports",
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "1.1.0"
    )
  )
