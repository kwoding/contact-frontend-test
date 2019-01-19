package it.ding.contact;

import static it.ding.contact.DriverFactory.getDriver;
import static java.util.Objects.requireNonNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import io.restassured.path.json.JsonPath;
import it.ding.contact.model.Contact;
import it.ding.contact.pageobject.ContactListPageObject;
import java.io.File;
import java.util.List;
import org.junit.Test;

public class RetrieveContactTest extends Base {

    private ContactListPageObject contactListPageObject = new ContactListPageObject(getDriver());

    @Test
    public void canRetrieveContactInList() {
        List<Contact> contactList = JsonPath.from(new File(requireNonNull(getClass()
            .getClassLoader()
            .getResource("get-contact-list.json"))
            .getFile())).getList("response.jsonBody.content", Contact.class);

        for (Contact contact : contactList) {
            contact.setId(null);
            contact.setPhone(null);
            contact.setAddressLine1(null);
            contact.setAddressLine2(null);
            contact.setZipCode(null);
            contact.setCity(null);
            contact.setCountrySubDivision(null);
            contact.setCountry(null);
        }

        assertThat(contactListPageObject.getContactDetailsInList(), is(contactList));
    }

    @Test
    public void canRetrieveContactDetails() throws NoSuchFieldException {
        List<Contact> contactList = JsonPath.from(new File(requireNonNull(getClass()
            .getClassLoader()
            .getResource("get-contact-list.json"))
            .getFile())).getList("response.jsonBody.content", Contact.class);

        contactListPageObject.viewContact(contactList.get(1).getLastName());

        Contact expectedContact = contactList.get(1);

        expectedContact.setId(null);
        assertThat(contactListPageObject.getContactDetailsInModal(), is(expectedContact));
    }

}
