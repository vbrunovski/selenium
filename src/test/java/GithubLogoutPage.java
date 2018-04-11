import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class GithubLogoutPage {

    private final WebDriver driver;
    private By clickImg = By.xpath("//*[@id=\"user-links\"]/li[3]/details/summary/img");
    private By clickSignoutButton = By.xpath("//*[@id=\"user-links\"]/li[3]/details/ul/li[9]/form/button");
    private By userLoggedText = By.xpath("//*[@id=\"js-pjax-container\"]/div[1]/div/div/h2");

    public GithubLogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmThatUserLogged(){
        driver.findElement(userLoggedText);
        String text = driver.findElement(userLoggedText).getText();
        assertEquals("Learn Git and GitHub without any code!", text);
        System.out.println(text);
    }

    public void clickSignOut() throws InterruptedException {
        driver.findElement(clickImg).click();
        Thread.sleep(1000);
        driver.findElement(clickSignoutButton).click();
    }


}
