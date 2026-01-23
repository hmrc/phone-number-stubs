
val appName = "phone-number-stubs"

ThisBuild / majorVersion := 1
ThisBuild / scalaVersion := "3.3.7"

lazy val microservice = Project(appName, file("."))
  .enablePlugins(PlayScala, SbtDistributablesPlugin)
  .settings(
    libraryDependencies ++= AppDependencies(),
    scalacOptions += "-Wconf:src=routes/.*:s",
    scalafmtOnCompile := true,
    PlayKeys.playDefaultPort := 6099
  )
