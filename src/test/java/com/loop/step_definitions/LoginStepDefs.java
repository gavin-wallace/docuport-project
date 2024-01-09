package com.loop.step_definitions;

import com.loop.pages.DocuportLoginPage;
import com.loop.utilities.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class LoginStepDefs {

    DocuportLoginPage docuportLoginPage = new DocuportLoginPage();
    Actions actions = new Actions(Driver.getDriver());

    //------------------ Applies to all

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        BrowserUtilities.waitForVisibility(docuportLoginPage.loginButton,DocuportConstants.small).click();
    }

    //------------------ Applies to client

    @When("user enters username for client")
    public void user_enters_username_for_client() {
        docuportLoginPage.username.sendKeys(DocuportConstants.USERNAME_CLIENT);
    }

    @When("user enters password for client")
    public void user_enters_password_for_client() {
        docuportLoginPage.password.sendKeys(DocuportConstants.getPassword());
    }

    @When("user should see and click the continue button")
    public void use_should_see_and_click_the_continue_button() {
        BrowserUtilities.justWait(1500);
        BrowserUtilities.waitForClickable(docuportLoginPage.continueButton,DocuportConstants.small).click();
    }

    @Then("user should see the home page for client")
    public void user_should_see_the_home_page_for_client() {
        BrowserUtilities.validateTitle(DocuportConstants.HOME_PAGE_TITLE);
    }

    //------------------ Applies to employee

    @When("user enters username for employee")
    public void user_enters_username_for_employee() {
        docuportLoginPage.username.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
    }

    @When("user enters password for employee")
    public void user_enters_password_for_employee() {
        docuportLoginPage.password.sendKeys(DocuportConstants.getPassword());
    }

    @When("user closes left navigation window")
    public void user_closes_left_navigation_window() {
        Driver.getDriver().findElement(By.xpath("//button[@class='pa-0 v-btn v-btn--rounded v-btn--text theme--light v-size--default gray--text']")).sendKeys(Keys.ENTER, Keys.ENTER);
    }

    @Then("user should see the home page for employee")
    public void user_should_see_the_home_page_for_employee() {
        BrowserUtilities.validateTitle(DocuportConstants.HOME_PAGE_TITLE);
    }

    //---------------- Applies to supervisor

    @When("user enters username for supervisor")
    public void user_enters_username_for_supervisor() {
        docuportLoginPage.username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
    }

    @When("user enters password for supervisor")
    public void user_enters_password_for_supervisor() {
        docuportLoginPage.password.sendKeys(DocuportConstants.getPassword());
    }

    @Then("user should see the home page for supervisor")
    public void user_should_see_the_home_page_for_supervisor() {
        BrowserUtilities.validateTitle(DocuportConstants.HOME_PAGE_TITLE);
    }

    //---------------- Applies to advisor

    @When("user enters username for advisor")
    public void user_enters_username_for_advisor() {
        docuportLoginPage.username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
    }

    @When("user enters password for advisor")
    public void user_enters_password_for_advisor() {
        docuportLoginPage.password.sendKeys(DocuportConstants.getPassword());
    }

    @Then("user should see the home page for advisor")
    public void user_should_see_the_home_page_for_advisor() {
        BrowserUtilities.validateTitle(DocuportConstants.HOME_PAGE_TITLE);
    }

    //---------------- Logout for all logins

    @Given("user is logged in")
    public void user_is_logged_in_as_client() {
        BrowserUtilities.validateTitle(DocuportConstants.HOME_PAGE_TITLE);
    }

    @When("user clicks the user logo")
    public void user_clicks_the_user_logo() {
        BrowserUtilities.waitForVisibility(Driver.getDriver().findElement(By.xpath("//button[@class='pa-0 v-btn v-btn--rounded v-btn--text theme--light v-size--default gray--text']")),DocuportConstants.small).click();
    }

    @When("the user clicks Log out")
    public void the_user_clicks() {
        BrowserUtilities.waitForVisibility(Driver.getDriver().findElement(By.xpath("//span[.='Log out']/../..")),DocuportConstants.small).sendKeys(Keys.ENTER);
    }

    @Then("the user return to the login page")
    public void the_user_return_to_the_login_page() {
        BrowserUtilities.waitForVisibility(docuportLoginPage.username,DocuportConstants.small);
        Assert.assertEquals(DocuportConstants.LOGIN_PAGE_URL, Driver.getDriver().getCurrentUrl());
    }

}
