package com.mars_crater.carris.interaction.services;

import com.google.common.base.Function;
import com.mars_crater.carris.interaction.utils.LoggerWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Carris mobile site request (m.carris.pt).
 */
public class MobileSiteRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MobileSiteRequest.class);


    final String EMAIL = "paxzeno@gmail.com";
    final String STREET_NAME = "Francisco Marques Beato";
    //final String STREET_NAME = "Av. Berlim";

    private FluentWait wait;

    public MobileSiteRequest() {
    }

    public void execute() {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://m.carris.pt");

        try {
            LoggerWrapper.debug(LOGGER, "Started site", driver);

            String textInElement = "Tempo de Espera";
            this.waiting(driver, By.partialLinkText(textInElement));
            LoggerWrapper.lookingForElementDebug(LOGGER, textInElement, driver);
            WebElement element = driver.findElement(By.partialLinkText(textInElement));
            element.click();

            textInElement = "local";
            this.waiting(driver, By.name(textInElement));
            LoggerWrapper.lookingForElementDebug(LOGGER, textInElement, driver);
            element = driver.findElement(By.name(textInElement));
            element.sendKeys(STREET_NAME);
            element.submit();

            this.waiting(driver, By.partialLinkText(STREET_NAME));
            LoggerWrapper.lookingForElementDebug(LOGGER, STREET_NAME, driver);
            element = driver.findElement(By.partialLinkText(STREET_NAME));
            element.click();

            textInElement = "paginacao-left";
            this.waiting(driver, By.className(textInElement));
            LoggerWrapper.lookingForElementDebug(LOGGER, textInElement, driver);
            WebElement queryResult = driver.findElement(By.className(textInElement));
            LoggerWrapper.debug(LOGGER, "Location results: {}", driver, queryResult.getText());

            textInElement = "Consultar tempos de espera";
            LoggerWrapper.lookingForElementDebug(LOGGER, textInElement, driver);
            element = driver.findElement(By.partialLinkText(textInElement));
            element.click();

            textInElement = "email";
            this.waiting(driver, By.name(textInElement));
            element = driver.findElement(By.name(textInElement));
            LoggerWrapper.debug(LOGGER, "Inserting email info", driver);
            element.sendKeys(EMAIL);
            element.submit();

            LoggerWrapper.debug(LOGGER, "An email should be arriving shortly ", driver);

        } catch (NoSuchElementException e) {
            LOGGER.error("Element not found! " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    /**
     * Wait for some event or element to appear or load.
     *
     * @param driver driver executing.
     * @param expectancy By event expected to happen, or element to load.
     */
    private void waiting(WebDriver driver, final By expectancy) {
        LoggerWrapper.debug(LOGGER, "Waiting " + expectancy.toString(), driver);
        if (this.wait == null) {
            this.wait = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
        }
        this.wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(expectancy);
            }
        });
    }


    public static void main(String[] args) {
        MobileSiteRequest mobileSiteRequest = new MobileSiteRequest();
        mobileSiteRequest.execute();

    }
}
