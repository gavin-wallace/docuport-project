package com.loop.pages.docuport_pages;

import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasePage extends LoginPage{

    @FindBy(xpath = "//button[@type='submit']//span")
    public WebElement continueButton;

    @FindBy(xpath = "//span[.='Log out']/../..")
    public WebElement logoutButton;

    @FindBy(xpath = "//div[@class='v-data-footer__pagination']")
    public WebElement totalResultCount; //1-10 of 869

    @FindBy(xpath = "//div[@class='v-avatar primary']/following-sibling::span")
    public WebElement userIcon; //First and Last name from upper right

    @FindBy(xpath = "//a[@href='/profile']")
    public WebElement profileButton; //First and Last name from upper right

    @FindBy(xpath = "//span[.='First name']/..//following-sibling::div//span")
    public WebElement firstName; //First and Last name from upper right

    @FindBy(xpath = "//span[.='Last name']/..//following-sibling::div//span")
    public WebElement lastname; //First and Last name from upper right

    @FindBy(xpath = "//span[.='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//span[.='Download']")
    public WebElement downloadButton;

    @FindBy(xpath = "//label[.='All']")
    public WebElement allRadioButton;

    @FindBy(xpath = "//span[.=' Search ']")
    public WebElement updateSearchButton;

    @FindBy(xpath = "//label[.='Phone number']//following-sibling::input")
    public WebElement searchPhoneNumber;

    @FindBy(xpath = "//label[.='Email address']//following-sibling::input")
    public WebElement searchEmailAddress;

    public List<WebElement> getNavigationItems(){
        return Driver.getDriver().findElements(By.xpath("//div[@role='listbox']//a"));
    }
    public String getPageHeaderText (){
        return Driver.getDriver().findElement(By.xpath("//div[@class='d-page__header']//h1")).getText();
    }

    public WebElement getSearchButton() {
        return Driver.getDriver().findElement(By.xpath("//span[.='Search']"));
    }

    public WebElement getDownloadButton() {
        return Driver.getDriver().findElement(By.xpath("//span[.='Download']"));
    }

    public void navigateItem(String itemName) {
        openLeftNavigationPanel();
        BrowserUtilities.justWait(1);
        for (WebElement each : Driver.getDriver().findElements(By.xpath("//div[@role='listbox']//a"))) {
            if (each.getText().equals(itemName)) {
                each.click();
            }
        }
    }

    public void openLeftNavigationPanel(){
        WebElement hamburgerButton = Driver.getDriver().findElement(By.xpath("//i[@class='v-icon notranslate mdi mdi-menu theme--light']/../.."));
        hamburgerButton.click();
    }

    public void closeLeftNavigationPanel(){
        Driver.getDriver().findElement(By.xpath("//button[@class='pa-0 v-btn v-btn--rounded v-btn--text theme--light v-size--default gray--text']")).sendKeys(Keys.ENTER, Keys.ENTER);
    }


    public int getResultCount() { //1-10 of 869 ----> 869
        String expectedCount = totalResultCount.getText().substring(totalResultCount.getText().lastIndexOf(" ") + 1);
        return Integer.parseInt(expectedCount);

    }
    //logout from all userTypes
    public void logout(){
        BrowserUtilities.waitForVisibility(userIcon, DocuportConstants.small).click();
        BrowserUtilities.waitForVisibility(logoutButton,DocuportConstants.small).sendKeys(Keys.ENTER);
        BrowserUtilities.waitForVisibility(username,DocuportConstants.small);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigurationReader.getProperty("docuport.ui.url")+"login");
    }

}
