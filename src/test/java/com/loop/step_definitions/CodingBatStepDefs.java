package com.loop.step_definitions;

import com.loop.pages.CodingBatPage;
import io.cucumber.java.en.*;

import static com.loop.pages.CodingBatPage.*;
import static com.loop.utilities.ConfigurationReader.*;
import static com.loop.utilities.Driver.getDriver;
import static org.junit.Assert.*;

public class CodingBatStepDefs {

    CodingBatPage codingBatPage = new CodingBatPage();

    //-- Background

    @Given("Given a user is on the CodingBat Java page")
    public void given_a_user_is_on_the_coding_bat_java_page() {
        getDriver().get("https://codingbat.com/java");
    }

    //---   Scenario: Coding Bat Login

    @When("the user enters their id or email")
    public void the_user_enters_their_id_email() {
        getIdOrEmail().sendKeys("gwwlax@gmail.com");
    }

    @When("the user enters their password")
    public void the_user_enters_their_password() {
        getPassword().sendKeys(getProperty("txt"));
    }

    @When("the user clicks login")
    public void the_user_clicks_login() {
        getLogin().click();
    }

    @Then("the user is logged in")
    public void the_user_is_logged_in() {
        assertTrue(getLogout().isDisplayed());
    }

    //---   Scenario: Coding Bat Logout

    @When("the user clicks logout")
    public void the_user_clicks_log_out() {
        getLogout().click();
    }
    @Then("the user is logged out")
    public void the_user_is_logged_out() {
        assertTrue(getLogin().isDisplayed());
    }

    // Python Tab

    @Given("the user selects the Python tab")
    public void the_user_selects_the_python_tab() {
        getPythonTab().click();
    }

    // Parametrized

    @Then("assert {string} is displayed")
    public void assert_is_displayed(String string) {
        switch (string) {
            case "Python Help":
                assertTrue(getPythonHelp().isDisplayed());
                break;
            case "Java Help":
                assertTrue(getJavaHelp().isDisplayed());
                break;
        }
    }

    @Then("print the {string} Help links")
    public void print_the_help_links(String string) {
        switch (string) {
            case "Python":
                printHelpLinks(getPythonHelpElementsList());
                break;
            case "Java":
                printHelpLinks(getJavaHelpElementsList());
                break;
        }
    }

    @Then("assert {string} tab is selected")
    public void assert_tab_is_selected(String string) {
        switch (string) {
            case "Python":
                assertEquals("selected", getPythonTabLi().getAttribute("id"));
                break;
            case "Java":
                assertEquals("selected", getJavaTabLi().getAttribute("id"));
                break;
        }
    }


    @When("the user clicks each {string} problem group and each task")
    public void the_user_clicks_each_problem_group_and_each_task(String string) {
        clickEachProblemAndTask();
    }

    @Then("the user prints each {string} task link and webpage title")
    public void the_user_prints_each_task_link_and_webpage_title(String string) {
        switch (string) {
            case "Python":
                assertTrue(getDriver().getTitle().contains("CodingBat Python"));
                break;
            case "Java":
                assertTrue(getDriver().getTitle().contains("CodingBat Java"));
                break;
        }
    }

}
