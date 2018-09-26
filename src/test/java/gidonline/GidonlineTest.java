package gidonline;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GidonlineTest {
    static WebDriver driver;
    private final static String URL = "http://gidonline.in";
    HorrorPage hp = new HorrorPage(driver);
    IndexPage ip = new IndexPage(driver);


    @BeforeClass
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testGidonlinePageElements() throws InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();
        hp.clickHorror();
        hp.howManyHorrorFilmsOnPage();

    }

    @Test
    public void testSearchForm(){
        driver.get(URL);
        driver.manage().window().maximize();
        ip.searchFilm("asdsaas");
    }

    @Test
    public void testYearSort(){
        driver.get(URL);
        driver.manage().window().maximize();
        ip.checkYearSort("2017");
    }
}
