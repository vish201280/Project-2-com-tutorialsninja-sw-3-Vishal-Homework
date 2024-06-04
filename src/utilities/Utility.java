package utilities;


import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.UUID;

public class Utility extends BaseTest {

    //This method send text on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //This method will send text to element
    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    // This method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //*********************************Alert Methods ***********************************//

    //This method will switch to alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //This method will accept to alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    // This method will dismiss the alert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //This method will get text from the alert

    public String getTextFromAlert(String text) {
        return text;
    }

    // This method will send text the alert
    public String sendTextToAlert(String key) {
        driver.switchTo().alert().sendKeys(key);
        return key;
    }

    //*************************** Select Class Methods *************************//


    //This method will select the option by visible text
    public void selectByValueFromDropDown(By by, String value) {

        new Select(driver.findElement(by)).selectByValue(value);

    }

    public void selectByIndexFromDropDown(By by, int index) {

        new Select(driver.findElement(by)).selectByIndex(index);

    }

    public void selectByVisibleFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByAllOptionsFromDropDown(By by) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        List<WebElement> allSelectOptions = select.getAllSelectedOptions();
    }
    //*************************** Action Methods ***************************//

    // This method will use to hover mouse on element
//This method will mouse hover on element and click
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void toClear(By by) {
        driver.findElement(by).clear();
    }

    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
        // actions.moveToElement(driver.findElement(by)).moveToElement(driver.findElement(by1)).click().build().perform();
    }

    public static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    }

    public void selectMenu(String menu) {
        WebElement menu1 = driver.findElement(By.linkText(menu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu1).click().perform();
    }

    /**
     * This method will verify the expected and actual result
     */
    public void assertionMethod(String message, String expected, By by) {
        String actual = getTextFromElement(by);
        Assert.assertEquals(" ", expected, actual);
    }
}