package tinkoffBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class ZkhPage {
    public ZkhPage(WebDriver driver){
        this.driver = driver;
    }

    private final WebDriver driver;
    private final By cityName = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/div[2]/div/div/div/span/span/span");
    private final By zkuMoskva = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/section/ul/li[1]/span[2]/a/span/div");
    public String zkuText;

    //getter
    public String getZkuText(){
        return this.zkuText;
    }

    public void verifyCity(String text){
        WebElement city = driver.findElement(cityName);
        city.getText();
        System.out.println(city.getText());
        assertEquals(text, city.getText());
    }

    public void clickZkuMoskva(){
        driver.findElement(zkuMoskva).click();
        WebElement zku = driver.findElement(zkuMoskva);
        zkuText = zku.getText();
        System.out.println(zkuText);
    }
}
