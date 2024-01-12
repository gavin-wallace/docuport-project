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

    @When("user enters username for {string}")
    public void userEntersUsernameFor(String string) throws Exception {
        String temp = switch (string) {
            case "client" -> DocuportConstants.USERNAME_CLIENT;
            case "employee" -> DocuportConstants.USERNAME_EMPLOYEE;
            case "supervisor" -> DocuportConstants.USERNAME_SUPERVISOR;
            case "advisor" -> DocuportConstants.USERNAME_ADVISOR;
            default -> throw new Exception("Invalid Role");
        };
        docuportLoginPage.username.sendKeys(temp);
    }

    @When("user enters password for {string}")
    public void user_enters_password_for(String string) {
        docuportLoginPage.password.sendKeys(DocuportConstants.getPassword());
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        BrowserUtilities.waitForVisibility(docuportLoginPage.loginButton,DocuportConstants.small).click();
    }

    @Then("user should see the home page for {string}")
    public void user_should_see_the_home_page_for(String string) {
        BrowserUtilities.validateTitle(DocuportConstants.HOME_PAGE_TITLE);
        BrowserUtilities.takeScreenshot();
    }

    //------------------ Applies to client

    @When("user should see and click the continue button")
    public void use_should_see_and_click_the_continue_button() {
        BrowserUtilities.justWait(1500);
        BrowserUtilities.waitForClickable(docuportLoginPage.continueButton,DocuportConstants.small).click();
    }

    //------------------ Applies to employee

    @When("user closes left navigation window")
    public void user_closes_left_navigation_window() {
        Driver.getDriver().findElement(By.xpath("//button[@class='pa-0 v-btn v-btn--rounded v-btn--text theme--light v-size--default gray--text']")).sendKeys(Keys.ENTER, Keys.ENTER);
    }

    //---------------- Applies to supervisor


    //---------------- Applies to advisor


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
        BrowserUtilities.takeScreenshot();
    }
}
