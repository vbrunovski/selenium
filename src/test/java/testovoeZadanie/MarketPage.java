package testovoeZadanie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MarketPage extends Functions {

    @Override
    protected WebDriver getDriver(){
        return driver;
    }

    private final WebDriver driver;
    private final By mobileSection = By.xpath("/html/body/div[1]/div[2]/noindex/ul/li[1]/div/div/a[1]");
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
}
