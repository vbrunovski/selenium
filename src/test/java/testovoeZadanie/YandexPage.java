package testovoeZadanie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexPage extends Functions{

    @Override
    protected WebDriver getDriver() {
        return driver;
    }

    private final WebDriver driver;
    private final By marketLink = By.linkText("Маркет");


    public YandexPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickToMarket(){
        driver.findElement(marketLink).click();
    }
}
