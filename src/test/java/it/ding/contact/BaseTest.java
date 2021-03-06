package it.ding.contact;

import static it.ding.contact.DriverFactory.getDriver;
import static it.ding.contact.DriverFactory.setDriver;
import static java.util.Objects.requireNonNull;

import io.restassured.path.json.JsonPath;
import it.ding.contact.client.WireMockRestClient;
import it.ding.contact.model.Contact;
import it.ding.contact.pageobject.ContactListPageObject;
import java.io.File;
import java.util.List;
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
        // Update stub "get-contact-list.json" for retrieving contact list in src/test/resources folder

        // Update stub "get-contact.json" for retrieving contact details
    }

    @Test
    public void canRetrieveContactInList() {
        // Visit page

        // Read source (stub)
        List<Contact> contactList = JsonPath.from(new File(requireNonNull(getClass()
            .getClassLoader()
            .getResource("get-contact-list.json"))
            .getFile())).getList("response.jsonBody.content", Contact.class);

        // Update contactList to match expected result

        // Assert list of contacts (compare contact list in browser to the source/stub), use the contactListPageObject.getContactDetailsInList()
    }

    @Test
    public void canRetrieveContactDetails() {
        // Visit page

        // Read source (stub)
        Contact contact = JsonPath.from(new File(requireNonNull(getClass()
            .getClassLoader()
            .getResource("get-contact.json"))
            .getFile())).getObject("response.jsonBody", Contact.class);

        // View single contact via browser, use contactListPageObject.viewContact()

        // Get contact details in modal via browser, use contactListPageObject.getContactDetailsInModal()
        // Assert the contact from browser with expected Contact object (= stub)
    }

    @AfterClass
    public static void tearDown() {
        getDriver().quit();
    }

}
