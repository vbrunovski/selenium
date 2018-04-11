import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailPage {
    private final WebDriver driver;

    public GmailPage(WebDriver driver){

        this.driver = driver;
    }

    public LoginPage logout() {
        WebElement elEl = driver.findElement(By.xpath("//div/div/div/div/div/a/span[@class='gb_db gbii']"));
        elEl.click();

        WebElement logoutEL = driver.findElement(By.xpath("//div/div/div/a[@class='gb_Ea gb_Wf gb_4f gb_Le gb_Jb']"));
        logoutEL.click();

        return new LoginPage(driver);
    }

    public GmailPage sendEmail(String to, String subject, String body) throws InterruptedException {
        WebElement newEm = driver.findElement(By.xpath("//div/div/div[@class='T-I J-J5-Ji T-I-KE L3']"));
        newEm.click();

        Thread.sleep(2000);

        //to
        WebElement toEl = driver.findElement(By.xpath("//div/div/textarea[@class='vO']"));
        toEl.sendKeys(to);

        //subject
        WebElement subjEl = driver.findElement(By.xpath("//div/input[@class='aoT']"));
        subjEl.sendKeys(subject);

        //body
        WebElement bodyEl = driver.findElement(By.xpath("//div/div[@class='Am Al editable LW-avf']"));
        bodyEl.sendKeys(body);

        //click to send
        WebElement clickToSendEl = driver.findElement(By.xpath("//div/div[@class='T-I J-J5-Ji aoO T-I-atl L3']"));
        clickToSendEl.click();

        //esli okno ne vidimo
        if(driver.findElements(By.xpath("//div/div/div[@class='nH Hd']")).isEmpty()){

            fail("Send message dialog is still visible");
        }
        return this;

    }

    public void checkIsSentFolder() throws InterruptedException {

        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[7]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div")).click();
        Thread.sleep(2000);
        assertThat(driver.getTitle(), CoreMatchers.containsString("Помеченные"));
    }
        /*
        if(!driver.findElements(By.xpath("/html/body/div[7]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[2]/span/span[1]")).isEmpty()){
            driver.findElement(By.xpath("/html/body/div[7]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[3]/div/div[1]/div/div[3]/div/div/div[2]/span/a")).click();
            assertThat(driver.getTitle(), CoreMatchers.containsString("Отправленные"));
        }
        else {
            driver.findElement(By.xpath("/html/body/div[7]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[2]/span/span[1]")).click();
            driver.findElement(By.xpath("/html/body/div[7]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[3]/div/div[1]/div/div[3]/div/div/div[2]/span/a")).click();
            assertThat(driver.getTitle(), CoreMatchers.containsString("Отправленные"));
        }
        */



    public GmailPage findEmailBySubject() throws InterruptedException {
        // spisok pisem i naiti pismo s takim subjectom i kliknut po nemu
        WebElement we = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div[1]/div/div[1]/div/div/div[2]/span/a"));
        we.click();
        Thread.sleep(2000);
        WebElement findEmail = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[6]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[6]/div/div/div/span[2]"));
        findEmail.click();
        Thread.sleep(1000);
        WebElement bodyText = driver.findElement(By.xpath("//div/div/div[.='Hello, this is test message']"));
        String text = bodyText.getText();
        assertEquals("Hello, this is test message", text);
        System.out.println("Telo pisma: " + bodyText);
        return this;
    }
}
