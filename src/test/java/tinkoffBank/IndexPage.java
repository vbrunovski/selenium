package tinkoffBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage {

    public IndexPage(WebDriver driver){
        this.driver = driver;
    }

    private final WebDriver driver;
    private final By platezhi = By.xpath("//*[@id=\"xccb5e\"]/div/footer/div[2]/div/div[2]/ul/li[1]/ul/li[7]/a");

    public void clickPlatezhi(){
        driver.findElement(platezhi).click();
    }
}
