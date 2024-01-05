package com.loop.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BrowserUtilities {

    /**
     * Validate if driver switched to expected url and title
     *
     * @param driver
     * @param expectedURL
     * @param expectedTitle
     * @author Gavin
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedURL, String expectedTitle) {
        expectedTitle = expectedTitle.toLowerCase();
        expectedURL = expectedURL.toLowerCase();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedURL)) {
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * switches to the new window by the exact title
     * return to orginal window if the window with given title not found
     *
     * @param driver
     * @param targetTitle
     * @author Gavin
     */

    public static void switchToWindow(WebDriver driver, String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    /**
     * @param expectedTitle returns void,assertion is implemented
     * @author Gavin
     */
    public static void validateTitle( String expectedTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    /**
     * Click any link from loop practice
     * @param nameOfPage
     * @author gavin
     */
    public static void loopLinkClick(String nameOfPage){
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='"+nameOfPage+"']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    /**
     * Moves the mouse to given element
     * @param element on which to hover
     * @author gavin
     */
    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }
    /**
     * Scrolls down to an element using JavaScript
     * @param element
     * @author gavin
     */
    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    /**
     * Clicks on an element using JavaScript
     * @param element
     * @author gavin
     */
    public static void clickWithJS(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }
    /**
     * Waits for the provided element to be visible on the page
     * @param element
     * @param timeToWaitInSec
     * @return WebElement
     * @author gavin
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec){
        return new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeToWaitInSec)).until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * Waits for the provided element to be invisible on the page
     * @param element
     * @param timeToWaitInSec
     * @author gavin
     */
    public static void waitForInvisibility(WebElement element, int timeToWaitInSec){
        new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeToWaitInSec)).until(ExpectedConditions.invisibilityOf(element));
    }
    /**
     * Waits for the provided element to be invisible on the page
     * @param element
     * @param timeToWaitInSec
     * @return WebElement
     * @author gavin
     */
    public static WebElement waitForClickable (WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /**
     * performs a pause
     * @param seconds
     * @author nadir
     */
    public static void justWait (int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void printAllLinks (List<WebElement> elementsList){
        elementsList.forEach( each -> System.out.println(each.getAttribute("href")));
    }

    public static void printLinkText (List<WebElement> elementsList){
        elementsList.forEach( each -> System.out.println(each.getText()));
    }


    public static void main(String[] args) {
        String [] arr = {"five","ten","eleven"};

    }

}

