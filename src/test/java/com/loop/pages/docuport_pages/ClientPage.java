package com.loop.pages.docuport_pages;

import com.loop.utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientPage extends BasePage{

    @FindBy(xpath = "//span[.='Create new client']")
    public WebElement createNewClientButton;

    @FindBy(xpath = "//span[.='Business']/../../..//following-sibling::div//div//div//span")
    public WebElement personalOption;

    @FindBy(xpath = "//span[.='Business']")
    public WebElement businessOption;

    @FindBy(xpath = "//label[.='First name']/following-sibling::input")
    public WebElement firstNameInput;

    @FindBy(xpath = "//label[.='Last name']/following-sibling::input")
    public WebElement lastNameInput;

    @FindBy(xpath = "//label[.='Company name']/following-sibling::input")
    public WebElement companyName;

    @FindBy(xpath = "//label[.='Create new user']/..//div//div")
    public WebElement createUserBox;

    @FindBy(xpath = "//label[.='Email address']/following-sibling::input")
    public WebElement emailAddress;

    @FindBy(xpath = "//label[.='Phone number']/following-sibling::input")
    public WebElement phoneNumber;

    @FindBy(xpath = "//label[.='Password']/following-sibling::input")
    public WebElement password;

    @FindBy(xpath = "//label[.='Confirm password']/following-sibling::input")
    public WebElement confirmPassword;

    @FindBy(xpath = "//label[.='Advisor']//following-sibling::input")
    public WebElement advisorDropDown;

    @FindBy(xpath = "//div[.='Batch1 Group1']//div//div")
    public WebElement b1g1Option;


    @FindBy(xpath = "//label[.='Name']//following-sibling::input")
    public WebElement searchName;






    @FindBy(xpath = "//span[.=' Save ']/..")
    public WebElement saveButton;

    public void createPersonalClient (String firstName, String lastName, String emailAddress,String phoneNumber, String password ){
        BrowserUtilities.waitForClickable(createNewClientButton, 5).click();
            BrowserUtilities.waitForClickable(personalOption, 5).click();
            BrowserUtilities.waitForVisibility(createUserBox, 5).click();

            firstNameInput.sendKeys(firstName);
            lastNameInput.sendKeys(lastName);
            this.emailAddress.sendKeys(emailAddress);
            advisorDropDown.click();
            b1g1Option.click();
            this.phoneNumber.sendKeys(phoneNumber);
            this.password.sendKeys(password);
            confirmPassword.sendKeys(password);
            saveButton.click();
    }
    public void createBusinessClient (String firstName, String lastName, String emailAddress,String phoneNumber, String password, String companyName ){
        BrowserUtilities.waitForClickable(createNewClientButton, 5).click();
        BrowserUtilities.waitForClickable(businessOption, 5).click();
        BrowserUtilities.waitForVisibility(createUserBox, 5).click();

        this.companyName.sendKeys(companyName);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        this.emailAddress.sendKeys(emailAddress);
        advisorDropDown.click();
        b1g1Option.click();
        this.phoneNumber.sendKeys(phoneNumber);
        this.password.sendKeys(password);
        confirmPassword.sendKeys(password);
        saveButton.click();
    }


}
