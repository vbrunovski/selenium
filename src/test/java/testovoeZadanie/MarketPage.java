package testovoeZadanie;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class MarketPage extends Functions {

    @Override
    protected WebDriver getDriver(){
        return driver;
    }

    private final WebDriver driver;
    private final By mobileSection = By.xpath("/html/body/div[1]/div/div[2]/noindex/ul/li[1]/div/div/a[1]");
    private final By priceEnd = By.xpath("//*[@id=\"glpriceto\"]");
    private final By scrollToEl1 = By.xpath("//*[@id=\"search-prepack\"]/div/div/div[2]/div/div[1]/div[10]/fieldset/legend");
    private final By screenSize = By.xpath("//*[@id=\"search-prepack\"]/div/div/div[2]/div/div[1]/div[10]/fieldset/ul/li[5]/div/label/div");
    private final By scrollToEl2 = By.xpath("//*[@id=\"search-prepack\"]/div/div/div[2]/div/div[1]/div[4]/fieldset/legend");
    private final By appleDevice = By.xpath("//*[@id=\"search-prepack\"]/div/div/div[2]/div/div[1]/div[4]/fieldset/ul/li[1]/div/a/label/div");
    private final By asusDevice = By.xpath("//*[@id=\"search-prepack\"]/div/div/div[2]/div/div[1]/div[4]/fieldset/ul/li[2]/div/a/label/div");
    private final By honorDevice = By.xpath("//*[@id=\"search-prepack\"]/div/div/div[2]/div/div[1]/div[4]/fieldset/ul/li[3]/div/a/label/div");
    private final By huaweiDevice = By.xpath("//*[@id=\"search-prepack\"]/div/div/div[2]/div/div[1]/div[4]/fieldset/ul/li[4]/div/a/label/div");
    private final By lgDevice = By.xpath("//*[@id=\"search-prepack\"]/div/div/div[2]/div/div[1]/div[4]/fieldset/ul/li[5]/div/a/label/div");
    private final By scrollToDown = By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[2]/div[1]/a");
    private final By elementCountText = By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/button/span");
    private final By sortByNew = By.xpath("/html/body/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[7]/a");


    public MarketPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickToMobileSection() throws InterruptedException {
        Thread.sleep(1000);
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.linkText("Электроника"));
        builder.moveToElement(element).build().perform();
        Thread.sleep(1000);
        driver.findElement(mobileSection).click();
    }

    public void clickToPriceRange() throws InterruptedException {
        driver.findElement(priceEnd).sendKeys("80000");
        scrollToElement(scrollToEl1);
        driver.findElement(screenSize).click();
        scrollToElement(scrollToEl2);

        driver.findElement(appleDevice).click();
        driver.findElement(asusDevice).click();
        driver.findElement(honorDevice).click();
        driver.findElement(huaweiDevice).click();
        driver.findElement(lgDevice).click();

        Thread.sleep(1000);
    }

    public void checkElementCount(){
        scrollToElement(scrollToDown);
        WebElement el = driver.findElement(elementCountText);
        String text = el.getText();
        System.out.println(text);
    }

    public void checkElementsCount(){
        List<WebElement> count = driver.findElements(By.className("n-snippet-cell2_type_product"));
        count.size();
        System.out.println(count.size());
        if(count.size()>10){
            System.out.println("Количество элементов больше 10");
        }
    }

    public void saveFirstElementProduct(){
        //WebElement firstElement = driver.findElement(By.xpath("//*[@data-id='model-43052347']"));
        WebElement firstElement = driver.findElement(By.linkText("Смартфон Honor 10 4/64GB"));
        System.out.println(firstElement);
    }

    public void changeSort(){
        driver.findElement(sortByNew).click();
    }

    public void clickOnFirstElementProduct() throws InterruptedException {
        WebElement elementToScroll = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[1]/div[9]"));
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementToScroll);
        Thread.sleep(2000);
        driver.findElement(By.linkText("Смартфон Honor 10 4/64GB")).click();
        //driver.findElement(By.xpath("//*[@data-id='model-43052347']")).click();
    }
}
