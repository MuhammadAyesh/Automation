package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageElements.Click;
import pageElements.Element;
import pageElements.NavigateTo;
import pageElements.Text;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by mayesh on 6/19/17.
 */
public class Commands implements Closeable {

    public static String NAME = "name";
    public static String ID = "id";
    public static String XPATH = "Xpath";
    public static String LINK_TEXT = "LinkText";
    public static String URL = "url";

    private WebDriver driver;
    private FileManager fileManager;
    private int stepNumber;

    public Commands(WebDriver driver) throws FileNotFoundException {
        this.driver = driver;
        fileManager = new FileManager();
        fileManager.createTable("Number", "StepName", "Result");
    }

    public void navigateTo(String navigateBy, String string, String verify) throws InterruptedException {

        if (navigateBy.equalsIgnoreCase(LINK_TEXT)) {
            WebElement navigate = driver.findElement(By.linkText(string));
            navigate.click();
        } else if (navigateBy.equalsIgnoreCase(XPATH)) {
            WebElement regElem = driver.findElement(By.xpath(string));
            regElem.click();
        } else if (navigateBy.equalsIgnoreCase(URL)) {
            driver.get(string);
        }

            verify(verify, "navigateTo\t" + string);
    }

    public void submitText(String submitBy, String by, String string, String verify) throws InterruptedException {

        if (submitBy.equalsIgnoreCase(NAME)) {
            WebElement webElement = driver.findElement(By.name(by));
            if (checkText(webElement,string))
                webElement.sendKeys(string);

        } else if (submitBy.equalsIgnoreCase(ID)) {
            WebElement webElement = driver.findElement(By.id(by));
            if (checkText(webElement,string))
                webElement.sendKeys(string);

        } else if (submitBy.equalsIgnoreCase(XPATH)) {
            WebElement webElement = driver.findElement(By.xpath(by));
            if (checkText(webElement,string))
                webElement.sendKeys(string);
        }

            verify(verify, "submitText\t" + string);
    }

    private boolean checkText(WebElement element,String text) {
        if (text.equalsIgnoreCase("enter")) {
            element.sendKeys(Keys.ENTER);
            return false;
        } else {
            return true;
        }
    }

    public void click(String stringType, String string, String verify) {

        if (stringType.equalsIgnoreCase(NAME)) {
            driver.findElement(By.name(string)).click();

        } else if (stringType.equalsIgnoreCase(ID)) {
            driver.findElement(By.id(string)).click();
        }

            verify(verify,"click\t"+string);
    }


    public boolean isPageContains(String string) {
        if (string != null)
            return driver.getPageSource().contains(string);
        else return false;
    }


    public String getText(String stringType, String string) {

        if (stringType.equalsIgnoreCase(XPATH)) {
            String text = driver.findElement(By.xpath(string)).getText();
            return text;

        } else if (stringType.equalsIgnoreCase(NAME)) {
            String text = driver.findElement(By.name(string)).getText();
            return text;

        } else if (stringType.equalsIgnoreCase(ID)) {
            String text = driver.findElement(By.id(string)).getText();
            return text;
        }

        return string;
    }


    public void verify(String message, String stepName) {
//        Assert.assertTrue(isPageContains(message), message + "\t\tSuccess");

        if (isPageContains(message) && message != null) {
            fileManager.addRowsToTable(String.valueOf(++stepNumber), stepName, "<span style=\"color: green; \">Success</span>");
        } else if (message != null) {
            fileManager.addRowsToTable(String.valueOf(++stepNumber), stepName, "<span style=\"color: red; \">Failed</span>");
        } else {
            fileManager.addRowsToTable(String.valueOf(++stepNumber), stepName, "Not-checked");
        }
    }


    public void selectFromDropDownList(String choice, String name, WebDriver driver) {
        Select oSelect = new Select(driver.findElement(By.name(name)));
        oSelect.selectByVisibleText(choice);
    }


    public void handleContent(Element content) throws InterruptedException {
        if (content instanceof NavigateTo) {
            navigateTo(content.getStringType(), content.getString(), content.getVerificationMessage());
        } else if (content instanceof Text) {
            submitText(content.getStringType(), content.getString(), ((Text) content).getText(), content.getVerificationMessage());
        } else if (content instanceof Click) {
            click(content.getStringType(), content.getString(), content.getVerificationMessage());
        }
    }

    @Override
    public void close() throws IOException {
        driver.quit();
        fileManager.closeTable();
        fileManager.close();
    }
}
