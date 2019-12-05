package fob;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WegoHereComBikePageScenario1 {
    private final WebDriver driver;
    private final By clickBike = By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[2]/div/button[6]");
    WegoHereComConstants hourConst = new WegoHereComConstants();
    WegoHereComConstants minConst = new WegoHereComConstants();


    public WegoHereComBikePageScenario1(WebDriver driver){
        this.driver = driver;
    }

    public void clickBike() throws InterruptedException {
        driver.findElement(clickBike).click();
        Thread.sleep(5000);
    }

    public void verifyBikeCalculated(){
        String calculatedRouteHour = driver.findElement(hourConst.getRoutePathHour()).getText();
        String calculatedRouteMin = driver.findElement(minConst.getRoutePathMin()).getText();
        try {
            Assert.assertTrue(Integer.parseInt(calculatedRouteMin) > 0);
            System.out.println("Bike route is calculated. Time is " + calculatedRouteHour + " hour " + calculatedRouteMin + " min");
        }
        catch(AssertionError e){
            System.out.println("Bike route is not calculated");
            throw e;
        }
    }
}
