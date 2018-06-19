package common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    //scroll to specific element
    public void scrollToElement(By by){
        WebElement el = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", el);
    }

    public void scrollToElementByPixel(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
    }

    public WebElement writeInput(By by, String text) {
        WebElement el = driver.findElement(by);
        el.sendKeys(text);
        return el;
    }

    public WebElement click(By by) {
        WebElement el = driver.findElement(by);
        el.click();
        return el;
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public boolean isElementVisible(By by) {

        return !driver.findElements(by).isEmpty();
    }

   //incognito mode
    protected CharSequence getNewIncognitoWindowCommand() {
        return Keys.chord(Keys.CONTROL, Keys.SHIFT, "p");
    }

    protected final WebElement getKeystrokeTarget(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
    }

    public final void newIncognitoWindow(WebDriver driver) {
        WebElement target = getKeystrokeTarget(driver);
        target.sendKeys(getNewIncognitoWindowCommand());
    }



}
