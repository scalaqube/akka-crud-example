lazy val akkaHttpVersion = "10.0.7"
lazy val akkaVersion = "2.5.2"

scalacOptions += "-Ypartial-unification"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.3"
    )),
    name := "server",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-xml" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream" % akkaVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.3",
     "ch.qos.logback" % "logback-classic" % "1.2.3",
      "com.typesafe.akka" % "akka-slf4j_2.12" % "2.5.6",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.7.0",
      "org.typelevel" % "cats-core_2.12" % "1.0.0-MF",
      "io.circe" % "circe-core_2.12" % "0.8.0",
      "io.circe" % "circe-generic_2.12" % "0.8.0",
      "io.circe" % "circe-parser_2.12" % "0.8.0",
      "io.circe" % "circe-java8_2.12" % "0.8.0",
      "io.getquill" % "quill-sql_2.12" % "2.1.0",
      "de.heikoseeberger" % "akka-http-circe_2.12" % "1.18.1",
      "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
      "org.scalatest" %% "scalatest" % "3.0.3" % Test,
      "org.mockito" % "mockito-all" % "1.10.19" % "test"
    )
  )
