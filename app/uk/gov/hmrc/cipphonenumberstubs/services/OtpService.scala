/*
 * Copyright 2022 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.cipphonenumberstubs.services

import play.api.Logging
import play.api.libs.json.Json
import play.api.mvc.Result
import play.api.mvc.Results.Ok
import play.api.mvc.Results.NotFound
import uk.gov.hmrc.cipphonenumberstubs.dao.{DatabaseHelper, OtpData}
import uk.gov.hmrc.cipphonenumberstubs.services.responses.GetOtpResponse

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton()
class OtpService @Inject()(databaseHelper: DatabaseHelper)(implicit val executionContext: ExecutionContext) extends Logging {

  def retrieveOtp(enteredNotificationId: String): Future[Result] = {
    databaseHelper.retrieveOtp(enteredNotificationId).flatMap(x => processGetOtpResult(enteredNotificationId, x))
  }

  private def processGetOtpResult(enteredNotificationId: String, maybeOptData: Option[OtpData]): Future[Result] = maybeOptData match {
    case Some(otpData) => buildGetOtpResponse(otpData)
    case _ => logger.debug(s"No data found for $enteredNotificationId")
              Future.successful(NotFound(s"No data found for $enteredNotificationId"))
  }

  private def buildGetOtpResponse(otpData: OtpData): Future[Result] = {
    val otpResponseObj: GetOtpResponse = new GetOtpResponse(otpData.notificationId, otpData.otp)
    logger.debug(s"returning retrieve Otp response $otpResponseObj")
    Future.successful(Ok(Json.toJson(GetOtpResponse(otpData.notificationId, otpData.otp))))
  }

}
