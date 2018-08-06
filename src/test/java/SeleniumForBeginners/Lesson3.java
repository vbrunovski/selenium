package SeleniumForBeginners;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class Lesson3 {
    static WebDriver driver;
    @BeforeClass
    public static void preTest() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void Upload() throws URISyntaxException, InterruptedException {
        driver.get("https://html.com/input-type-file/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        File file = new File(getClass().getClassLoader().getResource("test.jpg").toURI());
        System.out.println(file.getAbsoluteFile());

        Thread.sleep(5000);
        WebElement fileEl = driver.findElement(By.id("fileupload"));
        //fileEl.click();
        fileEl.sendKeys(file.getAbsolutePath());
        Thread.sleep(5000);
    }
}
