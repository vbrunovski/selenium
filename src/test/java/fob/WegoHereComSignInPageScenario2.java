package fob;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WegoHereComSignInPageScenario2 {
    private final WebDriver driver;
    private final By emailField = By.xpath("//*[@id=\"sign-in-email\"]");
    private final By passwordField = By.xpath("//*[@id=\"sign-in-password-encrypted\"]");
    private final By frameLocator = By.xpath("//*[@id=\"here-account-sdk\"]");
    private final By loginBtn = By.xpath("//*[@id=\"signInBtn\"]");
    private final By collectStarIcon = By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[1]/div[3]/div/div[3]");
    private final By doneBtn = By.xpath("/html/body/div[1]/div[7]/div/div/div/div[2]/button[2]");
    private final By menu = By.xpath("//*[@id=\"searchbar\"]/div/div/button[1]");
    private final By collectionLink = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[1]/div[3]");
    private final By titleLink = By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[2]/div/div");
    private final By collectedCity = By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[2]/div/section/section/div/a/div[2]/h4");

    public WegoHereComSignInPageScenario2(WebDriver driver){
        this.driver = driver;
    }

    public void login() throws InterruptedException, IOException {
        Properties prop = new Properties();
        String path = "./src/test/java/fob/data.properties";
        prop.load(new FileInputStream(path));
        String emailProp = prop.getProperty("email");
        String passwordProp = prop.getProperty("password");
        driver.switchTo().frame(driver.findElement(frameLocator));
        WebElement email = driver.findElement(emailField);
        email.sendKeys(emailProp);
        WebElement password = driver.findElement(passwordField);
        password.sendKeys(passwordProp);
        driver.findElement(loginBtn).click();
        Thread.sleep(2000);
    }

    public void clickCollect() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(collectStarIcon));
        driver.findElement(collectStarIcon).click();
        //Thread.sleep(2000);
    }

    public void clickDone() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(doneBtn));
        driver.findElement(doneBtn).click();
    }

    public void clickMenu(){
        driver.findElement(menu).click();
    }

    public void clickCollections(){
        driver.findElement(collectionLink).click();
    }

    public void clickTitle() throws InterruptedException {
        driver.findElement(titleLink).click();
    }

    public void verifyCollected(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(collectedCity));
        WegoHereComIndexPageScenario1 loc = new WegoHereComIndexPageScenario1(driver);
        String city = driver.findElement(collectedCity).getText();
        try {
            Assert.assertEquals(city, loc.getLocation());
            System.out.println("Collected place exists. City is matched. " + "Expected: " + city + " Actual: " + loc.getLocation());
        }
        catch(AssertionError e){
            System.out.println("Collected place is not exists. City does not matched. " + "Expected: " + city + " Actual: " + loc.getLocation());
            throw e;
        }
    }

}
