package it.ding.contact;

import static it.ding.contact.DriverFactory.getDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import it.ding.contact.component.NotificationComponentObject;
import it.ding.contact.pageobject.ContactListPageObject;
import org.junit.Test;

public class DeleteContactTest extends Base {

    private ContactListPageObject contactListPageObject = new ContactListPageObject(getDriver());
    private NotificationComponentObject notificationComponentObject = new NotificationComponentObject(getDriver());

    @Test
    public void canDeleteContact() {
        contactListPageObject.invokeDeleteContact();
        contactListPageObject.confirmDeleteContact();

        assertThat(notificationComponentObject.getNotificationText(), is("Contact removed successfully"));
    }

}
