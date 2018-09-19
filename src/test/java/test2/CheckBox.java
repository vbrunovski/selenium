package test2;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;

public class CheckBox {

    private static WebDriver driver;

    @BeforeClass
    public static void SetUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Downloads\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void CheckBox(){
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[5]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click(); //check first checkbox
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click(); //uncheck first checkbox
    }
}
