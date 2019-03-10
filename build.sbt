import scalariform.formatter.preferences._

val scalaVersion_2_11 = "2.11.8"
val scalaVersion_2_12 = "2.12.2"

name := """play-json-naming"""

version := "1.2.0"

scalaVersion := scalaVersion_2_11

crossScalaVersions := Seq(scalaVersion_2_11, scalaVersion_2_12)

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.6.0" % "provided",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

organization := "com.github.tototoshi"

scalariformPreferences := scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(DoubleIndentConstructorArguments, true)
  .setPreference(DanglingCloseParenthesis, Preserve)

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomExtra := 
  <url>http://github.com/tototoshi/play-json-naming</url>
  <licenses>
    <license>
      <name>Apache License, Version 2.0</name>
      <url>http://github.com/tototoshi/play-json-naming/blob/master/LICENSE.txt</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:tototoshi/play-json-naming.git</url>
    <connection>scm:git:git@github.com:tototoshi/play-json-naming.git</connection>
  </scm>
  <developers>
    <developer>
      <id>tototoshi</id>
      <name>Toshiyuki Takahashi</name>
      <url>http://tototoshi.github.com</url>
    </developer>
  </developers>
