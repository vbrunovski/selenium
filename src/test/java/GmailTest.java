import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;

public class GmailTest {
    static WebDriver driver;
    static String gmailLogin = "web.xmm@gmail.com";
    static String gmailPassword = "Dakota666";

    @BeforeClass
    public static void preTest() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\vitali.brunovski\\downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void afterTest() {
        //driver.quit();
    }

    @Test
    public void loginLogout() throws InterruptedException {

        LoginPage lp = new LoginPage(driver);
        GmailPage gp = lp.login(gmailLogin, gmailPassword);

        //lp = gp.logout();
        gp.logout();
        //gp = lp.login(gmailLogin, gmailPassword);
        lp.login(gmailLogin, gmailPassword);
        gp.sendEmail("web.xmm@gmail.com", "Test Selenium", "Hello, this is test message");
        gp.findEmailBySubject();
        //gp.checkIsSentFolder();
        //gp.logout();
        Thread.sleep(2000);
        //lp.checkForgot();

        //Thread.sleep(2000);

        //3
        //gp = lp.login(gmailLogin, gmailPassword);
        //lp = gp.logout();
    }
}
