package SeleniumForBeginners;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.MalformedURLException;

public class Lesson4 {
    static WebDriver driver;
    @BeforeClass
    public static void preTest() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void takeScreenshot(){

        driver.get("http://www.google.com/");
        try {
            Thread.sleep(1000);
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:/image.png"));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
