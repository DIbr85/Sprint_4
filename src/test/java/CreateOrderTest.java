import org.example.pom.CreateOrderPage;
import org.example.pom.MainPage;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class CreateOrderTest {

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
    @Rule
    public BaseTest browserRule = new BaseTest();

    @Test
    public void testCreateOrder() {
        CreateOrderPage objCreateOrderPage = new CreateOrderPage(browserRule.getDriver());
        MainPage objMainPage = new MainPage(browserRule.getDriver());
        objMainPage.open();
        objMainPage.clickButtonCookie();
        objCreateOrderPage.clickOrderButton();
        objCreateOrderPage.createOrder(userFirstName, userLastName, userAddress, userPhoneNumber, userDateDelivery, comments);
        assertTrue(objCreateOrderPage.isVisibleOrderCreated());
    }

    @Test
    public void testCreateOrderWithOtherOrderButton() {
        CreateOrderPage objCreateOrderPage = new CreateOrderPage(browserRule.getDriver());
        MainPage objMainPage = new MainPage(browserRule.getDriver());
        objMainPage.open();
        objMainPage.clickButtonCookie();
        objCreateOrderPage.clickOtherOrderButton();
        objCreateOrderPage.createOrder(userFirstName, userLastName, userAddress, userPhoneNumber, userDateDelivery, comments);
        assertTrue(objCreateOrderPage.isVisibleOrderCreated());
    }

}