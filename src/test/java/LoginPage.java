import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LoginPage {
    private final WebDriver driver;
    private final static String gmailUrl = "https://gmail.com";


    //konstruktor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void checkForgot(){
        WebElement we = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/content/span"));
        String value = we.getText();
        assertEquals("Forgot password?", value);
        System.out.print(value);
    }

    public GmailPage login(String login, String password) throws InterruptedException {
        driver.get(gmailUrl);
        //maximize window
        driver.manage().window().maximize();

        if(!driver.findElements(By.cssSelector("input#identifierId")).isEmpty()){
            WebElement elLogin = driver.findElement(By.cssSelector("input#identifierId"));
            elLogin.sendKeys(login);
            WebElement elClick = driver.findElement(By.xpath("//content/span[contains(text(),'Next')]"));
            elClick.click();

        }


        //WebElement elPass = driver.findElement(By.xpath("//div/input[@name='password']"));
        //WebElement elPass = driver.findElement(By.cssSelector("div div div div input"));
        Thread.sleep(2000);
        WebElement elPass = driver.findElement(By.cssSelector("input[name='password']"));
        //String pass = elPass.getTagName();
        //System.out.println(pass);
        //WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        elPass.sendKeys(password);

        WebElement elClick2 = driver.findElement(By.xpath("//div[@id='passwordNext']"));
        elClick2.click();
        Thread.sleep(3000);
        //check page with emails opened
        assertThat(driver.getTitle(), CoreMatchers.containsString("Входящие"));
        System.out.println(driver.getTitle());

        return new GmailPage(driver);
    }
}
