package it.ding.contact;

import static it.ding.contact.DriverFactory.getDriver;
import static it.ding.contact.DriverFactory.setDriver;

import it.ding.contact.client.WireMockRestClient;
import it.ding.contact.pageobject.ContactListPageObject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BaseTest {

    private ContactListPageObject contactListPageObject = new ContactListPageObject(getDriver());

    private WireMockRestClient wireMockRestClient = new WireMockRestClient();

    @BeforeClass
    public static void setUp() {
        setDriver();
    }

    @Before
    public void setUpTest() {
        wireMockRestClient.resetAll();
        wireMockRestClient.createStub("login.json");
        wireMockRestClient.createStub("logout.json");
        // Create stub for retrieving contact list

        // Create stub for retrieve contact details

        contactListPageObject.visit();
    }

    @Test
    public void canRetrieveContactInList() {
        // Visit page

        // Read source (stub)

        // Assert list of contacts (compare contact list in browser to the source/stub)

    }

    @AfterClass
    public static void tearDown() {
        getDriver().quit();
    }

}
