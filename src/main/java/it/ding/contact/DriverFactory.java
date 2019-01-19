package it.ding.contact;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

class DriverFactory {

    private static RemoteWebDriver driver;

    private DriverFactory() {

    }

    static void setDriver() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
    }

    static RemoteWebDriver getDriver() {
        return driver;
    }

}
