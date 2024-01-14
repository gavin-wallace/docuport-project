package com.loop.step_definitions.smart_bear_stepdefs;
import com.loop.pages.smart_bear_pages.SmartBearOrderPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
public class SmartBearOrderStepDef {
    SmartBearOrderPage smartBearOrderPage = new SmartBearOrderPage();
    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {new Select(smartBearOrderPage.productDropDown).selectByVisibleText(string);}
    @When("user enters quantity {int}")
    public void user_enters_quantity(Integer int1) {smartBearOrderPage.quantityInput.sendKeys("" + Keys.BACK_SPACE + int1);}
    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {
        smartBearOrderPage.customerName.sendKeys(string);
    }
    @When("user enters street {string}")
    public void user_enters_street(String string) {
        smartBearOrderPage.street.sendKeys(string);
    }
    @When("user enters city {string}")
    public void user_enters_city(String string) {
        smartBearOrderPage.city.sendKeys(string);
    }
    @When("user enters state {string}")
    public void user_enters_state(String string) {
        smartBearOrderPage.state.sendKeys(string);
    }
    @When("user enters zip {string}")
    public void user_enters_zip(String string) {
        smartBearOrderPage.zip.sendKeys(string);
    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String string) {
        smartBearOrderPage.selectCardType(string);
    }
    @When("user enters credit car number {string}")
    public void user_enters_credit_car_number(String string) {smartBearOrderPage.cardInformationInput.sendKeys(string);}
    @When("user enters expiration date {string}")
    public void user_enters_expiration_date(String string) {
        smartBearOrderPage.expirationDateInput.sendKeys(string);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        smartBearOrderPage.processButton.click();
    }
}
