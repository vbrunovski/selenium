package fob;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WegoHereComCarsharingPageScenario1 {
    private final WebDriver driver;
    private final By clickCarshering = By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[2]/div/button[4]");
    private final By notFoundRouteText = By.xpath("//*[@id=\"routes_list\"]/section/section/h2");


    public WegoHereComCarsharingPageScenario1(WebDriver driver){
        this.driver = driver;
    }

    public void clickCarshering() throws InterruptedException {
        driver.findElement(clickCarshering).click();
        Thread.sleep(5000);
    }

    public void verifyCarsheringCalculated(){
        String notFoundRoute = driver.findElement(notFoundRouteText).getText();
        Assert.assertEquals("Didn't find a route for that journey", notFoundRoute);
    }
}
