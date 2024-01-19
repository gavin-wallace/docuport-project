package com.loop.pages.docuport_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends LoginPage{

    @FindBy(xpath = "//button[@type='submit']//span")
    public WebElement continueButton;
}
