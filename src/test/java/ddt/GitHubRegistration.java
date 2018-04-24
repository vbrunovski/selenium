package ddt;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GitHubRegistration {

    static WebDriver driver;

    User user;

    GitHubRegistration(User user) {
        this.user = user;
    }

    @BeforeClass
    public static void SetUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\vitali.brunovski\\downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testGithubReg(){
        driver.get("https://github.com");
        WebElement usernameG = driver.findElement(By.xpath("//*[@id=\"user[login]\"]"));
        usernameG.sendKeys(user.name);
        WebElement emailG = driver.findElement(By.xpath("//*[@id=\"user[email]\"]"));
        emailG.sendKeys(user.email);
        WebElement passG = driver.findElement(By.xpath("//*[@id=\"user[password]\"]"));
        passG.sendKeys(user.pass);
    }


}
