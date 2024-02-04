package com.loop.step_definitions.docuport_stepdefs;

import com.github.javafaker.Faker;
import com.loop.pages.docuport_pages.ClientPage;
import io.cucumber.java.en.*;

import java.util.List;

public class ClientStepDefs {

    ClientPage clientPage = new ClientPage();
    Faker faker = new Faker();
    
    public static List<String> list;
    @When("create a personal client")
    public void create_a_personal_client(List<String>list) {
        ClientStepDefs.list = list;
        //clientPage.createPersonalClient(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));
    }

    @When("create a business client")
    public void create_a_business_client(List<String>list) {
        ClientStepDefs.list = list;
        //clientPage.createBusinessClient(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5));
    }


}
