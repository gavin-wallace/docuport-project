package com.loop.step_definitions.docuport_stepdefs;

import com.loop.pages.docuport_pages.UsersPage;
import com.loop.utilities.DB_Utility;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.*;

public class UsersStepDefs {

    UsersPage usersPage = new UsersPage();
    @Then("verify new client is created")
    public void verify_new_client_is_created() throws SQLException {
        usersPage.navigateItem("Users");
        usersPage.assertClientIsPresent(ClientStepDefs.list.get(2),ClientStepDefs.list.get(3));
        Assert.assertTrue(usersPage.getResultCount()>0);


        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("select * from document.users where email_address = '"+ClientStepDefs.list.get(2)+"'");
        rs.next();
        Assert.assertEquals(ClientStepDefs.list.get(0), rs.getString("first_name"));

    }
    @Then("Delete user from the database")
    public void delete_new_user_from_the_database() throws SQLException {

        DB_Utility.createConnection();

        ResultSet rs = DB_Utility.runQuery("select * from document.users where first_name = 'Elton'");

        rs.next();

    }

}
