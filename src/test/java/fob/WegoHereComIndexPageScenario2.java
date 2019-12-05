package fob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WegoHereComIndexPageScenario2 {
    private final WebDriver driver;
    private final By clickOpenMenu = By.xpath("//*[@id=\"searchbar\"]/div/div/button[1]");
    private final By clickSignIn = By.xpath("/html/body/div[1]/div[3]/div/div[1]/section/div/button[1]");

    public WegoHereComIndexPageScenario2(WebDriver driver){
        this.driver = driver;
    }

    public void signIn() throws InterruptedException {
        driver.findElement(clickOpenMenu).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(clickSignIn));
        driver.findElement(clickSignIn).click();
        Thread.sleep(5000);
    }
}
