package github;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GithubLoginPage {
    private final WebDriver driver;
    private By username = By.xpath("//*[@id=\"login_field\"]");
    private By password = By.xpath("//*[@id=\"password\"]");
    private By button = By.xpath("//*[@id=\"login\"]/form/div[3]/input[3]");

    public GithubLoginPage(WebDriver driver){

        this.driver = driver;
    }

    public void setUsername(String strUsername){

        driver.findElement(username).sendKeys(strUsername);
    }

    public void setPassword(String strPassword){

        driver.findElement(password).sendKeys(strPassword);
    }

    public void loginToTheWebsite(String strUsername, String strPassword){
        this.setUsername(strUsername);
        this.setPassword(strPassword);
        driver.findElement(button).click();
    }
}
