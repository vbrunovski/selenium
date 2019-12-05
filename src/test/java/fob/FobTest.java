package fob;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FobTest {
    static WebDriver driver;
    private final static String URL = "https://wego.here.com";
    private final static String URL2 = "https://gsmarena.com";


    WegoHereComIndexPageScenario1 scen1Index = new WegoHereComIndexPageScenario1(driver);
    WegoHereComDrivePageScenario1 scen1Drive = new WegoHereComDrivePageScenario1(driver);
    WegoHereComPublicPageScenario1 scen1Public = new WegoHereComPublicPageScenario1(driver);
    WegoHereComBikePageScenario1 scen1Bike = new WegoHereComBikePageScenario1(driver);
    WegoHereComCarsharingPageScenario1 scen1Cars = new WegoHereComCarsharingPageScenario1(driver);

    WegoHereComIndexPageScenario2 scen2Index = new WegoHereComIndexPageScenario2(driver);
    WegoHereComSignInPageScenario2 scen2Signin = new WegoHereComSignInPageScenario2(driver);

    GsmarenaComIndexPage ind = new GsmarenaComIndexPage(driver);
    GsmarenaComCategoryPage cat = new GsmarenaComCategoryPage(driver);
    GsmarenaComPhonePage pho = new GsmarenaComPhonePage(driver);


    @BeforeClass
    public static void setUp() throws IOException {
        Properties prop = new Properties();
        String path = "./src/test/java/fob/driverpath.properties";
        prop.load(new FileInputStream(path));
        String chromePath = prop.getProperty("path");
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
    }

    @Test
    public void routeTest() throws InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();
        scen1Index.createRoute();
        scen1Drive.clickDrive();
        scen1Drive.verifyDriveCalculated();
        scen1Public.clickPublic();
        scen1Public.verifyPublicCalculated();
        scen1Bike.clickBike();
        scen1Bike.verifyBikeCalculated();
        scen1Cars.clickCarshering();
        scen1Cars.verifyCarsheringCalculated();
    }

    @Test
    public void collectTest() throws InterruptedException, IOException {
        driver.get(URL);
        driver.manage().window().maximize();
        scen2Index.signIn();
        scen2Signin.login();
        scen1Index.createRoute();
        scen2Signin.clickCollect();
        scen2Signin.clickDone();
        scen2Signin.clickMenu();
        scen2Signin.clickCollections();
        scen2Signin.clickTitle();
        scen2Signin.verifyCollected();
    }

    @Test
    public void gpsTest() throws InterruptedException {
        driver.get(URL2);
        driver.manage().window().maximize();
        ind.searchMobileCategory();
        cat.okCookie();
        cat.searchMobilePhone();
        pho.verifySupportsGps();

    }

    //@AfterClass
    //public static void tearDown(){
      //  driver.quit();
    //}
}
