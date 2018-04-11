import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class FileUpload {

    static WebDriver driver;
    @BeforeClass
    public static void SetUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\vitali.brunovski\\downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
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

