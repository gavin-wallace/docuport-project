package com.loop.step_definitions.db_stepdefs;

import com.loop.pages.docuport_pages.HomePage;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HomePageStepDefs {

    HomePage homePage= new HomePage();

    @Then("validate Received Documents and My Uploads appears on the home page for all {string}")
    public void validate_received_documents_and_my_uploads_appears_on_the_home_page_for_all(String userType) {
        homePage.loginDocuport(userType);
        Assert.assertTrue(homePage.receivedDocumentsLink.isDisplayed() && homePage.myUploadsLink.isDisplayed());
    }

    @Then("login to each userType and validate the service shown on the home page")
    public void login_to_each_user_type_and_validate_the_service_shown_on_the_home_page(Map<String, List<String>> expectedServicesMap) {
        expectedServicesMap.forEach((userType,expectedList)->{
            homePage.loginDocuport(userType);
            expectedList.removeIf(Objects::isNull);
            List<String> actualList = new ArrayList<>();

            Driver.getDriver().findElements(By.xpath("//div[@class='px-4']/div/div/a//span")).forEach( each->{
                actualList.add(each.getText());
            });

            Assert.assertEquals(actualList,expectedList);
            homePage.logout();
        });
    }
}
