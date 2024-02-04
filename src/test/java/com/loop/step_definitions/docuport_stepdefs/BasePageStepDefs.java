package com.loop.step_definitions.docuport_stepdefs;

import com.loop.pages.docuport_pages.BasePage;
import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BasePageStepDefs {

    static BasePage basePage = new BasePage();
    @Then("validate the left navigation items for each user type")
    public void validate_the_left_navigation_items_for_each_user_type(Map<String,String> map) {
        map.forEach((userType,expectedLeftNavigationItems)->{
            //login based on usertype
            basePage.loginDocuport(userType);

            //creates actualList
            List<String> actualLeftNavigationItems = new ArrayList<>();

            //finds left navigation web elements and then adds text of elements into actualList
            Driver.getDriver().findElements(By.xpath("//div[@role='listbox']//a")).forEach(each->{
                actualLeftNavigationItems.add(each.getText());});

            //Compares actual and expected lists of left navigation items
            Assert.assertEquals(actualLeftNavigationItems.toString(), expectedLeftNavigationItems);

            //logs out of user
            basePage.logout();
        });
    }

    @Then("user validates {string}")
    public void user_validates(String expectedLeftNavigationItems) {
        //creates actualList
        List<String> actualLeftNavigationItems = new ArrayList<>();

        //finds left navigation web elements and then adds text of elements into actualList
        basePage.getNavigationItems().forEach(each->{
            actualLeftNavigationItems.add(each.getText());});

        BrowserUtilities.justWait(1);
        //Compares actual and expected lists of left navigation items
        Assert.assertEquals(expectedLeftNavigationItems,actualLeftNavigationItems.toString());
    }
    
    @When("the user navigates to {string}")
    public void the_user_navigates_to(String string) {
        basePage.navigateItem(string);
    }

    @Then("assert search button, download button, and {string} is displayed")
    public void assert_search_button_download_button_and_is_displayed(String string) {
        Assert.assertTrue(basePage.getSearchButton().isDisplayed());
        Assert.assertTrue(basePage.getDownloadButton().isDisplayed());
        Assert.assertEquals(basePage.getPageHeaderText(), string);
    }

}
