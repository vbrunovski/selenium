package fob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GsmarenaComCategoryPage {
    private final WebDriver driver;
    private final By clickAppleMob = By.xpath("//*[@id=\"review-body\"]/div[1]/ul/li[3]/a");
    private final By okCookieBtn = By.xpath("//*[@id=\"qcCmpButtons\"]/button[2]");

    public GsmarenaComCategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void okCookie(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(okCookieBtn));
        driver.findElement(okCookieBtn).click();
    }

    public void searchMobilePhone() throws InterruptedException {
        driver.findElement(clickAppleMob).click();
    }
}
