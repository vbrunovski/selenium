package beauty;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URISyntaxException;

import static org.junit.Assert.fail;

public class RegStep4 extends Page {
    private final By fileupload = By.xpath("/html/body/div/app-root/app-site-layout/div/app-profile-steps/div[2]/div[2]/div[4]/div/app-user-uploads/div[2]/div/div[1]/dropzone/div/div/div");
    private final By finishBtn = By.xpath("//*[@id=\"next1\"]");
    private final By elToScroll = By.xpath("/html/body/div/app-root/app-site-layout/div/app-profile-steps/div[2]/div[2]/div[4]/div/app-user-uploads/div[1]/h3");

    static WebDriver driver;
    @Override
    protected WebDriver getDriver() {
        return driver;
    }



    public RegStep4(WebDriver driver) {
        this.driver = driver;
    }

    public RegStep4 finishBtn(){
        sleep(3);
        scrollToElement(elToScroll);

        sleep(1);
        driver.findElement(finishBtn).submit();
        return new RegStep4(driver);

    }

     RegStep4 imageUpload(String filename) {
         //click(fileupload);
         sleep(2);
         File file = null;
         try {
             file = new File(getClass().getClassLoader().getResource(filename).toURI());
         } catch (URISyntaxException e) {
             e.printStackTrace();
             fail(e.getMessage());
         }


         click(fileupload);

         //copy
         StringSelection ss = new StringSelection(file.getAbsolutePath());
         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

         try {
             Robot robot = new Robot();
            //paste
             robot.keyPress(KeyEvent.VK_CONTROL);
             robot.keyPress(KeyEvent.VK_V);
             robot.keyRelease(KeyEvent.VK_V);
             robot.keyRelease(KeyEvent.VK_CONTROL);
             sleep(2);
             robot.keyPress(KeyEvent.VK_ENTER);
             robot.keyRelease(KeyEvent.VK_ENTER);

             System.out.println(file.getAbsoluteFile());
             sleep(3);
             return this;
         } catch (AWTException e) {
             e.printStackTrace();
             fail(e.getMessage());
             return null;
         }
     }


}
