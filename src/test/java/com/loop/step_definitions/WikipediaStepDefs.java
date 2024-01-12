package com.loop.step_definitions;

import com.loop.pages.WikipediaPage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.loop.utilities.BrowserUtilities.*;
import static org.junit.Assert.assertTrue;

public class WikipediaStepDefs {
    WikipediaPage wikipediaPage = new WikipediaPage();

    @Given("the user is on the Wikipedia home page")
    public void the_user_is_on_the_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wikipedia.url"));
    }

    @Then("the user searches the following items and validates the text in the {string}")
    public void the_user_searches_the_following_items_and_validates_the_text_in_the(String string, List<String> list) {
        list.forEach(each ->
        {
            wikipediaPage.searchBox.clear();
            wikipediaPage.searchBox.sendKeys(each + Keys.ENTER);

            switch (string) {
                case "page title":
                    validateTitle(each);
                    break;
                case "main header":
                    assertTrue(wikipediaPage.mainHeaderText.getText().contains(each));
                    break;
                case "image header":
                    assertTrue(wikipediaPage.imageHeaderText.getText().contains(each));
                    break;
            }
            takeScreenshot();
            Driver.getDriver().navigate().back();
        });
    }
}



