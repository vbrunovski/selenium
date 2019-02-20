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
    private final By oplatitZkuVMoskve = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[3]/div/div[2]/div[1]/div/div/div/div[3]/div/ul/li[2]/div/a/span");
    private final By oplatitZkuVMoskveBtn = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[3]/div/div[2]/div[1]/div/div/div/div[4]/div[1]/form/div[6]/div/div[1]/div/div/button");
    private final By kodPoleText = By.xpath("//*[@id=\"payerCode\"]");
    private final By periodPoleText = By.xpath("//*[@id=\"period\"]");
    private final By summaPoleText = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[6]/div/div[2]/div[1]/div/div/div/div[4]/div[1]/form/div[4]/div/div/div/div/div/div/div/div[1]/label/div/input");
    private final By platezhi = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/footer/div[2]/div/div[2]/ul/li[1]/ul/li[7]/a");
    private String validationText = "Поле обязательное";

    private final By kodPoleTextValidation =  By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[3]/div/div[2]/div[1]/div/div/div/div[4]/div[1]/form/div[1]/div/div[2]");
    private final By periodPoleTextValidation =  By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[3]/div/div[2]/div[1]/div/div/div/div[4]/div[1]/form/div[2]/div/div[2]");
    private final By summaPoleTextValidation =  By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[3]/div/div[2]/div[1]/div/div/div/div[4]/div[1]/form/div[4]/div/div/div/div/div/div/div/div[2]");


    public void clickOplatitZkuVMoskve(){
        driver.findElement(oplatitZkuVMoskve).click();
    }

    public void validationCheck(){
        driver.findElement(oplatitZkuVMoskveBtn).click();
        WebElement kodElement = driver.findElement(kodPoleTextValidation);
        String kod = kodElement.getText();
        assertEquals(validationText, kod);

        WebElement periodElement = driver.findElement(periodPoleTextValidation);
        String period = periodElement.getText();
        assertEquals(validationText, period);

        WebElement summaElement = driver.findElement(summaPoleTextValidation);
        String summa = summaElement.getText();
        assertEquals(validationText, summa);
    }

    public void clickPlatezhi(){
        driver.findElement(platezhi).click();
    }
}
