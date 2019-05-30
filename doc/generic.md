# Generic information

## Contact-service

### Endpoints contact-service
```
[POST]   /login
Authenticate

[POST]   /api/contacts
Create contact

[GET]    /api/contacts
Retrieve contact list

[GET]    /api/contacts/{contactId}
Retrieve single contact

[PUT]    /api/contacts/{contactId}
Update contact

[DELETE] /api/contacts/{contactId}
Delete contact
```

## Model contact-service
- This is an example of a request body to create a Contact.
- The response body when retrieving a Contact is similar with the addition of an `id` field.

```
{
    "lastName": "Bond",
    "firstName": "James",
    "email": "james@bond.com",
    "phone": "02011111007",
    "addressLine1": "30 Wellington Square",
    "addressLine2": "Chelsea",
    "zipCode": "SW3 4NR”,
    "city": “London",
    "countrySubDivision": "England",
    "country": “United Kingdom”
}
```

## WireMock

### Endpoints WireMock
```
[POST]  /__admin/mappings
Create stub

[POST]  /reset
Reset all stubs (clear)
```

### Stub definition examples

Example of a stub definition for retrieving list of contacts

```
{
  "request": {
    "method": "GET",
    "urlPathPattern": "/api/contacts"
  },
  "response": {
    "status": 200,
    "jsonBody": {
        "content": [
            {
                "id": 2006,
                "lastName": "Schinner",
                "firstName": "Deshaun",
                (…)
            },
            {
                "id": 2007,
                "lastName": "Bond",
                "firstName": "James",
                (…)
            },
            (...)
    },
    "headers": {
      "Content-Type": "application/json"
    }
  }
}

```

Example of a stub definition for retrieving a single contact

```
{
  "request": {
    "method": "GET",
    "urlPathPattern": "/api/contacts/(.*)"
  },
  "response": {
    "status": 200,
    "jsonBody": {
      "id": 2006,
      "lastName": "Schinner",
      "firstName": "Deshaun",
      (…)
    },
    "headers": {
      "Content-Type": "application/json"
    }
  }
}

```

Example of an error response (note the `fieldErrors` field which is returned from the actual `contact-service` which is used in the front-end.

```
[POST] http://localhost:8080/__admin/mappings

{
  "request": {
    "method": "POST",
    "urlPathPattern": "/api/contacts"
  },
  "response": {
    "status": 400,
    "jsonBody": {
      "fieldErrors": {
        "lastName": “Invalid input",
        "email": “Invalid email address”
      }
    },
    "headers": {
      "Content-Type": "application/json"
    }
  }
}
```
