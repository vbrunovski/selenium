package fob;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WegoHereComDrivePageScenario1 {
    private final WebDriver driver;
    private final By clickDrive = By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[1]/div[2]/div[3]/div/div/time");
    WegoHereComConstants hourConst = new WegoHereComConstants();
    WegoHereComConstants minConst = new WegoHereComConstants();


    public WegoHereComDrivePageScenario1(WebDriver driver){
        this.driver = driver;
    }

    public void clickDrive() throws InterruptedException {
        driver.findElement(clickDrive).click();
        Thread.sleep(5000);
    }

    public void verifyDriveCalculated(){
        String calculatedRouteHour = driver.findElement(hourConst.getRoutePathHour()).getText();
        String calculatedRouteMin = driver.findElement(minConst.getRoutePathMin()).getText();
        try {
            Assert.assertTrue(Integer.parseInt(calculatedRouteMin) > 0);
            System.out.println("Drive route is calculated. Time is " + calculatedRouteHour + " hour " + calculatedRouteMin + " min");
        }
        catch(AssertionError e){
            System.out.println("Drive route is not calculated");
            throw e;
        }
    }
}
