package com.example;

import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FirstTest {

    ChromeOptions chromeOptions = new ChromeOptions();
    WebDriver driver = null;

    @BeforeTest
    public void beforeTest() throws Exception {

        driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);

    }

    @Test
    public void testcase_1() throws InterruptedException {
        driver.get("http://jqueryui.com/droppable/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Droppable | jQuery UI";
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test
    public void testcase_2() throws InterruptedException {
        // write Your Code here to Login

        driver.switchTo().frame(0);
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.id("draggable")), droppable).perform();
        String actualText = droppable.getText();
        String expectedText = "Dropped!";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void testcase_3() throws InterruptedException {
        // write Your Code here to Login
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.id("draggable")), droppable).perform();
        String actualColor = droppable.getCssValue("background");
        String color = actualColor.substring(0, actualColor.indexOf(')') + 1);
        System.out.println(color);
        String expectedColor = "rgb(255, 250, 144)";
        Assert.assertEquals(color, expectedColor);

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
