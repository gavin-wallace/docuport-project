package com.loop.step_definitions;

import com.loop.pages.DocuportLoginPage;
import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;

public class LoginStepDefs {

    public DocuportLoginPage docuportLoginPage = new DocuportLoginPage();

    //------------------ Applies to all

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        docuportLoginPage.loginButton.click();
    }

    //------------------ Applies to client

    @When("user enters username for client")
    public void user_enters_username_for_client() {
        docuportLoginPage.username.sendKeys(DocuportConstants.USERNAME_ClIENT);
    }

    @When("user enters password for client")
    public void user_enters_password_for_client() {
        docuportLoginPage.password.sendKeys(DocuportConstants.getPassword());
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
}
