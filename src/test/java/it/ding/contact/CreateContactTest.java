package it.ding.contact;

import static it.ding.contact.DriverFactory.getDriver;
import static it.ding.contact.util.ContactTestUtil.generateContactWithAllFieldsFilled;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import it.ding.contact.component.NotificationComponentObject;
import it.ding.contact.model.Contact;
import it.ding.contact.pageobject.AddEditContactPageObject;
import it.ding.contact.pageobject.ContactListPageObject;
import org.junit.Test;

public class CreateContactTest extends Base {

    private ContactListPageObject contactListPageObject = new ContactListPageObject(getDriver());
    private AddEditContactPageObject addEditContactPageObject = new AddEditContactPageObject(getDriver());
    private NotificationComponentObject notificationComponentObject = new NotificationComponentObject(getDriver());

    @Test
    public void canCreateContact() {
        wireMockRestClient.createStub("post-contact.json");
        Contact contact = generateContactWithAllFieldsFilled();

        contactListPageObject.addContact();
        addEditContactPageObject.enterContactDetails(contact);
        addEditContactPageObject.saveContact();

        assertThat(notificationComponentObject.getNotificationText(), is("Contact added successfully"));
    }

    @Test
    public void cannotCreateContactWithBadRequest() {
        wireMockRestClient.createStub("post-contact-bad-request.json");
        Contact contact = generateContactWithAllFieldsFilled();

        contactListPageObject.addContact();
        addEditContactPageObject.enterContactDetails(contact);
        addEditContactPageObject.saveContact();

        assertThat(notificationComponentObject.getNotificationText(), containsString("Cannot add contact"));
        assertThat(addEditContactPageObject.getAlert(), containsString("Field errors: test abc, test2 def"));
    }

}
