package com.loop.step_definitions;

import com.loop.pages.GoogleSearchPage;
import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.security.Key;
import java.util.List;


public class GoogleSearchStepDefs {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
    }

    @When("user types {string} in the google search box and clicks enter")
    public void user_types_in_the_google_search_box_and_clicks_enter(String input) {
        googleSearchPage.searchBox.sendKeys( input );
        googleSearchPage.searchButton.click();
        BrowserUtilities.takeScreenshot();
    }
    @Then("user should see {string} in the google title")
    public void user_should_see_in_the_google_title(String title) {
        BrowserUtilities.validateTitle(title);

    }




    @When("user types Loop Academy in the google search box and clicks enter")
    public void user_types_loop_academy_in_the_google_search_box_and_clicks_enter() {
        googleSearchPage.searchBox.sendKeys( GoogleSearchPage.LOOP_ACADEMY );
        googleSearchPage.searchButton.click();
        BrowserUtilities.takeScreenshot();
    }
    @Then("user should see Loop Academy - Google Search in the google title")
    public void user_should_see_loop_academy_google_search_in_the_google_title() {
        BrowserUtilities.validateTitle("Loop Academy - Google Search");
    }



    @Then("user search the following items in the google search box")
    public void user_search_the_following_items_in_the_google_search_box(List<String> list) {

        list.forEach( (each) ->
        {
            googleSearchPage.searchBox.clear();
            googleSearchPage.searchBox.sendKeys(each + Keys.ENTER);
            Assert.assertEquals("",each +" - Google Search",Driver.getDriver().getTitle());
        });

//        for (String each: list){
//            googleSearchPage.searchBox.clear();
//            googleSearchPage.searchBox.sendKeys(each + Keys.ENTER);
//            Assert.assertEquals("",each +" - Google Search",Driver.getDriver().getTitle());
//        }
    }

    //--- Google Search Outline Feature

    @When("user searches for the {string}")
    public void user_searches_for_the(String country) {
        googleSearchPage.searchBox.sendKeys( "What is the capital city of "+country );
        googleSearchPage.searchButton.click();
        BrowserUtilities.takeScreenshot();
    }
    @Then("the user should see the {string} in the result")
    public void the_user_should_see_the_in_the_result(String capital) {

        Assert.assertEquals(googleSearchPage.capital.getText().toLowerCase(),capital.toLowerCase());
    }

}
