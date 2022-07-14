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

package uk.gov.hmrc.cipphonenumberstubs.services.responses

object VerificationResponses {

  val notificationResponse = """{
                               |  "content": {
                               |    "body": "cip-phone-service needs to verify your telephone number.\nYour telephone number verification code is VWYMBQ.\nUse this code within 1 minutes to verify your telephone number.",
                               |    "from_number": "GOVUK"
                               |  },
                               |  "id": "ecf20f0a-86af-4ebf-9012-e48bc6a31174",
                               |  "reference": null,
                               |  "scheduled_for": null,
                               |  "template": {
                               |    "id": "dce5ac8a-0970-41a0-b993-bde1beab5825",
                               |    "uri": "https://api.notifications.service.gov.uk/services/f6a3a40d-29b2-46f5-bcd1-36a4f6837171/templates/dce5ac8a-0970-41a0-b993-bde1beab5825",
                               |    "version": 6
                               |  },
                               |  "uri": "https://api.notifications.service.gov.uk/v2/notifications/ecf20f0a-86af-4ebf-9012-e48bc6a31174"
                               |}""".stripMargin

}
