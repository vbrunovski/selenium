package saule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIPageLogin {
    private final WebDriver driver;

    public UIPageLogin(WebDriver driver){
        this.driver = driver;
    }

    public void clickLogInBtn(){
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        username.sendKeys("myusername");
        password.sendKeys("mypassword");

        driver.findElement(By.xpath("//*[@id=\"login_btn\"]")).click();

    }
}
