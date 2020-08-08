val root = (project in file("."))
  .settings(
    scalaVersion := "2.12.12",
    scalacOptions ++= Seq(
      "-feature", "-unchecked", "-deprecation", "-Xlint:_",
      "-language:higherKinds",
      "-Ypartial-unification",
      "-Ywarn-infer-any", "-Ywarn-macros:after", "-Ywarn-nullary-override", "-Ywarn-nullary-unit",
      "-Ywarn-unused-import",
    ),
    libraryDependencies ++= Seq(
      "com.lihaoyi" % "ammonite" % "2.2.0" cross CrossVersion.full,
    ),
    scapegoatVersion in ThisBuild := "1.3.8",
    assemblyMergeStrategy in assembly := {
      case PathList("reflect.properties") => MergeStrategy.discard
      case x => (assemblyMergeStrategy in assembly).value(x)
    },
  )
