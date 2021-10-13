resolvers ++= Seq(
  Resolver.typesafeRepo("releases"),
  Resolver.sbtPluginRepo("releases")
)

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.7.1")
