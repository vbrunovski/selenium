package fob;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WegoHereComPublicPageScenario1 {
    private final WebDriver driver;
    private final By clickPublic = By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[2]/div/button[3]");
    WegoHereComConstants hourConst = new WegoHereComConstants();
    WegoHereComConstants minConst = new WegoHereComConstants();


    public WegoHereComPublicPageScenario1(WebDriver driver){
        this.driver = driver;
    }

    public void clickPublic() throws InterruptedException {
        driver.findElement(clickPublic).click();
        Thread.sleep(5000);
    }

    public void verifyPublicCalculated(){
        String calculatedRouteHour = driver.findElement(hourConst.getRoutePathHour()).getText();
        String calculatedRouteMin = driver.findElement(minConst.getRoutePathMin()).getText();
        try {
            Assert.assertTrue(Integer.parseInt(calculatedRouteMin) > 0);
            System.out.println("Public route is calculated. Time is " + calculatedRouteHour + " hour " + calculatedRouteMin + " min");
        }
        catch(AssertionError e){
            System.out.println("Public route is not calculated");
            throw e;
        }
    }
}
