package beauty;

import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class ProviderPage extends Page {
    private final static By toScroll1 = By.xpath("/html/body/div/app-root/app-site-layout/div/app-provider-page/div/div[2]/div[1]/div[4]/div/div/table/tbody/tr[1]");
    private final static By bookServicebtn = By.xpath("/html/body/div/app-root/app-site-layout/div/app-provider-page/div/div[2]/div[1]/div[4]/div/div/table/tbody/tr[2]/td[4]/a");
    private final static By sendMessageBtn = By.xpath("/html/body/div/app-root/app-site-layout/div/app-provider-page/div/div[2]/div[2]/div[1]/a");
    private final static By whatWeAreSenging = By.xpath("/html/body/div/app-root/app-site-layout/div/app-provider-page/div/div[2]/ngx-smart-modal[1]/div/div/div/form/textarea");
    private final static By sendBtn = By.xpath("/html/body/div/app-root/app-site-layout/div/app-provider-page/div/div[2]/ngx-smart-modal[1]/div/div/div/form/button");
    private final static By dDown = By.xpath("/html/body/div/app-root/app-site-layout/app-site-header/header/div/div/nav/div/div[2]/ul[2]/li[1]/a");
    private final static By goToDashBoard = By.xpath("/html/body/div/app-root/app-site-layout/app-site-header/header/div/div/nav/div/div[2]/ul[2]/li[1]/ul/li[3]/a");


    public ProviderPage(WebDriver driver) {
        super(driver);
    }

    public TimeBookingPage clickToBookService(){
        scrollToElement(toScroll1);
        click(bookServicebtn);
        sleep(1);
        return new TimeBookingPage(driver);
    }

    public void clickSendMessage(String message){
        sleep(1);
        click(sendMessageBtn);
        sleep(1);
        writeInput(whatWeAreSenging ,message);
        click(sendBtn);
        sleep(4);
    }

    public void goToDashBoard(){
        click(dDown);
        sleep(1);
        click(goToDashBoard);
    }

    public void checkDay(){
        WebElement textHeading = driver.findElement(By.xpath("/html/body/div/app-root/app-site-layout/div/app-provider-page/div/div[2]/div[2]/div[2]/ul/li[5]/span"));
        String textHeading2 = textHeading.getText();
        System.out.println(textHeading2);
        //assertEquals("11 AM - 1 PM", textHeading2);

        WebElement monday = driver.findElement(By.xpath("/html/body/div/app-root/app-site-layout/div/app-provider-page/div/div[2]/div[2]/div[2]/ul/li[1]/span"));
        String monday2 = monday.getText();
        System.out.println(monday2);
        assertEquals("Closed", monday2);
    }
}
