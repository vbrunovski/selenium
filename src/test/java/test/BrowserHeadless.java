package test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;

import java.net.MalformedURLException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BrowserHeadless {
    private static WebDriver driver;


    @BeforeClass
    public static void SetUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\vitali.brunovski\\downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        //driver = new ChromeDriver();
    }

    @Test
    public void Headless(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("window-size=1200x600");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://google.com");
        WebElement el = driver.findElement(By.name("q"));
        el.sendKeys("Selenium Java");
        //press enter button
        el.sendKeys(Keys.ENTER);

        List<WebElement> listEl = driver.findElements(By.xpath("//div[@class='g']//h3/a"));

        for(WebElement a: listEl)
            System.out.println(a.getAttribute("textContent"));
    }
}
