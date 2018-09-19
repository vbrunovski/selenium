package test;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.MalformedURLException;

public class TakeScreenshot {

    private static WebDriver driver;

    @BeforeClass
    public static void SetUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\vitali.brunovski\\downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void takeScreenshot(){

        driver.get("http://www.google.com/");
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:/Downloads/image.png"));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
