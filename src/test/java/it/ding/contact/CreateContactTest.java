package it.ding.contact;

import static it.ding.contact.DriverFactory.getDriver;

import it.ding.contact.component.NotificationComponentObject;
import it.ding.contact.pageobject.AddEditContactPageObject;
import it.ding.contact.pageobject.ContactListPageObject;
import org.junit.Test;

public class CreateContactTest extends Base {

    private ContactListPageObject contactListPageObject = new ContactListPageObject(getDriver());
    private AddEditContactPageObject addEditContactPageObject = new AddEditContactPageObject(getDriver());
    private NotificationComponentObject notificationComponentObject = new NotificationComponentObject(getDriver());

    @Test
    public void canCreateContact() {
        // Create stub for creating contact (POST)

        // Create Contact object using Contact class

        // Click on Add contact button (use ContactListPageObject)

        // Enter contact details

        // Save contact

        // Assert notification text (Contact added successfully)

    }

    @Test
    public void cannotCreateContactWithBadRequest() {
        // Create stub that return a HTTP 400 Bad Request for creating contact (POST)

        // Create Contact object using Contact class

        // Click on Add contact button (use ContactListPageObject)

        // Enter contact details

        // Save contact

        // Assert notification text (Cannot add contact)

        // Assert alert (Field errors)

    }

}
