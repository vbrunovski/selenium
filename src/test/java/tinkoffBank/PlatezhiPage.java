package tinkoffBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PlatezhiPage {

    static WebDriver driver;

    public PlatezhiPage(WebDriver driver){
        this.driver = driver;
    }

    private final By zkh = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[3]/div/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/a/span/div/div[2]/div/div");
    private final By searchInputField = By.xpath("//*[@id=\"search-and-pay-container\"]/div[2]/div[2]/div/form/div[3]/div/div/div/div/label/div/input");
    private final By clickZkuMoskva =  By.xpath("//*[@id=\"search-and-pay-container\"]/div[2]/div[2]/div/form/div[3]/div/div/div/div[2]/div/div[1]/div/div/div[1]/div/div[1]/div[2]/div");

    public void clickZkh(){
        driver.findElement(zkh).click();
    }


    public void searchInput() throws InterruptedException {
        String text = ZkhPage.zkuText;
        WebElement searchInput = driver.findElement(searchInputField);
        searchInput.sendKeys(text);
        Thread.sleep(3000);
       // System.out.println("Text takoj: " + text);
    }

    public void clickZkuMoskvaDropDown(){
        driver.findElement(clickZkuMoskva).click();
    }

    public void verifyElementIsFirst() throws InterruptedException {
        List<WebElement> dropDownText = driver.findElements(By.cssSelector("[data-qa-file='SearchSuggested'] [data-qa-file='Text']")); // Grid__root_display_block_3j1gE, Text__text_size_17_3d9gC Grid__root_3dqwx
        System.out.println(dropDownText.get(0).getText());
        if(dropDownText.get(0).getText().equals("ЖКУ-Москва")){
            System.out.println("Первым элементом является - " + dropDownText.get(0).getText());
        }
        else{
            System.out.println("Что-то другое " + dropDownText.get(0).getText());
        }

        Thread.sleep(3000);
    }
}
