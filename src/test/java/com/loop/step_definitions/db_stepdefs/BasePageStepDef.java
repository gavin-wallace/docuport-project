package com.loop.step_definitions.db_stepdefs;

import com.loop.pages.docuport_pages.BasePage;
import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.DB_Utility;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BasePageStepDef {

    BasePage basePage= new BasePage();;

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String string) {
        basePage.loginDocuport(string);
    }

    String firstName;
    String lastName;
    @When("the advisor gets account holder name")
    public void the_advisor_gets_account_holder_name() {
        basePage.closeLeftNavigationPanel();
        basePage.userIcon.click();
        basePage.profileButton.click();
        firstName = basePage.firstName.getText();
        lastName = basePage.lastname.getText();
    }

    @Then("verify ui account name is in db")
    public void verify_ui_account_name_is_in_db() {
        DB_Utility.runQuery("select * from document.users where first_name = '"+firstName+"' and last_name = '"+lastName+"'");
        Assert.assertTrue(DB_Utility.getRowCount()>0);
    }

    @Then("validate the drop down options after clicking the user icon")
    public void validate_the_drop_down_options_after_clicking_the_user_icon(Map<String, List<String>> expectedMap) {
        expectedMap.forEach((userType,expectedList)->{
            basePage.loginDocuport(userType);
            expectedList.removeIf(Objects::isNull);
            List<String> actualList = new ArrayList<>();

            basePage.userIcon.click();
            BrowserUtilities.waitForVisibility(basePage.logoutButton,5);
            Driver.getDriver().findElements(By.xpath("//div[@role='menu']//span")).forEach(each->{
                actualList.add(each.getText());
            });

            Assert.assertEquals(actualList,expectedList);

            basePage.logout();
        });

    }
}
