package gidonline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HorrorPage {
    private final WebDriver driver;
    public HorrorPage(WebDriver driver){
        this.driver = driver;
    }
    private By horrorBlock = By.xpath("//*[@id=\"catline\"]/ul/li[19]/a");

    public void clickHorror(){
        driver.findElement(horrorBlock).click();
    }

    public void howManyHorrorFilmsOnPage(){
        List<WebElement> count = driver.findElements(By.cssSelector("#posts .mainlink"));
        count.size();
        System.out.println(count.size());
    }
}
