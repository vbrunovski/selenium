package test;

import beauty.Page;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class GetCssValue extends Page {

    @Override
    protected WebDriver getDriver() {
        return driver;
    }

    static WebDriver driver;
    @BeforeClass
    public static void SetUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\vitali.brunovski\\downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
    }

    @Test
    public void getCssValueRGB(){
        driver.get("http://petromaks.ee");
        WebElement el = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div"));
        String color = el.getCssValue("color").toString();
        assertEquals("#b0b9c2", color);
        System.out.print("Color is: " + color);
    }

    @Test
    public void getCssValueHEX(){
        driver.get("http://petromaks.ee");
        String color = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div")).getCssValue("color");
        System.out.println(color);
        String hex = Color.fromString(color).asHex();
        System.out.println(hex);
    }

}
