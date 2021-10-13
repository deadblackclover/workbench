ThisBuild / scalaVersion := "2.13.3"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision
ThisBuild / scalafixScalaBinaryVersion := scalaBinaryVersion.value

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

// Run scalafmt on compile.
scalafmtOnCompile := true

// Run scalafix on compile.
scalafixOnCompile := true

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
