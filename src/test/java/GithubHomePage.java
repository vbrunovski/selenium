import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GithubHomePage {

    private final WebDriver driver;
    private By signInButton = By.xpath("/html/body/div[1]/header/div/div[2]/div/span/div/a[1]");

    public GithubHomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickToSignInButton(){
        driver.findElement(signInButton).click();
    }
}
