package fob;

import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GsmarenaComPhonePage {
    private final WebDriver driver;
    private final By yesGps = By.xpath("//*[@id=\"specs-list\"]/table[10]/tbody/tr[3]/td[2]");

    public GsmarenaComPhonePage(WebDriver driver){
        this.driver = driver;
    }

    public void verifySupportsGps() throws InterruptedException {
        String yes = driver.findElement(yesGps).getText();
        Assert.assertThat(yes, StringContains.containsString("Yes"));
    }
}
