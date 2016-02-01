name := "Scala ML Experiments"

organization := "org.invisibletech"

version := "0.0.1"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.6" % "test" withSources() withJavadoc(),
  "org.scalacheck" %% "scalacheck" % "1.12.5" % "test" withSources() withJavadoc()
)

initialCommands := "import org.invisibletech.scalamlexperiments._"

