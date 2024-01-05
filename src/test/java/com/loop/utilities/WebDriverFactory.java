package com.loop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.chromedriver().setup();
            return new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("safari")) {
            return WebDriverManager.safaridriver().create();
        } else {
            System.out.println("Driver not found");
            System.out.println("Drive value null");
            return null;
        }
        //parent POM XML

        /*
        Selenium - Windows & Web Tables
        DataBase - CI/CD & Jenkins via AWS virtual machine

        recap interviews - I am having mock interviews with other class mates

        Im bumed I just noticed I missed the flipgrid this week, so my goal in the next week is to complete everyhting and
         */
    }
}
