package com.loop.runner;

import com.loop.utilities.Driver;
import io.cucumber.java.sl.In;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-report/cucumber-reports.html",
                    "json:target/json-reports/json-report.json"},
        features = "src/test/resources/features",
        glue = "com/loop/step_definitions",
        dryRun = false,
        tags = "@B2G1-226",
        monochrome = true
        //publish = true
)

public class CukesRunner {

}

