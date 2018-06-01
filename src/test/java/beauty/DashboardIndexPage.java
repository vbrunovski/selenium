package beauty;

import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardIndexPage extends Page {
    private static final By bookingsLink = By.xpath("/html/body/div/app-root/app-provider-layout/div/app-left-nav/div/div/ul[2]/li[1]/a");
    private static final By homeLink = By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/a");
    private static final By findWhat = By.xpath("/html/body/div/app-root/app-site-layout/div/app-home/div/div/div/div/div/form/div/div[1]/input");

    public DashboardIndexPage(WebDriver driver) {
        super(driver);
    }

    public DashboardBookingsPage clickBookings(){
        click(bookingsLink);
        sleep(1);
        return new DashboardBookingsPage(driver);
    }

    public void clickHome(){
        click(homeLink);
    }

}
