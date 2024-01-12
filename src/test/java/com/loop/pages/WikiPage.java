package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPage {

    public WikiPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "searchInput")
    public WebElement searchBox;

    @FindBy(xpath = "//h1[@id='firstHeading']//span")
    public WebElement mainHeaderText;

    @FindBy(xpath = "//table[contains(@class,'vcard')]//th//div")
    public WebElement imageHeaderText;
}
