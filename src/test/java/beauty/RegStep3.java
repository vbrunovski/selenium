package beauty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegStep3 extends Page {
    static WebDriver driver;

    private final By mondayO = By.xpath("/html/body/div[1]/app-root/app-site-layout/div/app-profile-steps/div[2]/div[2]/div[3]/div/app-schedule-manager/div[2]/div/div[1]/div[1]/div[2]/select");
    private final By mondayC = By.xpath("/html/body/div[1]/app-root/app-site-layout/div/app-profile-steps/div[2]/div[2]/div[3]/div/app-schedule-manager/div[2]/div/div[1]/div[1]/div[3]/select");


    @Override
    WebDriver getDriver() {
        return driver;
    }

    public RegStep3(WebDriver driver) {
        this.driver = driver;
    }

    RegStep3 openingHours(String openingHours, String closingHours){
        WebElement el1 = driver.findElement(mondayO);
        Select timeSelect = new Select(el1);
        timeSelect.selectByVisibleText(openingHours);

        WebElement el2 = driver.findElement(mondayC);
        Select timeSelect2 = new Select(el2);
        timeSelect2.selectByVisibleText(closingHours);
        sleep(2);
        return this;
    }

}
