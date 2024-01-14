package com.loop.pages.smart_bear_pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartBearOrderPage extends SmartBearBasePage {
    @FindBy(tagName = "select")
    public WebElement productDropDown;
    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']")
    public WebElement quantityInput;

    @FindBy(name = "ctl00$MainContent$fmwOrder$txtName")
    public WebElement customerName;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")
    public WebElement street;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")
    public WebElement city;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")
    public WebElement state;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")
    public WebElement zip;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox6']")
    public WebElement cardInformationInput;
    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox1']")
    public WebElement expirationDateInput;
    @FindBy(xpath = "//a[.='Process']")
    public WebElement processButton;

    public void selectCardType (String string){
        Driver.getDriver().findElement(By.xpath("//label[.='"+string+"']")).click();
    }

}
