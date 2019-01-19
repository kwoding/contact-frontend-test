package it.ding.contact;

import static it.ding.contact.DriverFactory.getDriver;
import static it.ding.contact.util.ContactTestUtil.generateContactWithAllFieldsFilled;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import it.ding.contact.component.NotificationComponentObject;
import it.ding.contact.model.Contact;
import it.ding.contact.pageobject.AddEditContactPageObject;
import it.ding.contact.pageobject.ContactListPageObject;
import org.junit.Test;

public class UpdateContactTest extends Base {

    private ContactListPageObject contactListPageObject = new ContactListPageObject(getDriver());
    private AddEditContactPageObject addEditContactPageObject = new AddEditContactPageObject(getDriver());
    private NotificationComponentObject notificationComponentObject = new NotificationComponentObject(getDriver());

    @Test
    public void canUpdateContact() {
        Contact contact = generateContactWithAllFieldsFilled();

        contactListPageObject.editContact();
        addEditContactPageObject.enterContactDetails(contact);
        addEditContactPageObject.saveContact();

        assertThat(notificationComponentObject.getNotificationText(), is("Contact updated successfully"));
    }

}
