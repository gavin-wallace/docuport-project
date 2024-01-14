package com.loop.pages.smart_bear_pages;

import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearLoginPage {

    public SmartBearLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='ctl00_MainContent_username']")
    private WebElement usernameInput;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_login_button']")
    private  WebElement loginButton;

    public void smartBearLogin (){
        Driver.getDriver().get(ConfigurationReader.getProperty("smartbearsoftware.url"));
        usernameInput.sendKeys(ConfigurationReader.getProperty("smart.username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("smart.password"));
        loginButton.click();
    }
}
