package beauty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.junit.Assert.fail;

public class DashboardWorkingShedulePage extends Page{
    private WebDriver driver;

    private final By sunday = By.xpath("/html/body/div[1]/app-root/app-provider-layout/div/div/app-schedules/div[2]/div/div/div/ng-fullcalendar/div[2]/div/table/tbody/tr/td/div/div/div[2]/table/tbody/tr[6]/td[2]");

    @Override
    protected WebDriver getDriver(){return driver;}

    public DashboardWorkingShedulePage(WebDriver driver) {
        this.driver = driver;
    }

    public void MyShedule(String timeEnd){
        click(sunday);

        //copy
        StringSelection ss = new StringSelection(timeEnd);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        try {
            Robot robot = new Robot();
            //paste
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            sleep(1);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
        catch(AWTException e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }


}
