package autoru;

//import org.junit.BeforeClass;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import saule.UIPageLogin;
import java.util.concurrent.TimeUnit;

public class MainPage {
    private final WebDriver driver;
    private final By searchField = By.xpath("/html/body/div[4]/div/div[2]/div[1]/label/div/span/input");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void acceptCookie(){
        driver.findElement(By.cssSelector("#confirm-button")).click();
    }


    public void chooseMoscowRegion() throws InterruptedException {
        //click Ljuboj region
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[1]/div/div[2]/div[1]/div/div/span")).click();
        Thread.sleep(5000);
        //click Moscow
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div/div[1]/button[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]")).click();

        WebElement title = driver.findElement(searchField);
        title.sendKeys("Ярославль");

        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]")).click();
    }
}
