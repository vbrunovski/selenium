package beauty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardServicesPage extends Page {
    private WebDriver driver;

    private final By skipBtn = By.xpath("/html/body/div/app-root/app-site-layout/div/app-profile-steps/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/app-service-manager/div/a");
    private final By hairServiceCheckbox = By.xpath("//ul/li[.='Hair service']/span[@class='icon check-icon glyphicon glyphicon-unchecked']");
    private final By deleteIcon = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-services/div[2]/div[1]/div/div/div[2]/div/div[2]/app-service-manager/table/tbody/tr[2]/td[4]/i");
    private final By duration1 = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-services/div[2]/div[1]/div/div/div[2]/div/div[2]/app-service-manager/table/tbody/tr[2]/td[2]/input");
    private final By price1 = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-services/div[2]/div[1]/div/div/div[2]/div/div[2]/app-service-manager/table/tbody/tr[2]/td[3]/input");
    private final By duration2 = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-services/div[2]/div[1]/div/div/div[2]/div/div[2]/app-service-manager/table/tbody/tr[3]/td[2]/input");
    private final By price2 = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-services/div[2]/div[1]/div/div/div[2]/div/div[2]/app-service-manager/table/tbody/tr[3]/td[3]/input");
    private final By duration3 = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-services/div[2]/div[1]/div/div/div[2]/div/div[2]/app-service-manager/table/tbody/tr[4]/td[2]/input");
    private final By price3 = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-services/div[2]/div[1]/div/div/div[2]/div/div[2]/app-service-manager/table/tbody/tr[4]/td[3]/input");
    private final By servicesLink = By.xpath("/html/body/div/app-root/app-provider-layout/div/app-left-nav/div/div/ul[2]/li[2]/a");
    private final By saveBtn = By.xpath("//*[@id=\"next1\"]");
    private final By scrollToEl = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-services/div[2]/div[2]/div");
    private final By clickWorkingSheduleLink = By.xpath("/html/body/div[1]/app-root/app-provider-layout/div/app-left-nav/div/div/ul[2]/li[3]/a");

    @Override
    protected WebDriver getDriver() {
        return driver;
    }

    public DashboardServicesPage(WebDriver driver) {
        this.driver = driver;
    }

    DashboardServicesPage services(){
        click(servicesLink);
        driver.findElement(hairServiceCheckbox).click();

        for(int i=0; i<41; i++){
            driver.findElement(deleteIcon).click();
        }
        return this;
    }

    DashboardServicesPage fillPriceAndDuration(String duration, String price) {
        writeInput(duration1, duration);
        writeInput(price1, price);
        writeInput(duration2, duration);
        writeInput(price2, price);
        writeInput(duration3, duration);
        writeInput(price3, price);
        return this;
    }

    DashboardServicesPage clickSave(){
        scrollToElement(scrollToEl);
        click(saveBtn);
        return this;
    }

    public DashboardWorkingShedulePage clickWorkingShedule(){
        click(clickWorkingSheduleLink);
        return new DashboardWorkingShedulePage(driver);
    }

}
