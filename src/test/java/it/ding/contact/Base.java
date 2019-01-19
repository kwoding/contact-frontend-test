package it.ding.contact;

import static it.ding.contact.DriverFactory.getDriver;
import static it.ding.contact.DriverFactory.setDriver;

import it.ding.contact.client.WireMockRestClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class Base {

    protected static WireMockRestClient wireMockRestClient = new WireMockRestClient();

    @BeforeClass
    public static void setUp() {
        setDriver();
    }

    @AfterClass
    public static void tearDown() {
        getDriver().quit();
    }

}
