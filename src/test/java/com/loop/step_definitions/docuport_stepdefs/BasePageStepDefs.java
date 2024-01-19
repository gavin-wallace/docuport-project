package com.loop.step_definitions.docuport_stepdefs;

import com.loop.pages.docuport_pages.BasePage;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BasePageStepDefs {

    static BasePage basePage = new BasePage();
    @Then("validate the left navigation items for each user type")
    public void validate_the_left_navigation_items_for_each_user_type(Map<String,List<String>> mapOfStringAndList) {
        mapOfStringAndList.forEach((userType,expectedLeftNavigationItems)->{
            //login based on usertype
            basePage.loginDocuport(userType);

            //removes null values from expected list
            expectedLeftNavigationItems.removeIf(Objects::isNull);

            //creates actualList
            List<String> actualLeftNavigationItems = new ArrayList<>();

            //finds left navigation web elements and then adds text of elements into actualList
            Driver.getDriver().findElements(By.xpath("//div[@role='listbox']//a")).forEach(each->{
                actualLeftNavigationItems.add(each.getText());});

            //Compares actual and expected lists of left navigation items
            Assert.assertEquals(actualLeftNavigationItems,expectedLeftNavigationItems);

            //logs out of user
            basePage.logout();
        });
    }
}
