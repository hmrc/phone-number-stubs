
# cip-phone-number-stubs

### Summary

Backend stub to mock downstream services, currently the stub mocks the following services:
- [GovNotify](https://www.notifications.service.gov.uk/) - sends sms to citizens

The default port for cip-phone-number-stubs is 6099.  

#### Default ports for related services
```
cip-phone-number-frontend:     6080
cip-phone-number:              6081
cip-phone-number-validation:   6082
cip-phone-number-verification: 6083
```

### Testing

Sending passcode phone number Test cases
```
      "+447430003001" => BadRequest
      "+447430003002" => BadRequest
      "+447430003003" => Forbidden
      "+447430003004" => Forbidden
      "+447430003005" => TooManyRequests
      "+447430003006" => TooManyRequests
      "+447430003007" => InternalServerError
      Any             => Created
```

Notification Id Test cases 
```
      "validation-d385-4b17-a0b4-23a85c0c5b1a" => BadRequest
      "invalidtoken-d385-4b17-a0b4-23a85c0c5b1a" => Forbidden
      "systemclock-d385-4b17-a0b4-23a85c0c5b1a" => Forbidden
      "noresult-d385-4b17-a0b4-23a85c0c5b1a" => NotFound
      
      "16770ea0-d385-4b17-a0b4-23a85c0c5b1a" => permanent_failure
      "26770ea0-d385-4b17-a0b4-23a85c0c5b1a" => technical_failure
      "36770ea0-d385-4b17-a0b4-23a85c0c5b1a" => temporary_failure
      "46770ea0-d385-4b17-a0b4-23a85c0c5b1a" => created
      "56770ea0-d385-4b17-a0b4-23a85c0c5b1a" => sending
      "66770ea0-d385-4b17-a0b4-23a85c0c5b1a" => pending
      "76770ea0-d385-4b17-a0b4-23a85c0c5b1a" => sent
      "86770ea0-d385-4b17-a0b4-23a85c0c5b1a" => not found
      Any                                    => delivered
```


### Running app

    sm --start CIP_PHONE_NUMBER_VERIFICATION_ALL

Run the services against the current versions in dev, stop the CIP_PHONE_NUMBER_STUBS service and start manually

    sm --stop CIP_PHONE_NUMBER_STUBS
    cd cip-phone-number-stubs
    sbt run

For reference here are the details for running each of the services individually

    cd cip-phone-number-frontend
    sbt run
 
    cd cip-phone-number
    sbt run

    cd cip-phone-number-validation
    sbt run

    cd cip-phone-number-verification
    sbt run

### Curl microservice (for curl microservice build jobs)

#### Verify

##### Using curl locally
```
curl \
  --verbose \
  --request POST \
  --header 'Content-Type: application/json' \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJmNmEzYTQwZC0yOWIyLTQ2ZjUtYmNkMS0zNmE0ZjY4MzcxNzEiLCJpYXQiOjE2NTgzMTU5MDV9.HdKMVoNm4S3353SvFvjaktb8J5yKsFATsyMjjRDlNxg' \
  --data '{"phone_number":"07843274331","template_id":"dce5ac8a-0970-41a0-b993-bde1beab5825","personalisation":{"clientServiceName":"cip-phone-service","passCode":"BTXDYC","timeToLive":"1"}}' \
  'http://localhost:6099/v2/notifications/sms'
```
##### Using jenkins script
```
-X POST 
    -H "Content-type: application/json"
    -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJmNmEzYTQwZC0yOWIyLTQ2ZjUtYmNkMS0zNmE0ZjY4MzcxNzEiLCJpYXQiOjE2NTgzMTU5MDV9.HdKMVoNm4S3353SvFvjaktb8J5yKsFATsyMjjRDlNxg"
    -d "{"phone_number":"07843274331","template_id":"dce5ac8a-0970-41a0-b993-bde1beab5825","personalisation":{"clientServiceName":"cip-phone-service","passCode":"BTXDYC","timeToLive":"1"}}"    
    'https://cip-phone-number-stubs.protected.mdtp/v2/notifications/sms'
```

#### Check notification status

##### Using curl locally
```
curl \
  --verbose \
  --request GET \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJmNmEzYTQwZC0yOWIyLTQ2ZjUtYmNkMS0zNmE0ZjY4MzcxNzEiLCJpYXQiOjE2NTgzMTY3Njd9._0__Ubwncx84sp5Q3FhztZB7xkjSKFy9WVTunzZE4DQ' \
  'http://localhost:6099/v2/notifications/ecf20f0a-86af-4ebf-9012-e48bc6a31174'
```
##### Using jenkins script
```
-X GET 
    -H "Content-type: application/json"
    -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJmNmEzYTQwZC0yOWIyLTQ2ZjUtYmNkMS0zNmE0ZjY4MzcxNzEiLCJpYXQiOjE2NTgzMTU5MDV9.HdKMVoNm4S3353SvFvjaktb8J5yKsFATsyMjjRDlNxg"
    'https://cip-phone-number-stubs.protected.mdtp/v2/notifications/ecf20f0a-86af-4ebf-9012-e48bc6a31174'
``` 

### License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
