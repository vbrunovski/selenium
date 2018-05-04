package beauty;

import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegStep3 extends Page {

    private final By mondayO = By.xpath("/html/body/div[1]/app-root/app-site-layout/div/app-profile-steps/div[2]/div[2]/div[3]/div/app-schedule-manager/div[2]/div/div[1]/div[1]/div[2]/select");
    private final By mondayC = By.xpath("/html/body/div[1]/app-root/app-site-layout/div/app-profile-steps/div[2]/div[2]/div[3]/div/app-schedule-manager/div[2]/div/div[1]/div[1]/div[3]/select");

    private final String openingXpathTemplate = "/html/body/div[1]/app-root/app-site-layout/div/app-profile-steps/div[2]/div[2]/div[3]/div/app-schedule-manager/div[2]/div/div[1]/div[${i}]/div[2]/select";
    private final String closingXpathTemplate = "/html/body/div[1]/app-root/app-site-layout/div/app-profile-steps/div[2]/div[2]/div[3]/div/app-schedule-manager/div[2]/div/div[1]/div[${i}]/div[3]/select";

    private final By continueBtn = By.xpath("/html/body/div/app-root/app-site-layout/div/app-profile-steps/div[2]/div[2]/div[3]/div/app-schedule-manager/div[2]/div/div[3]/div/a");

    public RegStep3(WebDriver driver) {
        super(driver);
    }

    RegStep4 clickContinue() {
        click(continueBtn);
        return new RegStep4(driver);
    }

    private void fillOpeningHours(int elementNr, String openingHours, String closingHours) {
        WebElement el1 = driver.findElement(By.xpath(openingXpathTemplate.replace("${i}", String.valueOf(elementNr))));
        Select timeSelect = new Select(el1);
        timeSelect.selectByVisibleText(openingHours);

        WebElement el2 = driver.findElement(By.xpath(closingXpathTemplate.replace("${i}", String.valueOf(elementNr))));
        Select timeSelect2 = new Select(el2);
        timeSelect2.selectByVisibleText(closingHours);
        sleep(2);
    }

    RegStep3 openingHours(String openingHours, String closingHours){
        for (int i = 0; i < 7; i++) {
            fillOpeningHours(i + 1, openingHours, closingHours);
        }
        return this;
    }

}
