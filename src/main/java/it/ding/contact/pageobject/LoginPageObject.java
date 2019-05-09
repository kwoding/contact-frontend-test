package it.ding.contact.pageobject;

import static it.ding.contact.data.CommonData.PROPERTY_APP_BASE_URI;

import it.ding.contact.BasePage;
import it.ding.contact.util.GlobalProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPageObject extends BasePage {

    private static final GlobalProperties globalProperties = GlobalProperties.getInstance();
    private static final String BASE_URI = globalProperties.getString(PROPERTY_APP_BASE_URI);
    private static final By USERNAME = By.cssSelector("[auto-id='username']");
    private static final By PASSWORD = By.cssSelector("[auto-id='password']");
    private static final By LOGIN_BUTTON = By.cssSelector("[auto-id='login-button']");

    public LoginPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void visit() {
        visit(BASE_URI);
    }

    public void login(String username, String password) {
        type(USERNAME, username);
        type(PASSWORD, password);
        click(LOGIN_BUTTON);
    }

}
