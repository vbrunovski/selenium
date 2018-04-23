package test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new HtmlUnitDriver();
    }

    @Test
    public void test(){
        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("Selenium");

        element.submit();

        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
    }



}

