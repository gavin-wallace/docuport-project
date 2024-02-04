package com.loop.runner;

import com.loop.pages.docuport_pages.BasePage;
import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.Driver;
import io.cucumber.java.sl.In;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-report/cucumber-reports.html",
                "json:target/json-reports/json-report.json"},
        features = "src/test/resources/features",
        glue = "com/loop/step_definitions",
        dryRun = false,
        tags = "",
        monochrome = true
        //publish = true
)

public class CukesRunner {

    public static void main(String[] args) {
        new BasePage().loginDocuport("client");
        new BasePage().userIcon.click();

    }

}

