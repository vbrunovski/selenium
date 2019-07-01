package bigbank;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LibraryTestsHTML extends JUnitHTMLReporter {
    static WebDriver driver;
    NewBookPage nbp = new NewBookPage(driver);
    CatalogBookPage cbp = new CatalogBookPage(driver);

    @BeforeClass
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void TestName() throws InterruptedException {
        nbp.addNewBook();
        cbp.VerifyBookInList();
    }
}
