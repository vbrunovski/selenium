package beauty;

import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class DashboardAddBookingPage extends Page {

    private static final By dateInput = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-add-booking/form/div/div[1]/div/div/div/div[1]/input");

    public DashboardAddBookingPage(WebDriver driver) {
        super(driver);
    }

    public void bookingDetails(){
        click(dateInput);
        writeInput(dateInput, "01.10.2018");
    }
}
