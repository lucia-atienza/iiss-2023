name := "BookStore"

version := "1.0"

scalaVersion := "2.13.10"

libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.6.16",
    "com.typesafe.akka" %% "akka-stream" % "2.6.16",
    "com.typesafe.akka" %% "akka-http" % "10.2.6"
)
