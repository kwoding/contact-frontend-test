package it.ding.contact.pageobject;

import it.ding.contact.BasePage;
import it.ding.contact.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AddEditContactPageObject extends BasePage {

    private static final By SAVE_CONTACT_BUTTON = By.cssSelector("[auto-id='save-contact-button']");
    private static final By CANCEL_SAVE_CONTACT_BUTTON = By.cssSelector("[auto-id='cancel-save-contact-button']");
    private static final By CONTACT_LAST_NAME = By.cssSelector("[auto-id='contact-last-name']");
    private static final By CONTACT_FIRST_NAME = By.cssSelector("[auto-id='contact-first-name']");
    private static final By CONTACT_EMAIL = By.cssSelector("[auto-id='contact-email']");
    private static final By CONTACT_PHONE = By.cssSelector("[auto-id='contact-phone']");
    private static final By CONTACT_ADDRESS_LINE1 = By.cssSelector("[auto-id='contact-address-line1']");
    private static final By CONTACT_ADDRESS_LINE2 = By.cssSelector("[auto-id='contact-address-line2']");
    private static final By CONTACT_ZIP_CODE = By.cssSelector("[auto-id='contact-zip-code']");
    private static final By CONTACT_CITY = By.cssSelector("[auto-id='contact-city']");
    private static final By CONTACT_COUNTRY_SUB_DIVISION = By.cssSelector("[auto-id='contact-country-sub-division']");
    private static final By CONTACT_COUNTRY = By.cssSelector("[auto-id='contact-country']");
    private static final By ALERT = By.cssSelector("[auto-id='alert']");

    public AddEditContactPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void saveContact() {
        click(SAVE_CONTACT_BUTTON);
    }

    public void cancelSaveContact() {
        click(CANCEL_SAVE_CONTACT_BUTTON);
    }

    public void enterContactDetails(Contact contact) {
        type(CONTACT_LAST_NAME, contact.getLastName());
        type(CONTACT_FIRST_NAME, contact.getFirstName());
        type(CONTACT_EMAIL, contact.getEmail());
        type(CONTACT_PHONE, contact.getPhone());
        type(CONTACT_ADDRESS_LINE1, contact.getAddressLine1());
        type(CONTACT_ADDRESS_LINE2, contact.getAddressLine2());
        type(CONTACT_ZIP_CODE, contact.getZipCode());
        type(CONTACT_CITY, contact.getCity());
        type(CONTACT_COUNTRY_SUB_DIVISION, contact.getCountrySubDivision());
        type(CONTACT_COUNTRY, contact.getCountry());
    }

    public Contact getContactDetails() {
        return Contact.builder()
            .lastName(getText(CONTACT_LAST_NAME))
            .firstName(getText(CONTACT_FIRST_NAME))
            .email(getText(CONTACT_EMAIL))
            .phone(getText(CONTACT_PHONE))
            .addressLine1(getText(CONTACT_ADDRESS_LINE1))
            .addressLine2(getText(CONTACT_ADDRESS_LINE2))
            .city(getText(CONTACT_CITY))
            .zipCode(getText(CONTACT_ZIP_CODE))
            .countrySubDivision(getText(CONTACT_COUNTRY_SUB_DIVISION))
            .country(getText(CONTACT_COUNTRY))
            .build();
    }

    public String getAlert() {
        return getText(ALERT);
    }

    public boolean isAlertDisplayed() {
        return isDisplayed(ALERT);
    }

}
