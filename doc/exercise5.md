# Exercise 5: Validate request body

## Endpoints WireMock

```
[POST]   /__admin/requests/find
Query requests

Request body:
{
    "method": "POST",
    "urlPathPattern": "/api/contacts"
}

[POST]   /__admin/requests/reset
Reset request journal (clear)
```

## Description
1. Create a contact by clicking the "Add contact" button and submitting the form with valid values
2. Find this request via WireMock
3. Assert the request body with UI-entered values
