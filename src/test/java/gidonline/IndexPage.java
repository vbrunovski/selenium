package gidonline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class IndexPage {
    private final WebDriver driver;
    public IndexPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchFilm(String filmName){
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"s\"]"));
        searchInput.sendKeys(filmName);
        driver.findElement(By.xpath("//*[@id=\"btnSearch\"]")).click();

        List<WebElement> count = driver.findElements(By.cssSelector("#posts .mainlink"));
        count.size();
        if(count.size()>0){
            System.out.println("Фильм найден - " + "количество: " + count.size());
        }
        else{
            System.out.println("Фильмов с названием " + filmName + " не найдено");
        }
    }


    public void checkYearSort(String year){
        driver.findElement(By.xpath("//*[@id=\"year-dropdown\"]")).click();
        Select drpYear = new Select(driver.findElement(By.name("year-dropdown")));
        drpYear.selectByVisibleText(year);

        //verify that 2017
        WebElement yearNr = driver.findElement(By.className("mqn"));
        String yearNrText = yearNr.getText();
        assertEquals(year, yearNrText);
        System.out.println(yearNrText);
    }
}
