package com.mars_crater.carris.interaction.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Selenium running example.
 */
public class Selenium2Example {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("Cheese!");

        element.submit();

        System.out.println("Page Title is: " + driver.getTitle());

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Object>() {
            public Boolean apply(WebDriver webDriver) {
                return webDriver.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        System.out.println("Page Title is: " + driver.getTitle());
        driver.quit();

        //Same thing but with the chrome driver

        driver = new ChromeDriver();

        driver.get("http://www.google.com");

        element = driver.findElement(By.name("q"));

        element.sendKeys("Cheese!");

        element.submit();

        System.out.println("Page Title is: " + driver.getTitle());

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Object>() {
            public Boolean apply(WebDriver webDriver) {
                return webDriver.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        System.out.println("Page Title is: " + driver.getTitle());
        driver.quit();
    }
}
