import org.example.pom.MainPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;


@RunWith(Parameterized.class)
public class ImportantQuestionsTest {
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

    @Rule
    public BaseTest browserRule = new BaseTest();

    @Test
    public void testImportantQuestions() {
        MainPage objListQuestions = new MainPage(browserRule.getDriver());
        objListQuestions.open();
        objListQuestions.clickButtonCookie();
        List<String> arrayTest = objListQuestions.listOfQuestions();
        Assert.assertTrue(Boolean.parseBoolean(String.valueOf(arrayTest.contains(neededText))));
    }

}