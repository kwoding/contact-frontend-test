# Exercise 2: Create operation

## Description
1. Create WireMock stubs by POSTing stub definitions for POST operation on /api/contacts

- HTTP 201 with id in response body (as-is from actual service)
- HTTP 201 with empty response body
- HTTP 200
- HTTP 202
- HTTP 204
- HTTP 400 (see example)
- HTTP 500

2. Create a contact by clicking the "Add contact" button and submitting the form with valid values
3. Assert the result on the front-end

Note: Assert error message on the page in case of HTTP 400
