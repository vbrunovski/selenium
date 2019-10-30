package dreamwork;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DreamworkTest {
    static WebDriver driver;
    private final static String URL = "https://dreamwork.ee";
    IndexPage ip = new IndexPage(driver);

    @BeforeClass
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ismyf\\Desktop\\chromedriver_win32\\chromedriver.exe"); //C:\Users\ismyf\Desktop
        System.setProperty("webdriver.gecko.driver","C:\\Users\\User\\Downloads\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
    }


    @Test
    public void test() throws InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        ip.MoreButton();
        ip.verifySearchIsWorking("mongodb");
        Thread.sleep(2000);
        ip.verifyThatBlogPostExists();
        Thread.sleep(2000);
        ip.countMenuItems();
    }

}
