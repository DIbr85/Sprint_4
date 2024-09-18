import org.example.pom.CreateOrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pom.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class CreateOrderTest {
    private WebDriver driver;
    private final String userFirstName;
    private final String userLastName;
    private final String userAddress;
    private final String userPhoneNumber;
    private final String userDateDelivery;
    private final String comments;

    public CreateOrderTest(String userFirstName, String userLastName, String userAddress, String userPhoneNumber, String userDateDelivery, String comments) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userDateDelivery = userDateDelivery;
        this.comments = comments;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {"Иван", "Иванов", "Москва", "+79999998877", "17.09.2024", "Перевязать красным бантом"},
                {"Ли", "Сю", "Москва", "12345678910", "37.49.3024", ""}
        };
    }

    @Before
    public void setUp() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    @Test
    public void testCreateOrder() {
        CreateOrderPage objCreateOrderPage = new CreateOrderPage(driver);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonCookie();
        objCreateOrderPage.clickOrderButton();
        objCreateOrderPage.createOrder(userFirstName, userLastName, userAddress, userPhoneNumber, userDateDelivery, comments);
        assertTrue(objCreateOrderPage.isVisiblePopupConfirmOrder());
        objCreateOrderPage.clickButtonYes();
        assertTrue(objCreateOrderPage.isVisibleOrderCreated());
    }

    @Test
    public void testCreateOrderWithOtherOrderButton() {
        CreateOrderPage objCreateOrderPage = new CreateOrderPage(driver);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonCookie();
        objCreateOrderPage.clickOtherOrderButton();
        objCreateOrderPage.createOrder(userFirstName, userLastName, userAddress, userPhoneNumber, userDateDelivery, comments);
        assertTrue(objCreateOrderPage.isVisiblePopupConfirmOrder());
        objCreateOrderPage.clickButtonYes();
        assertTrue(objCreateOrderPage.isVisibleOrderCreated());
    }

    @After
    public void teardown() {
        driver.quit();
    }

}