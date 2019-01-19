package it.ding.contact.pageobject;

import it.ding.contact.BasePage;
import it.ding.contact.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ContactListPageObject extends BasePage {

    private static final String CONTACTS = "http://localhost:3000/contacts";
    private static final By ADD_CONTACT_BUTTON = By.cssSelector("[auto-id='add-contact-button']");
    private static final By EDIT_CONTACT_BUTTON = By.cssSelector("[auto-id='edit-contact-button']");
    private static final By DELETE_CONTACT_BUTTON = By.cssSelector("[auto-id='delete-contact-button']");
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
    private static final By MODAL_DELETE_CONTACT_BUTTON = By.cssSelector("[auto-id='modal-delete-contact-button']");
    private static final By MODAL_CANCEL_DELETE_CONTACT_BUTTON = By.cssSelector("[auto-id='modal-cancel-delete-contact-button']");
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

    public void viewContact() {
        click(CONTACT_LAST_NAME);
    }

    public void editContact() {
        click(EDIT_CONTACT_BUTTON);
    }

    public void invokeDeleteContact() {
        click(DELETE_CONTACT_BUTTON);
    }

    public void confirmDeleteContact() {
        forceClick(MODAL_DELETE_CONTACT_BUTTON);
    }

    public void cancelDeleteContact() {
        forceClick(MODAL_CANCEL_DELETE_CONTACT_BUTTON);
    }

    public void closeContactDetails() {
        forceClick(MODAL_CONTACT_DETAILS_CLOSE_BUTTON);
    }

    public Contact getContactDetailsInList() {
        return Contact.builder()
            .lastName(getText(CONTACT_LAST_NAME))
            .firstName(getText(CONTACT_FIRST_NAME))
            .email(getText(CONTACT_EMAIL))
            .build();
    }

    public Contact getContactDetailsInModal() {
        isDisplayed(MODAL_CONTACT_LAST_NAME);
        isDisplayed(MODAL_CONTACT_DETAILS_CLOSE_BUTTON);

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
