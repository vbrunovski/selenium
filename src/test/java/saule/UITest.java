package saule;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UITest {
    static WebDriver driver;
    private final static String URL = "https://saweb.dev.sauledev.com/en/";
    UIPageLogin ui = new UIPageLogin(driver);

    @BeforeClass
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ismyf\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test(){
        driver.get(URL);
        driver.manage().window().maximize();
        ui.clickLogInBtn();
    }
}
