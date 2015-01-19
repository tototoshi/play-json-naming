name := """play-json-naming"""

version := "1.0"

scalaVersion := "2.11.5"

crossScalaVersions := Seq("2.10.4", "2.11.5")

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.3.7" % "provided",
  "org.scalatest" %% "scalatest" % "2.1.6" % "test"
)
