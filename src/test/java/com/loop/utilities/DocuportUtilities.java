package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.InputMismatchException;

public class DocuportUtilities {
    /**
     * Logs into docuport application
     * @param driver
     * @param loginRole
     */
    public static void login(WebDriver driver, String loginRole) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));

        switch (loginRole.toLowerCase()) {
            case "client":
                username.sendKeys(DocuportConstants.USERNAME_ClIENT);
                password.sendKeys(DocuportConstants.getPassword());
                break;
            case "supervisor":
                username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                password.sendKeys(DocuportConstants.getPassword());
                break;
            case "advisor":
                username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstants.getPassword());
                break;
            case "employee":
                username.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                password.sendKeys(DocuportConstants.getPassword());
                break;
            default:
                throw new InputMismatchException("Role not found");

        }
        loginButton.click();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(loginRole.toLowerCase().equals("client")){
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Driver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        }
    }

    /**
     * log out from docuport application
     * @param driver
     */
    public static void logout (WebDriver driver){
        WebElement userButton = Driver.getDriver().findElement(By.xpath("//*[.='Batch1 Group1']"));
        userButton.click();
        WebElement logoutButton = Driver.getDriver().findElement(By.xpath("//span[.='Log out']"));
        logoutButton.click();
    }
}
