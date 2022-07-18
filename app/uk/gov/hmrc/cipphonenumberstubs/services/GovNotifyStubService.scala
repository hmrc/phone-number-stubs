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
import play.api.mvc.Results.{Created, Ok}
import uk.gov.hmrc.cipphonenumberstubs.services.responses.{NotificationResponse, VerificationResponses}
import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton()
class GovNotifyStubService @Inject() (implicit val executionContext: ExecutionContext) extends Logging {

  def sms: Future[Result]  = Future {
    Created(Json.parse(VerificationResponses.notificationResponse))
  }

  def status(notificationId: String): Future[Result] = Future {
      Ok(Json.parse(parseNotificationResponse(notificationId)))
  }

  def parseNotificationResponse(notificationId: String) = {
    notificationId match {
      case "16770ea0-d385-4b17-a0b4-23a85c0c5b1a" => NotificationResponse.permanentFailure
      case "26770ea0-d385-4b17-a0b4-23a85c0c5b1a" => NotificationResponse.technicalFailure
      case "36770ea0-d385-4b17-a0b4-23a85c0c5b1a" => NotificationResponse.temporaryFailure
      case "46770ea0-d385-4b17-a0b4-23a85c0c5b1a" => NotificationResponse.created
      case "56770ea0-d385-4b17-a0b4-23a85c0c5b1a" => NotificationResponse.sending
      case "66770ea0-d385-4b17-a0b4-23a85c0c5b1a" => NotificationResponse.pending
      case "76770ea0-d385-4b17-a0b4-23a85c0c5b1a" => NotificationResponse.sent
      case _ => NotificationResponse.delivered
    }
  }
}
