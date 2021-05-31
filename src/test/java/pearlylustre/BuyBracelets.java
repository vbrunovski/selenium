package pearlylustre;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuyBracelets {
    private final WebDriver driver;
    public BuyBracelets(WebDriver driver){
        this.driver = driver;
    }
    private By braceletsLink = By.xpath("//*[@id=\"shopify-section-static-header\"]/header/section/nav/ul/li[5]/a");
    private By addToCartBtn = By.xpath("//*[@id=\"5101065994379\"]/button");
    private By viewCartBtn = By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[2]/a");
    private By selectItem = By.xpath("//*[@id=\"shopify-section-static-collection\"]/div/main/div/div[2]/ul/li[1]/div/figure/a[1]");
    private By checkOutBtn = By.xpath("//*[@id=\"shopify-section-static-cart\"]/section/form/div/div[2]/div/button");
    private By continueShippingBtn = By.xpath("//*[@id=\"continue_button\"]");

    public void clickBracelets(){

        driver.findElement(braceletsLink).click();
    }

    public void clickAddToCart() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"shopify-section-static-collection\"]/div/main/div/div[2]/ul/li[1]/div/div[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(5000);
        driver.findElement(selectItem).click();
        Thread.sleep(4000);
        driver.findElement(addToCartBtn).click();
    }

    public void clickViewCart(){
        driver.findElement(viewCartBtn).click();
    }

    public void clickCheckOut(){
        driver.findElement(checkOutBtn).click();
    }

    public void fillInTheForm(){
        driver.findElement(By.xpath("//*[@id=\"checkout_email_or_phone\"]")).sendKeys("test@mail.com");
        driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_first_name\"]")).sendKeys("John");
        driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_last_name\"]")).sendKeys("Smith");
        driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_company\"]")).sendKeys("My Company Name");
        driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_address1\"]")).sendKeys("Some address 11-1");
        driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_address2\"]")).sendKeys("Some apartment");
        driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_zip\"]")).sendKeys("1010101");
        driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_city\"]")).sendKeys("London");
        driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_phone\"]")).sendKeys("5910101010");


        driver.findElement(continueShippingBtn).click();
    }

}
