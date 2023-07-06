import sbt._

object AppDependencies {

  val hmrcBootstrapVersion = "7.19.0"
  val compile = Seq(
    "uk.gov.hmrc"                   %% "bootstrap-backend-play-28"  % hmrcBootstrapVersion,
  )
  val test = Seq(
    "uk.gov.hmrc"                   %% "bootstrap-test-play-28"  % hmrcBootstrapVersion % Test,
  )
}
