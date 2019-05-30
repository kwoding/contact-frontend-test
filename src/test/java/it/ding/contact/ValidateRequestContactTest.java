package it.ding.contact;

import static it.ding.contact.DriverFactory.getDriver;

import com.google.gson.Gson;
import it.ding.contact.pageobject.AddEditContactPageObject;
import it.ding.contact.pageobject.ContactListPageObject;
import org.junit.Test;

public class ValidateRequestContactTest extends Base {

    private ContactListPageObject contactListPageObject = new ContactListPageObject(getDriver());
    private AddEditContactPageObject addEditContactPageObject = new AddEditContactPageObject(getDriver());
    private Gson gson = new Gson();

    @Test
    public void createContactShouldSendProperRequestBody() {
        // Create contact object with Contact class

        // Add a contact (click on Add contact, enter contact details and save)
        // Just before clicking Save, reset the request journal

        // Find the request body in WireMock, use wireMockRestClient.findFirstRequestBody()

        // Map the found request body to Contact class, use gson.fromJson()

        // Assert the request body with the contact object already created in this test

    }

}
