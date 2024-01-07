package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocuportLoginPage {

    public DocuportLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//label[.='Username or email']//following-sibling::input")
    public WebElement username;

    @FindBy(xpath = "//label[.='Password']//following-sibling::input")
    public WebElement password;

    @FindBy(xpath = "//span[.=' Log in ']/..")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@type='submit']//span")
    public WebElement continueButton;


//    @FindBy (xpath = "")
//    public WebElement element;
}
