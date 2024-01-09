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

    @Then("assert Java is selected")
    public void assert_java_is_selected() {
        assertEquals("selected", getJavaTabLi().getAttribute("id"));
    }

    //---   Scenario: Coding Bat Login

    @When("the user clicks each Java problem group and each task")
    public void the_user_clicks_each_task() {
        clickEachProblemAndTask();
    }

    @Then("the user prints each Java task link and webpage title")
    public void the_user_prints_and_validates_each_task() {
        assertTrue(getDriver().getTitle().contains("CodingBat Java"));
    }

    //--   Scenario: Validate and print Java Help links

    @Then("assert Java Help is displayed")
    public void assert_java_help_is_visible() {
        assertTrue(getJavaHelp().isDisplayed());
    }

    @Then("print the Java Help links")
    public void print_the_java_help_links() {
        printHelpLinks(getJavaHelpElementsList());
    }

    //-- Validate and print Python Help links

    @Then("assert Python Help is displayed")
    public void assert_python_help_is_selected() {
        assertTrue(getPythonHelp().isDisplayed());
    }

    @Then("print the Python Help links")
    public void print_the_python_help_links() {
        printHelpLinks(getPythonHelpElementsList());
    }

    //---   Scenario: Print all Java task links and webpage title

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

    //--   Scenario: Print all Python task links and webpage title

    @Given("the user selects the Python tab")
    public void the_user_selects_the_python_tab() {
        getPythonTab().click();
    }

    @Then("assert Python tab is selected")
    public void assert_python_is_selected() {
        assertEquals("selected", getPythonTabLi().getAttribute("id"));
    }

    @When("the user clicks each Python problem group and each task")
    public void the_user_clicks_each_python_problem_group_and_each_task() {
        clickEachProblemAndTask();
    }

    @Then("the user prints each Python task link and webpage title")
    public void the_user_prints_each_python_task_link_and_url_title() {
        assertTrue(getDriver().getTitle().contains("CodingBat Python"));
    }

}
