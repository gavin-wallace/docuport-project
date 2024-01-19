package com.loop.pages.docuport_pages;

import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//label[.='Username or email']//following-sibling::input")
    public WebElement username;

    @FindBy(xpath = "//label[.='Password']//following-sibling::input")
    public WebElement password;

    @FindBy(xpath = "//span[.=' Log in ']/..")
    public WebElement loginButton;

    public void loginDocuport(String usertype){

        //get test env
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //wait for username to be visible
        BrowserUtilities.waitForVisibility(username, DocuportConstants.small);

        //clear username field
        username.clear();

        //assigns temp to the email string for each userType
        String temp = switch (usertype) {
            case "client" -> DocuportConstants.USERNAME_CLIENT;
            case "employee" -> DocuportConstants.USERNAME_EMPLOYEE;
            case "supervisor" -> DocuportConstants.USERNAME_SUPERVISOR;
            case "advisor" -> DocuportConstants.USERNAME_ADVISOR;
            default -> throw new IllegalStateException("Unexpected value: " + usertype);
        };

        //Sends username keys
        username.sendKeys(temp);

        //clear and send password
        password.clear();
        password.sendKeys(DocuportConstants.getPassword());

        //wait for login button to be clickable and click
        BrowserUtilities.waitForClickable(loginButton,DocuportConstants.small).click();

        //if client, click continue
        BasePage basePage = new BasePage();
        if (usertype.equals("client")){
            BrowserUtilities.justWait(3);
            BrowserUtilities.waitForClickable(basePage.continueButton,DocuportConstants.large).click();
        } else {
            //closes left navigation items so landing page is visible
            Driver.getDriver().findElement(By.xpath("//button[@class='pa-0 v-btn v-btn--rounded v-btn--text theme--light v-size--default gray--text']")).sendKeys(Keys.ENTER, Keys.ENTER);
        }
    }

    //logout from all userTypes
    public void logout(){
        BrowserUtilities.waitForVisibility(Driver.getDriver().findElement(By.xpath("//button[@class='pa-0 v-btn v-btn--rounded v-btn--text theme--light v-size--default gray--text']")),DocuportConstants.small).click();
        BrowserUtilities.waitForVisibility(Driver.getDriver().findElement(By.xpath("//span[.='Log out']/../..")),DocuportConstants.small).sendKeys(Keys.ENTER);
        BrowserUtilities.waitForVisibility(username,DocuportConstants.small);
    }





//used on previous task/stepdef
    public void loginDocuport2(String username, String password){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        BrowserUtilities.waitForVisibility(this.username, DocuportConstants.small);
        this.username.click();
        this.username.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
        BrowserUtilities.waitForClickable(loginButton,DocuportConstants.small);
        loginButton.click();
        BasePage basePage = new BasePage();
        if(BrowserUtilities.waitForVisibility(basePage.continueButton,5).isDisplayed()){
            basePage.continueButton.click();
        }
    }

}
