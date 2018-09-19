package test2;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.net.MalformedURLException;

public class ContextMenu {
    private static WebDriver driver;

    @BeforeClass
    public static void SetUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Downloads\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void ContextMenu(){
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a")).click();

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"hot-spot\"]"));
        Actions action = new Actions(driver).contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
        action.build().perform();
    }
}
