package beauty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class DashboardBookingsPage extends Page{
    private WebDriver driver;
    private static final By approveBtn = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-bookings/div[2]/table/tbody/tr[2]/td[7]/button[1]");


    @Override
    protected WebDriver getDriver(){return driver;}

    public DashboardBookingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyIsBooked(){
        WebElement el = driver.findElement(approveBtn);
        String text = el.getText();
        System.out.println(text);
        assertEquals("Approve", text);
    }
}
