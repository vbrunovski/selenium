package beauty;

import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.junit.Assert.fail;

public class DashboardWorkingShedulePage extends Page {
    private final By sunday = By.xpath("/html/body/div[1]/app-root/app-provider-layout/div/div/app-schedules/div[2]/div/div/div/ng-fullcalendar/div[2]/div/table/tbody/tr/td/div/div/div[2]/table/tbody/tr[6]/td[2]");

    private final String openingXpathTemplate = "/html/body/div[1]/app-root/app-provider-layout/div/div/app-schedules/div[2]/app-schedule-manager/div[2]/div/div[1]/div[${i}]/div[2]/select";
    private final String closingXpathTemplate = "/html/body/div[1]/app-root/app-provider-layout/div/div/app-schedules/div[2]/app-schedule-manager/div[2]/div/div[1]/div[${i}]/div[3]/select";
    private final By addSheduleSunday = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-schedules/div[2]/app-schedule-manager/div[2]/div/div[1]/div[7]/div[4]/a");
    private final By addSheduleSuturday = By.xpath("/html/body/div[1]/app-root/app-provider-layout/div/div/app-schedules/div[2]/app-schedule-manager/div[2]/div/div[1]/div[6]/div[4]/a");
    private final By addSheduleFriday = By.xpath("/html/body/div[1]/app-root/app-provider-layout/div/div/app-schedules/div[2]/app-schedule-manager/div[2]/div/div[1]/div[5]/div[4]/a");
    private final By clickIndexBtn = By.xpath("/html/body/div/app-root/app-provider-layout/app-provider-header/header/div/div/div[1]/div[1]/a[2]");

    private final By clickWorkingShedule = By.xpath("/html/body/div/app-root/app-provider-layout/div/app-left-nav/div/div/ul[2]/li[4]/a");

    public DashboardWorkingShedulePage(WebDriver driver) {
        super(driver);
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

    DashboardWorkingShedulePage openingHours(String openingHours, String closingHours){
        for (int i = 0; i < 7; i++) {
            fillOpeningHours(i + 1, openingHours, closingHours);
        }
        return this;
    }

    DashboardWorkingShedulePage openingHoursclickAdd(String openingHours, String closingHours){
        for (int i = 0; i < 7; i++) {
            fillOpeningHours(i + 1, openingHours, closingHours);
        }
        click(addSheduleFriday);
        click(addSheduleSuturday);
        click(addSheduleSunday);
        return this;
    }

    public void clickAddSheduleButton(){
        click(addSheduleFriday);
    }

    public void clickIndexPage(){
        click(clickIndexBtn);
    }

    public void clickWorkingShedule(){
        click(clickWorkingShedule);
    }

    public void myShedule2(Weekday weekDay, String timeEnd){
        WebElement elem = driver.findElement(sunday);
        //click on coordinates
        Actions builder = new Actions(driver);
        builder.moveToElement(elem , weekDay.offsetX, 0).click().build().perform();
        //click(sunday);

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
