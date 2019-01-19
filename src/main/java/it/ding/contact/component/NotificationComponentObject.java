package it.ding.contact.component;

import it.ding.contact.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NotificationComponentObject extends BasePage {

    private static final By NOTIFICATION_MESSAGE = By.cssSelector(".notification-message .message");

    public NotificationComponentObject(RemoteWebDriver driver) {
        super(driver);
    }

    public String getNotificationText() {
        isDisplayed(NOTIFICATION_MESSAGE);
        return getText(NOTIFICATION_MESSAGE);
    }

    public boolean isNotificationDisplayed() {
        return isDisplayed(NOTIFICATION_MESSAGE);
    }

}
