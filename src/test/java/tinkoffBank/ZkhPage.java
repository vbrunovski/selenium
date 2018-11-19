package tinkoffBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ZkhPage {
    public ZkhPage(WebDriver driver){
        this.driver = driver;
    }

    private final WebDriver driver;
    private final By cityName = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/div[2]/div/div/div/span/span/span");
    private final By zkuMoskva = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/section/ul/li[1]/span[2]/a/span/div");
    private final By clickCity = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/div[2]/div/div/div/span/span/span");
    private final By clickSpb = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[4]/div/div/div/div/div/div[2]/div/div[2]/div[2]/div/span/a");
    public static String zkuText;

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

    public void selectAnotherCity() throws InterruptedException {
        driver.findElement(clickCity).click();
        Thread.sleep(1000);
        driver.findElement(clickSpb).click();
    }

    public void verifyZkhIsNotExists(){
        List<WebElement> zkhOnPage = driver.findElements(By.className("UIMenu__link_enabledFade_2a9MA"));
        List<String> all_elements_text=new ArrayList<>();

        for(int i=0; i<zkhOnPage.size(); i++){

            //loading text of each element in to array all_elements_text
            all_elements_text.add(zkhOnPage.get(i).getText());

            //to print directly
            //System.out.println(zkhOnPage.get(i).getText());
            if(zkhOnPage.get(i).getText().equals("ЖКУ-Москва")){
                System.out.println("Элемент ЖКУ-Москва есть на странице");
                break;
            }
            else{
                System.out.println("Элемент ЖКУ-Москва отсутствует");
                break;
            }
        }
    }
}
