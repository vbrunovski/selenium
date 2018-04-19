package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

@RunWith(value = Parameterized.class)
public class DataDrivenTesting {
    private String username;
    private String email;
    private String password;
    private WebDriver driver;

    public DataDrivenTesting(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\vitali.brunovski\\downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.github.com/");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][] {
                { "Testeruser1",  "email1@email.com", "password" },
                { "Testeruser2",  "email2@email.com", "password" },
                { "Testeruser3",  "email3@email.com", "password" },
                { "Testeruser4", "email4@email.com", "password" } });
    }

    @Test
    public void testFacebookRegistration() throws Exception {
        /*
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='u_0_1']")));
        } catch (TimeoutException ex) {
            Assert.fail("Not loaded");
        }
        */

        WebElement fname = driver.findElement(By.xpath("//*[@id=\"user[login]\"]"));
        fname.click();
        fname.clear();
        fname.sendKeys(username);

        WebElement emailAddress = driver.findElement(By.xpath("//*[@id=\"user[email]\"]"));
        emailAddress.click();
        emailAddress.clear();
        emailAddress.sendKeys(email);

        WebElement pass = driver.findElement(By.xpath("//*[@id=\"user[password]\"]"));
        pass.click();
        pass.clear();
        pass.sendKeys(password);

        WebElement reg = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/button"));
        reg.click();

        /*
        try{
// check the error message
            WebDriverWait wait2 = new WebDriverWait(driver, 10);
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#u_0_f i.sx_2bac47")));
        }
        catch (NoSuchElementException e) {
            Assert.fail("The element is not appeared.");
        }
        */
    }
}

