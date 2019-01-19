# Exercise 1: Read operation

## Description
1. Create WireMock stubs by POSTing stub definitions for GET operation on /api/contacts using the already-created `WireMockRestClient` in this project for:
- HTTP 200 with empty list
- HTTP 200 with couple of contacts
- HTTP 200 with many contacts
- HTTP 500

2. Use Selenium WebDriver (boilerplate already in this project) to navigate through the front-end to retrieve the contact list.
3. Click on a contact (table row) to view details of a single contact.
3. Assert the result on the front-end (for both the list and the single contact).

Note: if the GET on /api/contacts returns an OK response, the test application considers you are logged in
