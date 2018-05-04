package test;

import common.GenericTest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import static org.junit.Assert.assertEquals;

public class GetCssValue implements GenericTest {

    static WebDriver driver;
    @BeforeClass
    public static void SetUp() {
        driver = GenericTest.getDriver();
    }

    @Test
    public void getCssValueRGB(){
        driver.get("http://petromaks.ee");
        WebElement el = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div"));
        String color = el.getCssValue("color");
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
