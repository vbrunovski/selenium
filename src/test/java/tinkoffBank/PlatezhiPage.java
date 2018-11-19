package tinkoffBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PlatezhiPage {

    ZkhPage zkuTextFromZkhPage;
    public String zkuText;

    public PlatezhiPage(WebDriver driver){
        this.driver = driver;
        zkuTextFromZkhPage = new ZkhPage(driver);
        zkuText = zkuTextFromZkhPage.getZkuText();
    }

    private final WebDriver driver;

    private final By zkh = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/a/span/div/div[2]/div/div/div");
    private final By searchInputField = By.xpath("//*[@id=\"search-and-pay-container\"]/div[2]/div[2]/div/form/div[3]/div/div/div/div/label/div/input");
    private final By clickZkuMoskva =  By.xpath("//*[@id=\"search-and-pay-container\"]/div[2]/div[2]/div/form/div[3]/div/div/div/div[2]/div/div[1]/div/div/div[1]/div/div[1]/div[1]");

    public void clickZkh(){
        driver.findElement(zkh).click();
    }


    public void searchInput(){
        WebElement searchInput = driver.findElement(searchInputField);
        searchInput.sendKeys("ЖКУ-Москва");
    }

    public void clickZkuMoskvaDropDown(){
        driver.findElement(clickZkuMoskva).click();
    }

    public void verifyElementIsFirst(){
        List<WebElement> dropDownText = driver.findElements(By.className("Text__text_size_17_3d9gC"));
        if(dropDownText.get(0).getText().equals("ЖКУ-Москва")){
            System.out.println("Первым элементом является - " + dropDownText.get(0).getText());
        }
    }
}
