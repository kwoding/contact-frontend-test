package it.ding.contact.pageobject;

import static it.ding.contact.data.CommonData.PROPERTY_APP_BASE_URI;

import it.ding.contact.BasePage;
import it.ding.contact.model.Contact;
import it.ding.contact.util.GlobalProperties;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ContactListPageObject extends BasePage {

    private static final GlobalProperties globalProperties = GlobalProperties.getInstance();
    private static final String BASE_URI = globalProperties.getString(PROPERTY_APP_BASE_URI);
    private static final String CONTACTS = BASE_URI + "/contacts";
    private static final By ADD_CONTACT_BUTTON = By.cssSelector("[auto-id='add-contact-button']");
    private static final By EDIT_CONTACT_BUTTON = By.cssSelector("[auto-id='edit-contact-button']");
    private static final By CONTACT_LAST_NAME = By.cssSelector("[auto-id='contact-last-name']");
    private static final By CONTACT_FIRST_NAME = By.cssSelector("[auto-id='contact-first-name']");
    private static final By CONTACT_EMAIL = By.cssSelector("[auto-id='contact-email']");
    private static final By MODAL_CONTACT_LAST_NAME = By.cssSelector("[auto-id='modal-contact-details-last-name']");
    private static final By MODAL_CONTACT_FIRST_NAME = By.cssSelector("[auto-id='modal-contact-details-first-name']");
    private static final By MODAL_CONTACT_EMAIL = By.cssSelector("[auto-id='modal-contact-details-email']");
    private static final By MODAL_CONTACT_PHONE = By.cssSelector("[auto-id='modal-contact-details-phone']");
    private static final By MODAL_CONTACT_ADDRESS_LINE1 = By.cssSelector("[auto-id='modal-contact-details-address-line1']");
    private static final By MODAL_CONTACT_ADDRESS_LINE2 = By.cssSelector("[auto-id='modal-contact-details-address-line2']");
    private static final By MODAL_CONTACT_ZIP_CODE = By.cssSelector("[auto-id='modal-contact-details-zip-code']");
    private static final By MODAL_CONTACT_CITY = By.cssSelector("[auto-id='modal-contact-details-city']");
    private static final By MODAL_CONTACT_COUNTRY_SUB_DIVISION = By.cssSelector("[auto-id='modal-contact-details-country-sub-division']");
    private static final By MODAL_CONTACT_COUNTRY = By.cssSelector("[auto-id='modal-contact-details-country']");
    private static final By MODAL_CONTACT_DETAILS_CLOSE_BUTTON = By.cssSelector("[auto-id='modal-contact-details-close-button']");

    public ContactListPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void visit() {
        visit(CONTACTS);
    }

    public void addContact() {
        click(ADD_CONTACT_BUTTON);
    }

    public void editContact() {
        click(EDIT_CONTACT_BUTTON);
    }

    public void viewContact(String lastName) {
        clickByText(CONTACT_LAST_NAME, lastName);
    }

    public void closeContactDetails() {
        scrollIntoViewAndClick(MODAL_CONTACT_DETAILS_CLOSE_BUTTON);
    }

    public List<Contact> getContactDetailsInList() {
        List<Contact> contactList = new ArrayList<>();
        List<String> lastNameList = getTextOfAllElements(CONTACT_LAST_NAME);
        List<String> firstNameList = getTextOfAllElements(CONTACT_FIRST_NAME);
        List<String> emailList = getTextOfAllElements(CONTACT_EMAIL);

        for (int i = 0; i < lastNameList.size(); i++) {
            contactList.add(Contact.builder()
                .lastName(lastNameList.get(i))
                .firstName(firstNameList.get(i))
                .email(emailList.get(i))
                .build());
        }

        return contactList;
    }

    public Contact getContactDetailsInModal() {
        if (!isDisplayed(MODAL_CONTACT_LAST_NAME)) {
            return null;
        }

        return Contact.builder()
            .lastName(getText(MODAL_CONTACT_LAST_NAME))
            .firstName(getText(MODAL_CONTACT_FIRST_NAME))
            .email(getText(MODAL_CONTACT_EMAIL))
            .phone(getText(MODAL_CONTACT_PHONE))
            .addressLine1(getText(MODAL_CONTACT_ADDRESS_LINE1))
            .addressLine2(getText(MODAL_CONTACT_ADDRESS_LINE2))
            .zipCode(getText(MODAL_CONTACT_ZIP_CODE))
            .city(getText(MODAL_CONTACT_CITY))
            .countrySubDivision(getText(MODAL_CONTACT_COUNTRY_SUB_DIVISION))
            .country(getText(MODAL_CONTACT_COUNTRY))
            .build();
    }

}
