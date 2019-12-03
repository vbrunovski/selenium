package fob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WegoHereComIndexPageScenario1 {
    private final WebDriver driver;
    private final By whereField = By.xpath("//*[@id=\"searchbar\"]/div/div/input");
    private final By clickLocation = By.xpath("//*[@id=\"searchbar\"]/div/div[2]/div[1]");
    private final String whereLocation = "Narva";

    public WegoHereComIndexPageScenario1(WebDriver driver){
        this.driver = driver;
    }

    public String getLocation(){
        return whereLocation;
    }

    public void createRoute() throws InterruptedException {
        WebElement where = driver.findElement(whereField);
        where.sendKeys(whereLocation);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(clickLocation));
        driver.findElement(clickLocation).click();
        Thread.sleep(2000);
    }
}
