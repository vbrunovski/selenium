package tinkoffBank;

import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TinkoffTest {
    static WebDriver driver;
    private final static String URL = "http://tinkoff.ru";
    IndexPage ip = new IndexPage(driver);
    PlatezhiPage pp = new PlatezhiPage(driver);
    ZkhPage zp = new ZkhPage(driver);
    ZkuMoskva zm = new ZkuMoskva(driver);

    @BeforeClass
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\User\\Downloads\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://tinkoff.ru");
        driver.manage().window().maximize();
        ip.clickPlatezhi();
        Thread.sleep(1400);
        pp.clickZkh();
        Thread.sleep(1000);
        zp.verifyCity("Москве");
        Thread.sleep(1000);
        zp.clickZkuMoskva();
        Thread.sleep(2000);
        zm.clickOplatitZkuVMoskve();
        Thread.sleep(1000);
        zm.validationCheck();
        Thread.sleep(1000);
        zm.clickPlatezhi();
        Thread.sleep(1000);
        pp.searchInput();
        Thread.sleep(1000);
        pp.verifyElementIsFirst();
        Thread.sleep(1000);
        pp.clickZkuMoskvaDropDown();
        Thread.sleep(1000);
        zm.clickPlatezhi();
        Thread.sleep(1000);
        pp.clickZkh();
        Thread.sleep(1000);
        zp.selectAnotherCity();
        Thread.sleep(1000);
        zp.verifyZkhIsNotExists();

    }
}
