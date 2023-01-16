ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaPractice"
  )

// https://mvnrepository.com/artifact/org.mongodb.scala/mongo-scala-driver
//libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "4.8.1"
