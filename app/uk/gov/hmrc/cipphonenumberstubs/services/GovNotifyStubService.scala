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
import play.api.mvc.Results.{BadRequest, Created, Forbidden, InternalServerError, NotFound, Ok, TooManyRequests}
import uk.gov.hmrc.cipphonenumberstubs.config.AppConfig
import uk.gov.hmrc.cipphonenumberstubs.services.responses.{NotificationResponses, VerificationResponses}

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton()
class GovNotifyStubService @Inject() (implicit val executionContext: ExecutionContext, config: AppConfig) extends Logging {

  def sms(phoneNumber: String): Future[Result] = Future {
    phoneNumber match {
      case "+447430003001" => BadRequest(Json.parse(VerificationResponses.badRequestTeamOnlyError))
      case "+447430003002" => BadRequest(Json.parse(VerificationResponses.badRequestTrialModeOnlyError))
      case "+447430003003" => Forbidden(Json.parse(VerificationResponses.authErrorSystemClockError))
      case "+447430003004" => Forbidden(Json.parse(VerificationResponses.authErrorInvalidTokenError))
      case "+447430003005" => TooManyRequests(Json.parse(VerificationResponses.rateLimitError))
      case "+447430003006" => TooManyRequests(Json.parse(VerificationResponses.tooManyRequestsError))
      case "+447430003007" => InternalServerError(Json.parse(VerificationResponses.exception))
      case _ => Created(Json.parse(VerificationResponses.notificationResponse))
    }
  }

  def status(notificationId: String): Future[Result] = Future {
    notificationId match {
      case "validation-d385-4b17-a0b4-23a85c0c5b1a" => BadRequest(Json.parse(VerificationResponses.validationError))
      case "invalidtoken-d385-4b17-a0b4-23a85c0c5b1a" => Forbidden(Json.parse(VerificationResponses.authErrorInvalidTokenError))
      case "systemclock-d385-4b17-a0b4-23a85c0c5b1a" => Forbidden(Json.parse(VerificationResponses.authErrorSystemClockError))
      case "noresult-d385-4b17-a0b4-23a85c0c5b1a" => NotFound(Json.parse(VerificationResponses.noResultFoundError))
      case _ => Ok(Json.parse(parseNotificationResponse(notificationId)))
    }
  }

  def parseNotificationResponse(notificationId: String) = {
    notificationId match {
      case "16770ea0-d385-4b17-a0b4-23a85c0c5b1a" => NotificationResponses.permanentFailure
      case "26770ea0-d385-4b17-a0b4-23a85c0c5b1a" => NotificationResponses.technicalFailure
      case "36770ea0-d385-4b17-a0b4-23a85c0c5b1a" => NotificationResponses.temporaryFailure
      case "46770ea0-d385-4b17-a0b4-23a85c0c5b1a" => NotificationResponses.created
      case "56770ea0-d385-4b17-a0b4-23a85c0c5b1a" => NotificationResponses.sending
      case "66770ea0-d385-4b17-a0b4-23a85c0c5b1a" => NotificationResponses.pending
      case "76770ea0-d385-4b17-a0b4-23a85c0c5b1a" => NotificationResponses.sent
      case _ => NotificationResponses.delivered
    }
  }
}
