package org.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final By buttonCookie = By.className("App_CookieButton__3cvqF");
    private final By listQuestions = By.className("accordion__button");
    private final By listResponse = By.xpath(".//*[@class='accordion__panel']/p");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonCookie() {
        driver.findElement(buttonCookie).click();
    }

    public List<String> listOfQuestions() {
        List<WebElement> buttonsQuestions = driver.findElements(listQuestions);
        List<WebElement> responsesText = driver.findElements(listResponse);
        List<String> response = new ArrayList<>();
        for (WebElement button : buttonsQuestions) {
            button.click();
            for (WebElement textResponse : responsesText) {
                new WebDriverWait(driver, Duration.ofSeconds(1))
                        .until(ExpectedConditions.presenceOfElementLocated(listResponse));
                String currentTextResponse = textResponse.getText();
                if (!currentTextResponse.isEmpty()) {
                    response.add(currentTextResponse);
                }
            }
        }
        return response;
    }

}