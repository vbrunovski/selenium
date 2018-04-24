package testovoeZadanie;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YandexTest {
    static WebDriver driver;
    private final static String URL = "http://yandex.ru";
    YandexPage yp = new YandexPage(driver);
    MarketPage mp = new MarketPage(driver);

    @BeforeClass
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testYandexMarket() throws InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();
        yp.clickToMarket();
        mp.clickToMobileSection();
        mp.clickToPriceRange();
    }
}
