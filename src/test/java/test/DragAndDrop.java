package test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.codeborne.selenide.WebDriverRunner;
import org.hamcrest.CoreMatchers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;



public class DragAndDrop {
    static WebDriver driver;
    static String password = "xxx";

    static WebDriver driver2;

    @BeforeClass
    public static void SetUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\vitali.brunovski\\downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
    }

    @Test
    public void DragAndDrop() throws InterruptedException{
        Thread.sleep(4000);
        driver.get("https://onedrive.live.com/?id=root&cid=55D04DEA4012F4DE");
        Thread.sleep(5000);
        WebElement el = driver.findElement(By.cssSelector(".o365cs-mfp-textboy.o365cs-mfp-circular-small"));
        el.click();
        WebElement el2 = driver.findElement(By.id("_ariaId_7"));
        el2.click();
        WebElement el3 = driver.findElement(By.id("i0116"));
        el3.sendKeys("mrmourax@gmail.com");
        WebElement el4 = driver.findElement(By.id("idSIButton9"));
        el4.click();
        Thread.sleep(5000);
        WebElement el5 = driver.findElement(By.id("i0118"));
        el5.sendKeys(password);
        WebElement el6 = driver.findElement(By.id("idSIButton9"));
        el6.submit();
        Thread.sleep(5000);
        //Drag and Drop
        WebElement element = driver.findElement(By.cssSelector("span.od-ImageTile-background"));
        WebElement target = driver.findElement(By.cssSelector(".link_a5921354"));
        //element.click();



        Actions builder = new Actions(driver);


        //builder.clickAndHold(element).build().perform();
        //Thread.sleep(3000);
        //builder.moveToElement(target).build().perform();
        //Thread.sleep(2000);
        //builder.release().build().perform();

        //builder.clickAndHold(element).moveToElement(target).release().build().perform();
        //(new Actions(driver)).dragAndDrop(element, target).build().perform();



    }

    @Test
    public void DnD() throws InterruptedException{
        driver.get("https://html5demos.com/drag/");
        WebElement element = driver.findElement(By.id("one"));
        WebElement target = driver.findElement(By.id("bin"));
        //(new Actions(driver)).dragAndDrop(element, target).perform();

        /*
        Actions builder = new Actions(driver);
        builder.clickAndHold(element).build().perform();
        Thread.sleep(1000);
        builder.moveToElement(target).build().perform();
        Thread.sleep(1000);
        builder.release().build().perform();
        */

        /*
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL)
                .click(element)
                .click(target)
                .keyUp(Keys.CONTROL);

        Action selectMultiple = builder.build();
        selectMultiple.perform();


    */
    }
}
