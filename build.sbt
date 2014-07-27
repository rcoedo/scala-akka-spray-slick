name := "scala-akka-spray-slick"

version := "1.0"

libraryDependencies ++= {
  val sprayVersion = "1.3.1"
  val akkaVersion = "2.3.4"
  val slickVersion = "2.0.2"
  Seq(
    "io.spray" % "spray-routing" % sprayVersion,
    "io.spray" % "spray-can" % sprayVersion,
    "io.spray" % "spray-client" % sprayVersion,
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.slick" %% "slick" % slickVersion,
    "org.json4s" %% "json4s-native" % "3.2.9",
    "org.scalatest" %% "scalatest" % "2.0" % "test",
    "ch.qos.logback" % "logback-classic" % "1.0.13",
    "mysql" % "mysql-connector-java" % "latest.release"
  )
}

resolvers ++= Seq(
  "Spray repository" at "http://repo.spray.io",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)
