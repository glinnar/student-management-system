Create a Student:
* Method : POST
* EndPoint: localhost:8080/student-management-system/api/v1/student/create

```
{
	"firstName" : "King",
	"lastName" : "Kungen",
	"email" : "Kungen@yahoo.com",
	"phoneNumber" : "12345"
}
```


READ
Get all students:
Method: GET
Endpoint: localhost:8080/student-management-system/api/v1/student/getstudents


Get student by ID:
Method: GET
Endpoint: localhost:8080/student-management-system/api/v1/student/{id}



UPDATE Firstname
* Mehotd: PATCH
* Endpoint: localhost:8080/student-management-system/api/v1/student/update/firstname/{id}

```
{
	"firstName":"Kingen"
}
```


UPDATE Lastname
* Mehotd: PATCH
* Endpoint: localhost:8080/student-management-system/api/v1/student/update/lastname/{id}

```
{
	"lastName" : "Emperor"
}
```

UPDATE Email
* Mehotd: PATCH
* Endpoint: localhost:8080/student-management-system/api/v1/student/update/email/{id}

```
{
	"email":"King@yahoo.com"
}
```

UPDATE Phonenumber
* Mehotd: PATCH
* Endpoint: localhost:8080/student-management-system/api/v1/student/update/phonenumber/{id}

```
{
	"phoneNumber" : " 1111111"
}
```

