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

object NotificationResponses {

  val delivered =
    """
      |{
      |  "body": "cip-phone-service needs to verify your telephone number.\nYour telephone number verification code is HTNNQW.\nUse this code within 1 minutes to verify your telephone number.",
      |  "completed_at": "2022-07-18T05:44:16.623971Z",
      |  "created_at": "2022-07-18T05:44:16.472860Z",
      |  "created_by_name": null,
      |  "email_address": null,
      |  "id": "16770ea0-d385-4b17-a0b4-23a85c0c5b1a",
      |  "line_1": null,
      |  "line_2": null,
      |  "line_3": null,
      |  "line_4": null,
      |  "line_5": null,
      |  "line_6": null,
      |  "phone_number": "07843274339",
      |  "postage": null,
      |  "postcode": null,
      |  "reference": null,
      |  "scheduled_for": null,
      |  "sent_at": "2022-07-18T05:44:16.540117Z",
      |  "status": "delivered",
      |  "subject": null,
      |  "template": {
      |    "id": "dce5ac8a-0970-41a0-b993-bde1beab5825",
      |    "uri": "https://api.notifications.service.gov.uk/v2/template/dce5ac8a-0970-41a0-b993-bde1beab5825/version/6",
      |    "version": 6
      |  },
      |  "type": "sms"
      |}
      |""".stripMargin

  val sending =
    """
      |{
      |  "body": "cip-phone-service needs to verify your telephone number.\nYour telephone number verification code is HTNNQW.\nUse this code within 1 minutes to verify your telephone number.",
      |  "completed_at": "2022-07-18T05:44:16.623971Z",
      |  "created_at": "2022-07-18T05:44:16.472860Z",
      |  "created_by_name": null,
      |  "email_address": null,
      |  "id": "16770ea0-d385-4b17-a0b4-23a85c0c5b1a",
      |  "line_1": null,
      |  "line_2": null,
      |  "line_3": null,
      |  "line_4": null,
      |  "line_5": null,
      |  "line_6": null,
      |  "phone_number": "07843274339",
      |  "postage": null,
      |  "postcode": null,
      |  "reference": null,
      |  "scheduled_for": null,
      |  "sent_at": "2022-07-18T05:44:16.540117Z",
      |  "status": "sending",
      |  "subject": null,
      |  "template": {
      |    "id": "dce5ac8a-0970-41a0-b993-bde1beab5825",
      |    "uri": "https://api.notifications.service.gov.uk/v2/template/dce5ac8a-0970-41a0-b993-bde1beab5825/version/6",
      |    "version": 6
      |  },
      |  "type": "sms"
      |}
      |""".stripMargin

  val created =
    """
      |{
      |  "body": "cip-phone-service needs to verify your telephone number.\nYour telephone number verification code is HTNNQW.\nUse this code within 1 minutes to verify your telephone number.",
      |  "completed_at": "2022-07-18T05:44:16.623971Z",
      |  "created_at": "2022-07-18T05:44:16.472860Z",
      |  "created_by_name": null,
      |  "email_address": null,
      |  "id": "16770ea0-d385-4b17-a0b4-23a85c0c5b1a",
      |  "line_1": null,
      |  "line_2": null,
      |  "line_3": null,
      |  "line_4": null,
      |  "line_5": null,
      |  "line_6": null,
      |  "phone_number": "07843274339",
      |  "postage": null,
      |  "postcode": null,
      |  "reference": null,
      |  "scheduled_for": null,
      |  "sent_at": "2022-07-18T05:44:16.540117Z",
      |  "status": "created",
      |  "subject": null,
      |  "template": {
      |    "id": "dce5ac8a-0970-41a0-b993-bde1beab5825",
      |    "uri": "https://api.notifications.service.gov.uk/v2/template/dce5ac8a-0970-41a0-b993-bde1beab5825/version/6",
      |    "version": 6
      |  },
      |  "type": "sms"
      |}
      |""".stripMargin

  val pending =
    """
      |{
      |  "body": "cip-phone-service needs to verify your telephone number.\nYour telephone number verification code is HTNNQW.\nUse this code within 1 minutes to verify your telephone number.",
      |  "completed_at": "2022-07-18T05:44:16.623971Z",
      |  "created_at": "2022-07-18T05:44:16.472860Z",
      |  "created_by_name": null,
      |  "email_address": null,
      |  "id": "16770ea0-d385-4b17-a0b4-23a85c0c5b1a",
      |  "line_1": null,
      |  "line_2": null,
      |  "line_3": null,
      |  "line_4": null,
      |  "line_5": null,
      |  "line_6": null,
      |  "phone_number": "07843274339",
      |  "postage": null,
      |  "postcode": null,
      |  "reference": null,
      |  "scheduled_for": null,
      |  "sent_at": "2022-07-18T05:44:16.540117Z",
      |  "status": "pending",
      |  "subject": null,
      |  "template": {
      |    "id": "dce5ac8a-0970-41a0-b993-bde1beab5825",
      |    "uri": "https://api.notifications.service.gov.uk/v2/template/dce5ac8a-0970-41a0-b993-bde1beab5825/version/6",
      |    "version": 6
      |  },
      |  "type": "sms"
      |}
      |""".stripMargin

  val sent =
    """
      |{
      |  "body": "cip-phone-service needs to verify your telephone number.\nYour telephone number verification code is HTNNQW.\nUse this code within 1 minutes to verify your telephone number.",
      |  "completed_at": "2022-07-18T05:44:16.623971Z",
      |  "created_at": "2022-07-18T05:44:16.472860Z",
      |  "created_by_name": null,
      |  "email_address": null,
      |  "id": "16770ea0-d385-4b17-a0b4-23a85c0c5b1a",
      |  "line_1": null,
      |  "line_2": null,
      |  "line_3": null,
      |  "line_4": null,
      |  "line_5": null,
      |  "line_6": null,
      |  "phone_number": "07843274339",
      |  "postage": null,
      |  "postcode": null,
      |  "reference": null,
      |  "scheduled_for": null,
      |  "sent_at": "2022-07-18T05:44:16.540117Z",
      |  "status": "sent",
      |  "subject": null,
      |  "template": {
      |    "id": "dce5ac8a-0970-41a0-b993-bde1beab5825",
      |    "uri": "https://api.notifications.service.gov.uk/v2/template/dce5ac8a-0970-41a0-b993-bde1beab5825/version/6",
      |    "version": 6
      |  },
      |  "type": "sms"
      |}
      |""".stripMargin

  val permanentFailure =
    """
      |{
      |  "body": "cip-phone-service needs to verify your telephone number.\nYour telephone number verification code is HTNNQW.\nUse this code within 1 minutes to verify your telephone number.",
      |  "completed_at": "2022-07-18T05:44:16.623971Z",
      |  "created_at": "2022-07-18T05:44:16.472860Z",
      |  "created_by_name": null,
      |  "email_address": null,
      |  "id": "16770ea0-d385-4b17-a0b4-23a85c0c5b1a",
      |  "line_1": null,
      |  "line_2": null,
      |  "line_3": null,
      |  "line_4": null,
      |  "line_5": null,
      |  "line_6": null,
      |  "phone_number": "07843274339",
      |  "postage": null,
      |  "postcode": null,
      |  "reference": null,
      |  "scheduled_for": null,
      |  "sent_at": "2022-07-18T05:44:16.540117Z",
      |  "status": "permanent-failure",
      |  "subject": null,
      |  "template": {
      |    "id": "dce5ac8a-0970-41a0-b993-bde1beab5825",
      |    "uri": "https://api.notifications.service.gov.uk/v2/template/dce5ac8a-0970-41a0-b993-bde1beab5825/version/6",
      |    "version": 6
      |  },
      |  "type": "sms"
      |}
      |""".stripMargin

  val temporaryFailure =
    """
      |{
      |  "body": "cip-phone-service needs to verify your telephone number.\nYour telephone number verification code is HTNNQW.\nUse this code within 1 minutes to verify your telephone number.",
      |  "completed_at": "2022-07-18T05:44:16.623971Z",
      |  "created_at": "2022-07-18T05:44:16.472860Z",
      |  "created_by_name": null,
      |  "email_address": null,
      |  "id": "16770ea0-d385-4b17-a0b4-23a85c0c5b1a",
      |  "line_1": null,
      |  "line_2": null,
      |  "line_3": null,
      |  "line_4": null,
      |  "line_5": null,
      |  "line_6": null,
      |  "phone_number": "07843274339",
      |  "postage": null,
      |  "postcode": null,
      |  "reference": null,
      |  "scheduled_for": null,
      |  "sent_at": "2022-07-18T05:44:16.540117Z",
      |  "status": "temporary-failure",
      |  "subject": null,
      |  "template": {
      |    "id": "dce5ac8a-0970-41a0-b993-bde1beab5825",
      |    "uri": "https://api.notifications.service.gov.uk/v2/template/dce5ac8a-0970-41a0-b993-bde1beab5825/version/6",
      |    "version": 6
      |  },
      |  "type": "sms"
      |}
      |""".stripMargin

  val technicalFailure =
    """
      |{
      |  "body": "cip-phone-service needs to verify your telephone number.\nYour telephone number verification code is HTNNQW.\nUse this code within 1 minutes to verify your telephone number.",
      |  "completed_at": "2022-07-18T05:44:16.623971Z",
      |  "created_at": "2022-07-18T05:44:16.472860Z",
      |  "created_by_name": null,
      |  "email_address": null,
      |  "id": "16770ea0-d385-4b17-a0b4-23a85c0c5b1a",
      |  "line_1": null,
      |  "line_2": null,
      |  "line_3": null,
      |  "line_4": null,
      |  "line_5": null,
      |  "line_6": null,
      |  "phone_number": "07843274339",
      |  "postage": null,
      |  "postcode": null,
      |  "reference": null,
      |  "scheduled_for": null,
      |  "sent_at": "2022-07-18T05:44:16.540117Z",
      |  "status": "technical-failure",
      |  "subject": null,
      |  "template": {
      |    "id": "dce5ac8a-0970-41a0-b993-bde1beab5825",
      |    "uri": "https://api.notifications.service.gov.uk/v2/template/dce5ac8a-0970-41a0-b993-bde1beab5825/version/6",
      |    "version": 6
      |  },
      |  "type": "sms"
      |}
      |""".stripMargin

  val notFound =
    """
      |{
      |"errors": [
      |        {
      |            "error": "NoResultFound",
      |            "message": "No result found"
      |        }
      |    ],
      |    "status_code": 404
      |}
      |""".stripMargin
}
