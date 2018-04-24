package beauty;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {

    protected abstract WebDriver getDriver();

    //scroll to specific element
    void scrollToElement(By by){
        WebElement el = getDriver().findElement(by);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", el);
    }

    void scrollToElementByPixel(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,800)");
    }

    WebElement writeInput(By by, String text) {
        WebElement el = getDriver().findElement(by);
        el.sendKeys(text);
        return el;
    }

    WebElement click(By by) {
        WebElement el = getDriver().findElement(by);
        el.click();
        return el;
    }

    void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    boolean isElementVisible(By by) {
        return !getDriver().findElements(by).isEmpty();
}
}
