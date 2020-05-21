# dropwizartDemo

Step 1: Build Application Jar File :
mvn clean package

Step 2:Start application in jetty server :
java -jar target\DropWizardExample-0.0.1-SNAPSHOT.jar server


Requests:

Get all order details
http://localhost:8080/employees 


Get a specified order with Id 1
http://localhost:8080/employees/1


Sent HTTP PUT http://localhost:8080/employees/1 with invalid request data
Body:
{
	"firstName":"Kingshuk",
	"lastName":"G",
	"email":"asdses"
}

Response
[
    "id: may not be null",
    "lastName: length must be between 2 and 255",
    "email: must match \".+@.+\\.[a-z]+\""
]

