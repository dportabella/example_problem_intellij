name := "example_problem_intellij"

version := "0.1-SNAPSHOT"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

initialize := {
  val _ = initialize.value
  if (sys.props("java.specification.version") != "1.8")
    sys.error("Java 8 is required for this project.")
}

scalaVersion := "2.10.6"

resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.6.1",
  "org.warcbase" % "warcbase-core" % "0.1.0-SNAPSHOT",
  "xml-apis" % "xml-apis" % "1.4.01"
)
