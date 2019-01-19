package it.ding.contact.pageobject;

import it.ding.contact.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPageObject extends BasePage {

    private static final String LOGIN_URL = "http://localhost:3000";
    private static final By USERNAME = By.cssSelector("[auto-id='username']");
    private static final By PASSWORD = By.cssSelector("[auto-id='password']");
    private static final By LOGIN_BUTTON = By.cssSelector("[auto-id='login-button']");

    public LoginPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void visit() {
        visit(LOGIN_URL);
    }

    public void login(String username, String password) {
        type(USERNAME, username);
        type(PASSWORD, password);
        click(LOGIN_BUTTON);
    }

}
