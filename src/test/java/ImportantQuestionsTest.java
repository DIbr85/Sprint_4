import org.example.pom.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import java.util.List;


@RunWith(Parameterized.class)
public class ImportantQuestionsTest {
    private WebDriver driver;
    private final String neededText;

    public ImportantQuestionsTest(String neededText) {
        this.neededText = neededText;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области."},
                {"Ох уж эти ассёрты..."}
        };
    }


    @Before
    public void setUp() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    @Test
    public void testImportantQuestions() {
        MainPage objListQuestions = new MainPage(driver);
        objListQuestions.clickButtonCookie();
        List<String> arrayTest = objListQuestions.listOfQuestions();
        Assert.assertTrue(Boolean.parseBoolean(String.valueOf(arrayTest.contains(neededText))));
    }


    @After
    public void teardown() {
        driver.quit();
    }
}