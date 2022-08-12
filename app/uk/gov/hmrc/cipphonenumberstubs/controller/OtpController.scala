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

package uk.gov.hmrc.cipphonenumberstubs.controller

import play.api.Logging
import play.api.mvc.{Action, AnyContent, ControllerComponents}
import uk.gov.hmrc.cipphonenumberstubs.services.OtpService
import uk.gov.hmrc.play.bootstrap.backend.controller.BackendController

import javax.inject.{Inject, Singleton}

@Singleton()
class OtpController @Inject()(cc: ControllerComponents, service: OtpService)
  extends BackendController(cc) with Logging {

  /*
  Not a real endpoint
  Only used by the acceptance tests
  This is just to help the acceptance tests be automated and know the otp without a manual process
   */
  def retrieveOtp(notificationId: String): Action[AnyContent] = Action.async { implicit request =>
    logger.debug(s"Retrieving the expected otp for $notificationId")
    service.retrieveOtp(notificationId)
  }
}
