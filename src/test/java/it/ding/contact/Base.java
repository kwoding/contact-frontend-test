package it.ding.contact;

import static it.ding.contact.DriverFactory.getDriver;
import static it.ding.contact.DriverFactory.setDriver;

import it.ding.contact.client.WireMockRestClient;
import it.ding.contact.pageobject.ContactListPageObject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class Base {

    private ContactListPageObject contactListPageObject = new ContactListPageObject(getDriver());

    static WireMockRestClient wireMockRestClient = new WireMockRestClient();

    @BeforeClass
    public static void setUp() {
        setDriver();
    }

    @Before
    public void setUpTest() {
        wireMockRestClient.resetAll();
        wireMockRestClient.createStub("login.json");
        wireMockRestClient.createStub("logout.json");
        wireMockRestClient.createStub("get-contact-list.json");
        wireMockRestClient.createStub("get-contact.json");
        contactListPageObject.visit();
    }

    @AfterClass
    public static void tearDown() {
        getDriver().quit();
    }

}
