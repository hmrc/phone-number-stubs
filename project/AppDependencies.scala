import sbt._

object AppDependencies {

  val hmrcBootstrapVersion = "7.2.0"
  val compile = Seq(
    "uk.gov.hmrc"                   %% "bootstrap-backend-play-28"  % hmrcBootstrapVersion,
  )
}
