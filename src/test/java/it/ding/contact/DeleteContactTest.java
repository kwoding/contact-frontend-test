package it.ding.contact;

import static it.ding.contact.DriverFactory.getDriver;

import it.ding.contact.component.NotificationComponentObject;
import it.ding.contact.pageobject.ContactListPageObject;
import org.junit.Test;

public class DeleteContactTest extends Base {

    private ContactListPageObject contactListPageObject = new ContactListPageObject(getDriver());
    private NotificationComponentObject notificationComponentObject = new NotificationComponentObject(getDriver());

    @Test
    public void canDeleteContact() {
        // Create stub for deleting a contact (DELETE)

        // Invoke deleting a contact, use contactListPageObject.invokeDeleteContact()

        // Confirm deleting

        // Assert notification text (Contact removed successfully), use notificationComponentObject.getNotificationText()
    }

}
