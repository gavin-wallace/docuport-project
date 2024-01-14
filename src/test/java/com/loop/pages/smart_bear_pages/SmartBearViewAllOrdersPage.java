package com.loop.pages.smart_bear_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartBearViewAllOrdersPage extends SmartBearBasePage{

    @FindBy(xpath = "(//th[.='Name']/..//following-sibling::tr//td)[2]")
    public WebElement firstFullName;
}
