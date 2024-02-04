package com.loop.pages.docuport_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@href='/received-docs']")
    public WebElement receivedDocumentsLink;
    @FindBy(xpath = "//a[@href='/my-uploads']")
    public WebElement myUploadsLink;



}
