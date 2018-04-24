package testovoeZadanie;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Functions {
    protected abstract WebDriver getDriver();

    //scroll to specific element
    void scrollToElement(By by){
        WebElement el = getDriver().findElement(by);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", el);
    }
}
