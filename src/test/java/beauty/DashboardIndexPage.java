package beauty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardIndexPage extends Page{
    private WebDriver driver;
    private static final By bookingsLink = By.xpath("/html/body/div/app-root/app-provider-layout/div/app-left-nav/div/div/ul[2]/li[1]/a");

    @Override
    protected WebDriver getDriver(){return driver;}

    public DashboardIndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBookings(){
        click(bookingsLink);
        sleep(1);
    }
}
