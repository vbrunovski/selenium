package SeleniumForBeginners;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import static org.junit.Assert.assertEquals;

public class Lesson2 {
    static WebDriver driver;
    @BeforeClass
    public static void preTest() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
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
