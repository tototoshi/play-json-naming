import scalariform.formatter.preferences._

val scalaVersion_2_12 = "2.12.15"
val scalaVersion_2_13 = "2.13.6"

name := """play-json-naming"""

version := "1.5.1-SNAPSHOT"

scalaVersion := scalaVersion_2_13

crossScalaVersions := Seq(scalaVersion_2_12, scalaVersion_2_13)

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.9.2" % "provided",
  "org.scalatest" %% "scalatest" % "3.2.10" % "test"
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
  <url>https://github.com/tototoshi/play-json-naming</url>
  <licenses>
    <license>
      <name>Apache License, Version 2.0</name>
      <url>https://github.com/tototoshi/play-json-naming/blob/master/LICENSE.txt</url>
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
      <url>https://tototoshi.github.com</url>
    </developer>
  </developers>
