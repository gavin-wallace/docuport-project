package com.loop.step_definitions.smart_bear_stepdefs;

import com.loop.pages.smart_bear_pages.SmartBearViewAllOrdersPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class SmartBearViewAllOrdersStepDef {
    SmartBearViewAllOrdersPage smartBearViewAllOrdersPage = new SmartBearViewAllOrdersPage();

    @Given("user is already logged in and navigated to order page")
    public void user_is_already_logged_in_and_navigated_to_order_page() {
        smartBearViewAllOrdersPage.smartBearLogin();
        smartBearViewAllOrdersPage.navigateTo("Order");
    }
    @Then("user should see {string} in the first row of the table")
    public void user_should_see_in_the_first_row_of_the_table(String string) {
        smartBearViewAllOrdersPage.navigateTo("View all orders");
        Assert.assertEquals(string,smartBearViewAllOrdersPage.firstFullName.getText());
    }

}
