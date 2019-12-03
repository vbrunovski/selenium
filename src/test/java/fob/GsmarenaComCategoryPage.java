package fob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GsmarenaComCategoryPage {
    private final WebDriver driver;
    private final By clickAppleMob = By.xpath("//*[@id=\"review-body\"]/div[1]/ul/li[3]/a");

    public GsmarenaComCategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchMobilePhone() throws InterruptedException {
        driver.findElement(clickAppleMob).click();
    }
}
