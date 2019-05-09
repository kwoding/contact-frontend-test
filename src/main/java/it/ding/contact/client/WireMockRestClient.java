package it.ding.contact.client;

import static io.restassured.http.ContentType.JSON;
import static it.ding.contact.data.CommonData.PROPERTY_WIREMOCK_BASE_URI;
import static java.util.Objects.requireNonNull;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

import it.ding.contact.util.GlobalProperties;
import java.io.File;

public class WireMockRestClient extends RestClient {

    private static final GlobalProperties globalProperties = GlobalProperties.getInstance();
    private static final String BASE_URI = globalProperties.getString(PROPERTY_WIREMOCK_BASE_URI);
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
