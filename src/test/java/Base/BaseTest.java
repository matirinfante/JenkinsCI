package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected static WebDriver driver;
    protected static SoftAssert softAssert;

    @BeforeSuite()
    @Parameters({"browser"})
    public void setup(String browser) {
        switch (browser) {
            case "chrome":
                System.out.println("Running Chrome browser...");
                driver = WebDriverManager.chromedriver().create();
                break;
            case "edge":
                System.out.println("Running Edge browser...");
                driver = WebDriverManager.edgedriver().create();
                break;
            case "firefox":
                System.out.println("Running Firefox browser...");
                driver = WebDriverManager.firefoxdriver().create();
                break;
            default:
                System.out.println("Running default browser...");
                driver = WebDriverManager.chromedriver().create();
                break;
        }
        softAssert = new SoftAssert();
    }

    @BeforeTest
    public void profileSetup() {
        driver.manage().window().maximize();
        System.out.println("The profile setup process is completed");

    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }

}
