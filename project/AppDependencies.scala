import sbt._

object AppDependencies {

  val hmrcBootstrapVersion = "5.23.2-RC2"
  val compile = Seq(
    "uk.gov.hmrc"                   %% "bootstrap-backend-play-28"  % hmrcBootstrapVersion,
  )
}
