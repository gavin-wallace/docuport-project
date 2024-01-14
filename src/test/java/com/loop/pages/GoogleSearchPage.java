package com.loop.pages;

import com.loop.step_definitions.GoogleSearchStepDefs;
import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public static final String LOOP_ACADEMY = "Loop Academy";

    @FindBy (id = "APjFqb")
    public WebElement searchBox;

    @FindBy (xpath = "//input[@id='gbqfbb']/preceding-sibling::input")
    public WebElement searchButton;

    @FindBy (xpath = "//h2[@data-dtype]//span")
    public WebElement capital;
}
