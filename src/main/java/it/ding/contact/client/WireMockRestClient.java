package it.ding.contact.client;

import static io.restassured.http.ContentType.JSON;
import static java.util.Objects.requireNonNull;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

import java.io.File;

public class WireMockRestClient extends RestClient {

    private static final String BASE_URI = "http://localhost:8080";
    private static final String ADMIN_URI = "/__admin";
    private static final String MAPPINGS = ADMIN_URI + "/mappings";
    private static final String RESET = ADMIN_URI + "/reset";

    public WireMockRestClient() {
        super(BASE_URI);
    }

    public void createStub(String fileName) {
        File file = new File(requireNonNull(getClass()
            .getClassLoader()
            .getResource(fileName))
            .getFile());

        requestSpec()
            .contentType(JSON)
            .body(file)
            .post(MAPPINGS)
            .then()
            .statusCode(SC_CREATED);
    }

    public void resetAll() {
        requestSpec()
            .contentType(JSON)
            .post(RESET)
            .then()
            .statusCode(SC_OK);
    }
}
