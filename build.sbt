

val appName = "phone-number-stubs"

lazy val scalaCompilerOptions = Seq(
  "-Xlint:-missing-interpolator,_",
  "-Ywarn-unused:imports",
  "-Ywarn-unused:privates",
  "-Ywarn-unused:locals",
  "-Ywarn-unused:explicits",
  "-Ywarn-unused:implicits",
  "-Ywarn-value-discard",
  "-Ywarn-unused:patvars",
  "-Ywarn-dead-code",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-language:implicitConversions"
)
lazy val microservice = Project(appName, file("."))
  .enablePlugins(play.sbt.PlayScala, SbtDistributablesPlugin)
  .settings(
    majorVersion := 0,
    scalaVersion := "2.13.8",
    libraryDependencies ++= AppDependencies.compile,
    libraryDependencies ++= AppDependencies.test,
    // ***************
    scalacOptions ++= scalaCompilerOptions,
    scalacOptions += "-Wconf:src=routes/.*:s",
    scalacOptions ++= Seq(
      "-Wconf:src=routes/.*:s",
      "-Wconf:src=.+/test/.+:s",
      "-Wconf:cat=deprecation&msg=\\.*()\\.*:s",
      "-Wconf:cat=unused-imports&site=<empty>:s",
      "-Wconf:cat=unused&src=.*RoutesPrefix\\.scala:s",
      "-Wconf:cat=unused&src=.*Routes\\.scala:s"
    )
    // ***************
  )
  .settings(
    Compile / scalafmtOnCompile := true,
    Test / scalafmtOnCompile := true,
    IntegrationTest / scalafmtOnCompile := true,
  )
  .settings(
    PlayKeys.playDefaultPort := 6099
  )
  .settings(resolvers += Resolver.jcenterRepo)
