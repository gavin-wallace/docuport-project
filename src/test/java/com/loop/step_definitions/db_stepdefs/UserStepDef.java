package com.loop.step_definitions.db_stepdefs;

import com.loop.pages.docuport_pages.UsersPage;
import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.DB_Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserStepDef {
    UsersPage usersPage = new UsersPage();

    @And("the user navigates to {string} page")
    public void the_user_navigates_to_page(String moduleName) {
        usersPage.navigateItem(moduleName);
    }

    int expCount;
    @When("the user gets total user count")
    public void the_user_gets_total_user_count() {
        usersPage.searchButton.click();
        usersPage.allRadioButton.click();
        usersPage.updateSearchButton.click();
        BrowserUtilities.justWait(2);
        expCount= usersPage.getResultCount();
    }


    @Then("verify user count information match in DB")
    public void verify_user_count_information_match_in_db() {
        DB_Utility.runQuery("SELECT COUNT(*) from document.users");
        String actualCountStr = DB_Utility.getCellValue(1, 1); // 895
        int actualCount = Integer.parseInt(actualCountStr);
        System.out.println("Expected count: " + expCount);
        System.out.println("Actual count: " + actualCount);
        Assert.assertEquals(expCount, actualCount);
    }
}
