import sbt._

object AppDependencies {

  val hmrcBootstrapVersion = "9.12.0"
  val compile = Seq(
    "uk.gov.hmrc"                   %% "bootstrap-backend-play-30"  % hmrcBootstrapVersion,
  )
  val test = Seq(
    "uk.gov.hmrc"                   %% "bootstrap-test-play-30"  % hmrcBootstrapVersion % Test,
  )
}
