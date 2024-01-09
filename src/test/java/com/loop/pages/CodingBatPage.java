package com.loop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.loop.utilities.BrowserUtilities.waitForClickable;
import static com.loop.utilities.Driver.getDriver;

public class CodingBatPage {

    public CodingBatPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='tabin']//td//a")
    private static List<WebElement> ProblemList;
    @FindBy(xpath = "//div[@class='tabin']//td//a")
    private static List<WebElement> listOfTasks;
    @FindBy(xpath = "(//h3[.='Java Help']/..//following-sibling::ul)[1]//a")
    private static List<WebElement> javaHelpElementsList;
    @FindBy(xpath = "//h3[.='Python Help']/..//following-sibling::ul//a")
    private static List<WebElement> pythonHelpElementsList;

    @FindBy(xpath = "//input[@name='uname']")
    private static WebElement idOrEmail;
    @FindBy(xpath = "//input[@name='pw']")
    private static WebElement password;
    @FindBy(xpath = "//input[@name='dologin']")
    private static WebElement login;
    @FindBy(xpath = "//a[.='log out']")
    private static WebElement logout;
    @FindBy(xpath = "//a[.='Java']/..")
    private static WebElement javaTabLi;
    @FindBy(xpath = "//a[.='Python']/..")
    private static WebElement pythonTabLi;
    @FindBy(xpath = "//a[.='Python']")
    private static WebElement pythonTab;
    @FindBy(xpath = "//h3[.='Java Help']")
    private static WebElement javaHelp;
    @FindBy(xpath = "//h3[.='Python Help']")
    private static WebElement pythonHelp;


    public static WebElement getIdOrEmail() {
        return idOrEmail;
    }

    public static WebElement getPassword() {
        return password;
    }

    public static WebElement getLogin() {
        return login;
    }

    public static WebElement getLogout() {
        return logout;
    }

    public static WebElement getJavaTabLi() {
        return javaTabLi;
    }

    public static WebElement getPythonTabLi() {
        return pythonTabLi;
    }

    public static WebElement getPythonTab() {
        return pythonTab;
    }

    public static WebElement getJavaHelp() {
        return javaHelp;
    }

    public static WebElement getPythonHelp() {
        return pythonHelp;
    }

    public static List<WebElement> getJavaHelpElementsList() {
        return javaHelpElementsList;
    }

    public static List<WebElement> getPythonHelpElementsList() {
        return pythonHelpElementsList;
    }

    //    @FindBy(xpath = "//button[.='Show Solution']")
    //    private static WebElement solutionButton;
    //    @FindBy(tagName = "pre")
    //    private static WebElement solutionText;
    public static void clickEachProblemAndTask() {
        List<String> stringLinks = new ArrayList<>();
        Map<String, String> resultMap = new LinkedHashMap<>();
        listOfTasks.forEach(each -> {
            stringLinks.add(each.getAttribute("href"));
        });
        stringLinks.forEach(eachLink -> {
            getDriver().get(eachLink);
            listOfTasks.forEach((eachTask) -> {
                waitForClickable(eachTask, 1).click();
                resultMap.put(getDriver().getCurrentUrl() + " ", " " + getDriver().getTitle() + "\n"); //"\n" + solutionText.getText());
                getDriver().navigate().back();
            });
            System.out.println("Tasks found at: " + eachLink + "\n" + resultMap.toString().replace("{", "").replace("}", "").replace(", ", "") + "\n");
            resultMap.clear();
        });
    }

    public static void printHelpLinks(List<WebElement> list) {
        System.out.println((getDriver().getTitle().contains("Java")) ? ("Java Help Links: ") : ("Python Help Link: "));
        list.forEach(eachElement -> {
            System.out.println(eachElement.getAttribute("href"));
        });
    }
}
