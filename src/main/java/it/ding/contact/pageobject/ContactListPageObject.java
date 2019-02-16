package it.ding.contact.pageobject;

import it.ding.contact.BasePage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ContactListPageObject extends BasePage {

    private static final String CONTACTS = "http://localhost:3000/contacts";

    public ContactListPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void visit() {
        visit(CONTACTS);
    }

}
