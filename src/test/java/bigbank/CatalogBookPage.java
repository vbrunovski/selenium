package bigbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogBookPage {
    private final WebDriver driver;
    private final static String URL = "https://raamatukogu.herokuapp.com/catalog/books";

    public CatalogBookPage(WebDriver driver){
        this.driver = driver;
    }

    public void VerifyBookInList(){
        String myBookName = NewBookPage.myBookName;

        driver.get(URL);
        driver.manage().window().maximize();

        WebElement area = driver.findElement(By.xpath("/html/body/div/div/div[2]"));
        List<WebElement> liElements = area.findElements(By.tagName("a"));
        //System.out.println(liElements.size());
        for (int i = 0; i < liElements.size(); i++)
        {
            //System.out.println(liElements.get(i).getText());
            if(liElements.get(i).getText().equals(myBookName)){
                System.out.println("Newly added book is listed in catalogue: " + liElements.get(i).getText());
            }
        }
    }
}
