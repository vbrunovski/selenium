package tinkoffBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class ZkuMoskva {
    public ZkuMoskva(WebDriver driver){
        this.driver = driver;
    }

    private final WebDriver driver;
    private final By oplatitZkuVMoskve = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div[1]/div/div/div/div[3]/div/ul/li[2]/div/a");
    private final By oplatitZkuVMoskveBtn = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div[1]/div/div/div/div[4]/div[1]/form/div[6]/div/div[1]/div/div/button");
    private final By kodPoleText = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div[1]/div/div/div/div[4]/div[1]/form/div[1]/div/div[2]");
    private final By periodPoleText = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div[1]/div/div/div/div[4]/div[1]/form/div[2]/div/div[2]");
    private final By summaPoleText = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div[1]/div/div/div/div[4]/div[1]/form/div[4]/div/div/div/div/div/div/div/div[2]");
    private final By platezhi = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/footer/div[2]/div/div/ul/li[1]/ul/li[6]/span/span/a");
    private String validationText = "Поле обязательное";

    public void clickOplatitZkuVMoskve(){
        driver.findElement(oplatitZkuVMoskve).click();
    }

    public void validationCheck(){
        driver.findElement(oplatitZkuVMoskveBtn).click();
        WebElement kodElement = driver.findElement(kodPoleText);
        String kod = kodElement.getText();
        assertEquals(validationText, kod);

        WebElement periodElement = driver.findElement(periodPoleText);
        String period = periodElement.getText();
        assertEquals(validationText, period);

        WebElement summaElement = driver.findElement(summaPoleText);
        String summa = summaElement.getText();
        assertEquals(validationText, summa);
    }

    public void clickPlatezhi(){
        driver.findElement(platezhi).click();
    }
}
