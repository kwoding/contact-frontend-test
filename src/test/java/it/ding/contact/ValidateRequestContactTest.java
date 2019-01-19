package it.ding.contact;

import static it.ding.contact.DriverFactory.getDriver;
import static it.ding.contact.util.ContactTestUtil.generateContactWithAllFieldsFilled;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.gson.Gson;
import it.ding.contact.model.Contact;
import it.ding.contact.pageobject.AddEditContactPageObject;
import it.ding.contact.pageobject.ContactListPageObject;
import org.junit.Test;

public class ValidateRequestContactTest extends Base {

    private ContactListPageObject contactListPageObject = new ContactListPageObject(getDriver());
    private AddEditContactPageObject addEditContactPageObject = new AddEditContactPageObject(getDriver());
    private Gson gson = new Gson();

    @Test
    public void createContactShouldSendProperRequestBody() {
        Contact contact = generateContactWithAllFieldsFilled();

        contactListPageObject.addContact();
        addEditContactPageObject.enterContactDetails(contact);
        wireMockRestClient.resetRequestJournal();
        addEditContactPageObject.saveContact();

        String request = wireMockRestClient.findFirstRequestBody("POST", "/api/contacts");

        Contact postedContact = gson.fromJson(request, Contact.class);

        assertThat(postedContact, is(contact));
    }

}
