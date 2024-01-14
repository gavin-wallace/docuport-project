package com.loop.pages;

import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.DocuportConstants;
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

    public void loginDocuport(String username, String password){
        BrowserUtilities.waitForVisibility(this.username, DocuportConstants.small);
        this.username.click();
        this.username.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
        BrowserUtilities.waitForClickable(loginButton,DocuportConstants.small);
        loginButton.click();
        if(BrowserUtilities.waitForVisibility(continueButton,5).isDisplayed()){
            continueButton.click();
        }
    }

}
