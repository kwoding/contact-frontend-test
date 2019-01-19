package it.ding.contact;

import static it.ding.contact.DriverFactory.getDriver;
import static it.ding.contact.util.ContactTestUtil.generateContactWithAllFieldsFilled;
import static it.ding.contact.util.ContactTestUtil.generateContactWithMandatoryFieldsFilled;
import static java.util.Objects.requireNonNull;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import it.ding.contact.component.NotificationComponentObject;
import it.ding.contact.model.Contact;
import it.ding.contact.pageobject.AddEditContactPageObject;
import it.ding.contact.pageobject.ContactListPageObject;
import it.ding.contact.pageobject.LoginPageObject;
import java.io.File;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ContactTest extends Base {

    private LoginPageObject loginPage = new LoginPageObject(getDriver());
    private ContactListPageObject contactListPageObject = new ContactListPageObject(getDriver());
    private AddEditContactPageObject addEditContactPageObject = new AddEditContactPageObject(getDriver());
    private NotificationComponentObject notificationComponentObject = new NotificationComponentObject(getDriver());
    private Gson gson = new Gson();

    @Before
    public void setUpTest() {
        wireMockRestClient.resetAll();
        wireMockRestClient.createStub("login.json");
        wireMockRestClient.createStub("logout.json");
        wireMockRestClient.createStub("get-contact-list.json");
        wireMockRestClient.createStub("post-contact.json");
        wireMockRestClient.createStub("get-contact.json");
        wireMockRestClient.createStub("put-contact.json");
        wireMockRestClient.createStub("delete-contact.json");
        contactListPageObject.visit();
    }


    @Test
    public void canCreateContact() {
        wireMockRestClient.createStub("post-contact.json");
        Contact contact = generateContactWithMandatoryFieldsFilled();

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

    @Test
    public void canRetrieveContactInList() {
        assertThat(contactListPageObject.getContactDetailsInList(), is(Contact.builder()
            .lastName("Schinner")
            .firstName("Deshaun")
            .email("meaghan.lind@gmail.com")
            .build()));
    }

    @Test
    public void canRetrieveContactDetails() {
        contactListPageObject.viewContact();

        List<Contact> contactList = JsonPath.from(new File(requireNonNull(getClass()
            .getClassLoader()
            .getResource("get-contact-list.json"))
            .getFile())).getList("response.jsonBody.content", Contact.class);

        Contact expectedContact = contactList.get(0);

        expectedContact.setId(null);
        assertThat(contactListPageObject.getContactDetailsInModal(), is(expectedContact));
    }

    @Test
    public void canUpdateContact() {
        Contact contact = generateContactWithAllFieldsFilled();

        contactListPageObject.editContact();
        addEditContactPageObject.enterContactDetails(contact);
        addEditContactPageObject.saveContact();

        assertThat(notificationComponentObject.getNotificationText(), is("Contact updated successfully"));
    }

    @Test
    public void canDeleteContact() {
        contactListPageObject.invokeDeleteContact();
        contactListPageObject.confirmDeleteContact();

        assertThat(notificationComponentObject.getNotificationText(), is("Contact removed successfully"));
    }

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
