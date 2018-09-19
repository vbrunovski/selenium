package beauty;

import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class DashboardIndexPage extends Page {
    private static final By bookingsLink = By.xpath("/html/body/div/app-root/app-provider-layout/div/app-left-nav/div/div/ul[2]/li[1]/a");
    private static final By homeLink = By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/a");
    private static final By findWhat = By.xpath("/html/body/div/app-root/app-site-layout/div/app-home/div/div/div/div/div/form/div/div[1]/input");
    private static final By messagesLink = By.xpath("/html/body/div/app-root/app-provider-layout/div/app-left-nav/div/div/ul[1]/li[2]/a");
    private static final By myprofileLink = By.xpath("/html/body/div/app-root/app-provider-layout/div/app-left-nav/div/div/ul[3]/li[1]/a");
    private static final By clickWorkingShedule = By.xpath("/html/body/div/app-root/app-provider-layout/div/app-left-nav/div/div/ul[2]/li[4]/a");
    private static final By clickAddBooking = By.xpath("/html/body/div/app-root/app-provider-layout/div/app-left-nav/div/div/ul[2]/li[1]/a");

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

    public void clickMessages(){
        click(messagesLink);
    }

    public void findMessage(String text){
        assertEquals(text, text);
    }

    public void clickMyProfile(){
        click(myprofileLink);
    }

    public void clickWorkingShedule(){

        click(clickWorkingShedule);
    }

    public void clickAddBooking(){
        click(clickAddBooking);
    }


}
