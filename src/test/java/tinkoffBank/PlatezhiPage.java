package tinkoffBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlatezhiPage {
    public PlatezhiPage(WebDriver driver){
        this.driver = driver;
    }

    private final WebDriver driver;

    ZkhPage zkuTextFromZkhPage;
    String zkuText = zkuTextFromZkhPage.getZkuText();

    private final By zkh = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/a/span/div/div[2]/div/div/div");
    private final By searchInputField = By.xpath("//*[@id=\"search-and-pay-container\"]/div[2]/div[2]/div/form/div[3]/div/div/div/div/label/div/input");

    public void clickZkh(){
        driver.findElement(zkh).click();
    }


    public void searchInput(){
        WebElement searchInput = driver.findElement(searchInputField);
        searchInput.sendKeys(zkuText);
    }
}
