package beauty;

import gmail.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    protected abstract WebDriver getDriver();

    //scroll to specific element
    public void scrollToElement(By by){
        WebElement el = getDriver().findElement(by);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", el);
    }

    public void scrollToElementByPixel(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,800)");
    }

    public WebElement writeInput(By by, String text) {
        WebElement el = getDriver().findElement(by);
        el.sendKeys(text);
        return el;
    }

    public WebElement click(By by) {
        WebElement el = getDriver().findElement(by);
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

        return !getDriver().findElements(by).isEmpty();
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
