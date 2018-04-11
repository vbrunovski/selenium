import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GithubTest {
    static WebDriver driver;
    GithubHomePage ghp = new GithubHomePage(driver);
    GithubLoginPage gloginp = new GithubLoginPage(driver);
    GithubLogoutPage glogoutp = new GithubLogoutPage(driver);

    private static String URL = "https://github.com";
    private static String username = "mrmourax@gmail.com";
    private static String password = "dakota00";

    @BeforeClass
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void loginLogout() throws InterruptedException {
        driver.get(URL);
        ghp.clickToSignInButton();
        Thread.sleep(2000);
        gloginp.loginToTheWebsite(username, password);
        Thread.sleep(2000);
        glogoutp.confirmThatUserLogged();
        Thread.sleep(1000);
        glogoutp.clickSignOut();
    }
}
