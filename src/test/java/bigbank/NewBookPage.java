package bigbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewBookPage {
    private final WebDriver driver;
    private final static String URL = "https://raamatukogu.herokuapp.com/catalog/book/create";
    private final By titleField = By.xpath("//*[@id=\"title\"]");
    private final By summaryField = By.xpath("//*[@id=\"summary\"]");
    private final By isbnField = By.xpath("//*[@id=\"isbn\"]");
    private final By submitBtn = By.xpath("/html/body/div/div/div[2]/form/button");

    public static String myBookName = "MyBookName01";

    public NewBookPage(WebDriver driver){
        this.driver = driver;
    }

    public void addNewBook() throws InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement title = driver.findElement(titleField);
        title.sendKeys(myBookName);

        Select author = new Select(driver.findElement(By.xpath("//*[@id=\"author\"]")));
        author.selectByIndex(2);

        WebElement summary = driver.findElement(summaryField);
        summary.sendKeys("MySummary");

        WebElement isbn = driver.findElement(isbnField);
        isbn.sendKeys("MyISBN");

        driver.findElement(By.xpath("//*[@id=\"5b6714c93809970014e31c9a\"]")).click();

        driver.findElement(submitBtn).click();
    }

}
