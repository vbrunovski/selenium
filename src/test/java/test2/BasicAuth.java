package test2;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;

public class BasicAuth {

    private static WebDriver driver;
    private String URL = "http://admin:admin@the-internet.herokuapp.com/basic_auth/";

    @BeforeClass
    public static void SetUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Downloads\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void Auth() throws InterruptedException {
        driver.get(URL);
    }
}
