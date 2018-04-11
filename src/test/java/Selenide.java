import com.codeborne.selenide.WebDriverRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;



public class Selenide {

    @BeforeClass
    public static void BeforeAll(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriverRunner.setWebDriver(new ChromeDriver());
    }


    @Test
    public void runWeb(){
        open("http://google.com");
        //proverjaem element
        $(By.id("lst-ib")).should(exist);
        $(By.id("lst-ib")).setValue("Java");

    }

    @Test
    public void GoogleTest(){
        open("http://google.com");
        $(By.id("lst-ib")).setValue("Selenide").pressEnter();

    }
}
