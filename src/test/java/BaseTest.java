import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;

public class BaseTest extends ExternalResource {

    private WebDriver driver;

    protected void before() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
    }

    protected void after() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}