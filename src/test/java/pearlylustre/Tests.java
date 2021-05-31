package pearlylustre;

import bigbank.JUnitHTMLReporter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests extends JUnitHTMLReporter {
    static WebDriver driver;
    private final static String URL = "https://pearlylustre.com/";
    BuyBracelets bb = new BuyBracelets(driver);


    @BeforeClass
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\ismyf\\\\\\OneDrive\\\\Desktop\\\\chromedriver_win32\\\\chromedriver.exe");

        driver = new ChromeDriver();
    }

    @Test
    public void addItemToCartAndCheckOut() throws InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();
        bb.clickBracelets();
        Thread.sleep(3000);
        bb.clickAddToCart();
        Thread.sleep(3000);
        bb.clickViewCart();
        Thread.sleep(4000);
        bb.clickCheckOut();
        Thread.sleep(4000);
        bb.fillInTheForm();
    }

}
