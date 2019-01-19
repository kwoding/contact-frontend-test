package it.ding.contact;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private RemoteWebDriver driver;

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void visit(String url) {
        driver.get(url);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void clickByText(By locator, String text) {
        List<WebElement> elementList = findAll(locator);

        elementList.stream()
            .filter(webElement -> text.equals(webElement.getText()))
            .findFirst()
            .orElseThrow(() -> new org.openqa.selenium.NoSuchElementException("No element found containing " + text))
            .click();
    }

    public void forceClick(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void type(By locator, String inputText) {
        clear(locator);
        find(locator).sendKeys(inputText);
    }

    public void select(By locator, String text) {
        Select selectItem = new Select(find(locator));
        selectItem.selectByVisibleText(text);
    }

    public void clear(By locator) {
        find(locator).clear();
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public List<String> getTextOfAllElements(By locator) {
        List<String> textList = new ArrayList<>();
        List<WebElement> elementList = findAll(locator);

        for (WebElement element : elementList) {
            textList.add(element.getText());
        }

        return textList;
    }

    public boolean isDisplayed(By locator) {
        return isDisplayed(locator, 3000);
    }

    public boolean isDisplayed(By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

    public boolean isDisplayed(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

    public boolean textPresentInElement(By locator, String searchString, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, searchString));
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

    public String getVisibleText(By locator) {
        return find(locator).getText();
    }

    public String getAttributeValue(By locator, String attribute) {
        return find(locator).getAttribute(attribute);
    }
}
