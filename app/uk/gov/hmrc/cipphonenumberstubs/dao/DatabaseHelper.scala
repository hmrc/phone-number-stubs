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

package uk.gov.hmrc.cipphonenumberstubs.dao

import play.api.Logging
import uk.gov.hmrc.mongo.cache.DataKey

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class DatabaseHelper @Inject()(otpCacheRepository: OtpCacheRepository)
                              (implicit ec: ExecutionContext) extends Logging {

  def persistOtp(notificationId: String, otp: String): Future[OtpData] = {
    logger.debug(s"Storing otp in database for $notificationId")
    val otpData = OtpData(notificationId, otp)
    otpCacheRepository.put(notificationId)(DataKey("cip-phone-number-verification-acceptance-stubs"), otpData)
      .map(_ => otpData)
  }

  def retrieveOtp(notificationId: String): Future[Option[OtpData]] = {
    logger.debug(s"Retrieving otp from database for $notificationId")
    otpCacheRepository.get[OtpData](notificationId)(DataKey("cip-phone-number-verification-acceptance-stubs"))
  }

}
