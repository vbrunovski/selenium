package SeleniumForBeginners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.seleniumemulation.KeyEvent;

import java.awt.*;
import java.net.MalformedURLException;
import java.util.List;

import static org.junit.Assert.fail;

public class Lesson1 {
    static WebDriver driver;
    static String url = "http://google.com";

    @BeforeClass
    public static void preTest() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterClass
    public static void afterTest() {
        //driver.quit();
    }
    @Test
    public void test1() throws InterruptedException, AWTException {
        driver.get(url);
        driver.manage().window().maximize();
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
        searchInput.sendKeys("how to learn HTML");
        Thread.sleep(2000);

        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
        Thread.sleep(2000);
    }
}
