package com.loop.step_definitions;

import com.loop.pages.DocuportLoginPage;
import com.loop.utilities.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;

public class LoginStepDefs {

    DocuportLoginPage docuportLoginPage = new DocuportLoginPage();
    Actions actions = new Actions(Driver.getDriver());

    //------------------ Applies to all
    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        BrowserUtilities.takeScreenshot();
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
        if (string.equals("client")){
            BrowserUtilities.justWait(3);
            BrowserUtilities.waitForClickable(docuportLoginPage.continueButton,DocuportConstants.large).click();
        } else {
            Driver.getDriver().findElement(By.xpath("//button[@class='pa-0 v-btn v-btn--rounded v-btn--text theme--light v-size--default gray--text']")).sendKeys(Keys.ENTER, Keys.ENTER);
        }
        BrowserUtilities.validateTitle(DocuportConstants.HOME_PAGE_TITLE);
        BrowserUtilities.takeScreenshot();
    }
    //---------------- Logout for all logins
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
    //--
    @When("user enter credentials")
    public void user_enter_credentials(Map<String,String> credentials) {
//        for (Map.Entry<String,String> entry : credentials.entrySet()){
//            String key = entry.getKey();
//            String value = entry.getValue();
//            System.out.println("key = " + key);
//            System.out.println("value = " + value);
//        }
        docuportLoginPage.loginDocuport(credentials.get("username"),credentials.get("password"));
    }
    @Then("user should see the home page")
    public void user_should_see_the_home_page_for() {
        BrowserUtilities.validateTitle(DocuportConstants.HOME_PAGE_TITLE);
        BrowserUtilities.takeScreenshot();
    }
}
