package beauty;

import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TimeBookingPage extends Page {
    private final static By seeStartTimesBtn = By.xpath("/html/body/div/app-root/app-site-layout/div/app-provider-booking/div/div/div[2]/div[1]/div[2]/div/table/tbody/tr[2]/td[3]/a");
    private final static By bookThisTimeBtn = By.xpath("/html/body/div/app-root/app-site-layout/div/app-provider-booking/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[2]/a");
    private final static By confirmBtn = By.xpath("/html/body/div/app-root/app-site-layout/div/app-provider-booking/div/div/ngx-smart-modal/div/div/div/button[2]");
    private final static By dd = By.xpath("/html/body/div[1]/app-root/app-site-layout/app-site-header/header/div/div/nav/div/div[2]/ul[2]/li[1]/a");
    private final static By logoutBtn = By.xpath("/html/body/div[1]/app-root/app-site-layout/app-site-header/header/div/div/nav/div/div[2]/ul[2]/li[1]/ul/li[1]/a");

    public TimeBookingPage(WebDriver driver) {
        super(driver);
    }

    public TimeBookingPage clickSeeStartTimes(){
        sleep(1);
        click(seeStartTimesBtn);
        return this;
    }

    public TimeBookingPage clickBookThisTime(){
        sleep(1);
        click(bookThisTimeBtn);
        sleep(1);
        click(confirmBtn);
		return this;
    }

    public LoginPage logout(){
        sleep(6);
        click(dd);
        sleep(1);
        click(logoutBtn);
        driver.manage().deleteAllCookies();
        sleep(2);
		return new LoginPage(driver);
    }
}
