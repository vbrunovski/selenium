package autoru;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPage {
    static WebDriver driver;
    private final static String URL = "https://auto.ru";
    MainPage mp = new MainPage(driver);

    @BeforeClass
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ismyf\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    //wait while page is loaded
    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();
        mp.acceptCookie();
        Thread.sleep(5000);

        waitForLoad(driver);
        Thread.sleep(5000);
        mp.chooseMoscowRegion();

    }

    public void test2(){
        System.out.println("THIS IS TEST2");
    }
}
