## Prerequisites

### Installed on your machine
- Maven 3.3.9+
- JDK version 1.8.0_51+
- Docker Desktop 2.0.0.3+
- Chrome 74+
- IntelliJ (preferred) or other IDE with the JDK configured

## Verification of setup

1. Clone the following project.
```
git clone https://github.com/kwoding/contact-frontend-test.git
```

2. Verify you can run the test application by executing the following command:

Inside the `src/test/resources` folder, run:
```
docker-compose -f docker-compose-wiremock.yml up
```

3. The logs (of Docker) should end as follows:
```
contact-frontend_1  | You can now view contact-frontend in the browser.
contact-frontend_1  | 
contact-frontend_1  |   Local:            http://localhost:3000/
contact-frontend_1  |   On Your Network:  http://172.21.0.3:3000/
contact-frontend_1  | 
```

4. Navigate in your Chrome browser to http://localhost:3000, you should see the following on your screen.

![Login screen](./img/login_screen.png)

5. Run the following command (in a different terminal window) to ensure you have everything set up.

```
mvn clean test
```

Expected result is a successful build:
```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running it.ding.contact.BaseTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.279 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 4.300 s
[INFO] Finished at: 2019-05-26T13:46:45-05:00
[INFO] Final Memory: 22M/225M
[INFO] ------------------------------------------------------------------------
```
