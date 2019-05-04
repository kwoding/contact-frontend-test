package it.ding.contact;

import static it.ding.contact.DriverFactory.getDriver;

import it.ding.contact.component.NotificationComponentObject;
import it.ding.contact.pageobject.AddEditContactPageObject;
import it.ding.contact.pageobject.ContactListPageObject;
import org.junit.Test;

public class UpdateContactTest extends Base {

    private ContactListPageObject contactListPageObject = new ContactListPageObject(getDriver());
    private AddEditContactPageObject addEditContactPageObject = new AddEditContactPageObject(getDriver());
    private NotificationComponentObject notificationComponentObject = new NotificationComponentObject(getDriver());

    @Test
    public void canUpdateContact() {
        // Create stub for updating contact (PUT)

        // Create contact object with Contact class

        // Edit a contact (click on edit button, enter contact details and save)

        // Assert notification text (Contact updated successfully)

    }

    @Test
    public void cannotUpdateContactWithBadRequest() {
        // Create stub that return HTTP 400 Bad request for updating contact (PUT)

        // Create contact object with Contact class

        // Edit a contact (click on edit button, enter contact details and save)

        // Assert notification text (Cannot edit contact)

        // Assert alert (Field errors)

    }

}
