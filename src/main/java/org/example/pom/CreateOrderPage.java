package org.example.pom;

import org.example.Data.RandomData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.time.Duration;


public class CreateOrderPage {
    private final WebDriver driver;
    private final By orderButton = By.className("Button_Button__ra12g");
    private final By otherOrderButton = By.cssSelector(".Home_FinishButton__1_cWm");
    private final By firstName = By.xpath(".//input[@placeholder='* Имя']");
    private final By lastName = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By phoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By chooseMetroStation = By.xpath(".//*[@class='select-search__row']" + "[" + RandomData.getNameOfMetroStation() + "]");
    private final By buttonNext = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private final By dateDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentPlaceholder = By.className("Dropdown-placeholder");
    private final By chooseLimitRent = By.xpath("//*[@class='Dropdown-option']" + "[" + RandomData.getNumberOfLimitDayRent() + "]");
    private final By checkBoxColor = By.xpath("//*[@class='Checkbox_Label__3wxSf']" + "[" + RandomData.getColorOfScooter() + "]");
    private final By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By buttonConfirmOrder = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    private final By popupConfirmOrder = By.className("Order_ModalHeader__3FDaJ");
    private final By buttonYes = By.xpath(".//button[text()='Да']");
    private final By popupOrderCreated = By.cssSelector(".Order_Modal__YZ-d3");

    public CreateOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickOtherOrderButton() {
        driver.findElement(otherOrderButton).click();
    }

    public void setFirstName(String userFirstName) {
        driver.findElement(firstName).sendKeys(userFirstName);
    }

    public void setLastName(String userLastName) {
        driver.findElement(lastName).sendKeys(userLastName);
    }

    public void setAddress(String userAddress) {
        driver.findElement(address).sendKeys(userAddress);
    }

    public void clickChooseMetroStation() {
        driver.findElement(metroStation).click();
        driver.findElement(chooseMetroStation).click();
    }

    public void setPhoneNumber(String userPhoneNumber) {
        driver.findElement(phoneNumber).sendKeys(userPhoneNumber);
    }

    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    public void waitElementInNextPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(dateDelivery));
    }

    public void setDateDelivery(String userDateDelivery) {
        driver.findElement(dateDelivery).sendKeys(userDateDelivery);
        driver.findElement(dateDelivery).sendKeys(Keys.ENTER);
    }

    public void clickRentPlaceholder() {
        driver.findElement(rentPlaceholder).click();
    }

    public void chooseNumberOfLimitDayRent() {
        driver.findElement(chooseLimitRent).click();
    }

    public void chooseColorOfScooter() {
        driver.findElement(checkBoxColor).click();
    }

    public void commentForCourier(String comments) {
        driver.findElement(commentForCourier).sendKeys(comments);
    }

    public void clickConfirmOrder() {
        driver.findElement(buttonConfirmOrder).click();
    }

    public boolean isVisiblePopupConfirmOrder() {
        return driver.findElement(popupConfirmOrder).isDisplayed();
    }

    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

    public boolean isVisibleOrderCreated() {
        return driver.findElement(popupOrderCreated).isDisplayed();
    }

    public void createOrder(String userFirstName, String userLastName, String userAddress, String userPhoneNumber, String userDateDelivery, String comments) {
        setFirstName(userFirstName);
        setLastName(userLastName);
        setAddress(userAddress);
        clickChooseMetroStation();
        setPhoneNumber(userPhoneNumber);
        clickButtonNext();
        waitElementInNextPage();
        setDateDelivery(userDateDelivery);
        clickRentPlaceholder();
        chooseNumberOfLimitDayRent();
        chooseColorOfScooter();
        commentForCourier(comments);
        clickConfirmOrder();
    }

}