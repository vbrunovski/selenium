package fob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GsmarenaComIndexPage {
    private final WebDriver driver;
    private final By clickAppleCat = By.xpath("//*[@id=\"body\"]/aside/div[1]/ul/li[2]/a");

    public GsmarenaComIndexPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchMobileCategory() throws InterruptedException {
        driver.findElement(clickAppleCat).click();
    }
}
