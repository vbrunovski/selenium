package beauty;

import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.Assert.*;

public class DashboardAddBookingPage extends Page {

    private static final By dateInput = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-add-booking/form/div/div[1]/div/div/div/div[1]/input");

    public DashboardAddBookingPage(WebDriver driver) {
        super(driver);
    }

    public void bookingDetails(){

        //writeInput(dateInput, "01.01.2018");
        click(dateInput);

        try {
            Robot robot = new Robot();
            //paste
            robot.keyPress(KeyEvent.VK_0);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyPress(KeyEvent.VK_0);
            robot.keyPress(KeyEvent.VK_2);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_2);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_0);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_1);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_8);
            Thread.sleep(1000);


        } catch (AWTException e) {
            e.printStackTrace();
            fail(e.getMessage());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
