package com.loop.pages.smart_bear_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartBearBasePage extends SmartBearLoginPage{

    @FindBy(xpath = "//a[.='Order']")
    private static WebElement orderButton;
    @FindBy(xpath = "//a[.='View all orders']")
    private static WebElement viewAllOrder;

    public void navigateTo (String panelItem){
        if(panelItem.equals("Order")){
            orderButton.click();
        } else if (panelItem.equals("View all orders")){
            viewAllOrder.click();
        }
    }
}
