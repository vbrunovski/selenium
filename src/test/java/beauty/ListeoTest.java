package beauty;

import common.GenericTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

import static beauty.Weekday.*;

public class ListeoTest extends Page {

    static WebDriver driver;
    private String sitelogin = props.getProperty("security.login");
    private String sitepassword = props.getProperty("security.password");
    private String URL = "https://" + sitelogin + ":" + sitepassword  +"@bo.digital-magic.io/";
    private static Properties props = GenericTest.getProperties();

    private static String username = props.getProperty("beauty.gmaillogin");
    private static String password = props.getProperty("beauty.gmailpassword");
    private static String username2 = props.getProperty("beauty.gmaillogin2");
    private static String password2 = props.getProperty("beauty.gmailpassword2");

    private final By login = By.className("sign-in");
    private final By btnGoogle = By.cssSelector(".btn-google");
    private final By googleUsername = By.cssSelector("input#identifierId");
    private final By signInRegisterBtn = By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[2]/li[1]/a");
    private final By clickNextBtn = By.xpath("//content/span[contains(text(),'Next')]");
    private final By googlePassword = By.cssSelector("input[name='password']");
    private final By clickNextBtn2 = By.xpath("//div[@id='passwordNext']");
    private RegStep4 regStep4;

    DashboardServicesPage dsp = new DashboardServicesPage(driver);
    DashboardWorkingShedulePage dwsp = new DashboardWorkingShedulePage(driver);
    IndexPage ip = new IndexPage(driver);
    SearchResultPage srp = new SearchResultPage(driver);
    ProviderPage pp = new ProviderPage(driver);
    TimeBookingPage tbp = new TimeBookingPage(driver);
    DashboardIndexPage dip = new DashboardIndexPage(driver);
    DashboardBookingsPage dbp = new DashboardBookingsPage(driver);



    @Override
    protected WebDriver getDriver() {
        return driver;
    }


    @BeforeClass
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\vitali.brunovski\\downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.private.browsing.autostart",true);
        driver = new FirefoxDriver();

    }

    public RegStep1 loginFacebook(String username, String password){
        return new RegStep1(driver);
    }

    public RegStep1 loginGmail(String username, String password){
        sleep(1);
        click(signInRegisterBtn);
        sleep(1);
        driver.findElement(login).click();
        sleep(1);
        driver.findElement(btnGoogle).click();
        sleep(1);
        if(isElementVisible(googleUsername) || isElementVisible(googlePassword) ) {
            writeInput(googleUsername, username);
            driver.findElement(clickNextBtn).click();
            sleep(2);
            driver.findElement(googlePassword).sendKeys(password);
            driver.findElement(clickNextBtn2).click();
            sleep(2);
            return new RegStep1(driver);
        }
        else{
            WebElement useAnotherAccountBtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/form/div[2]/div/div/div/ul/li[2]"));
            useAnotherAccountBtn.click();
            sleep(2);
            writeInput(googleUsername, username);
            driver.findElement(clickNextBtn).click();
            sleep(2);
            driver.findElement(googlePassword).sendKeys(password);
            driver.findElement(clickNextBtn2).click();
            sleep(2);
            return new RegStep1(driver);
        }

    }


    public void logoutGmail(){
        WebElement elEl = driver.findElement(By.xpath("//div/div/div/div/div/a/span[@class='gb_db gbii']"));
        elEl.click();
        WebElement logoutEL = driver.findElement(By.xpath("//*[@id=\"gb_71\"]"));
        logoutEL.click();
        sleep(2);
        WebElement el3 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div[1]/div/div/div[2]"));
        el3.click();
        sleep(2);
        WebElement el4 = driver.findElement(By.xpath("//*[@id=\"identifierLink\"]"));
        el4.click();
    }

    //RoseP0nyDreamS
    @Test
    public void checkProviderFormWithGoogle() {
        driver.get(URL);
        driver.manage().window().maximize();
        //String authString = new String(Base64.encodeBase64(("beauty" + ":" + "RoseP0nyDreamS").getBytes()));
        loginGmail(username, password)
            .scrollToForm()
            .fillRegistration("Test", "Test", "web.xmm@gmail.com", "58104459", "Estonia", "Tallinn", 0, "Test Address", "12345", "English", "Eesti")
            .clickSkip()
            .selectFirst3servives()
            .scrollTop()
            .fillPriceAndDuration("10", "11.50")
            .clickSkip()
            .openingHours("00:00", "06:00")
            .clickContinue()
            .imageUpload("test.jpg")
            .finishBtn();
    }

    @Test
    public void checkDashboard(){
        driver.get(URL);
        driver.manage().window().maximize();
        loginGmail(username, password);
        dsp.services().fillPriceAndDuration("10", "11.50").clickSave().clickWorkingShedule();
        //dsp.clickWorkingShedule();
        dwsp.myShedule(Monday, "07:00");
    }

    @Test
    public void bookingTime(){
        driver.get(URL);
        driver.manage().window().maximize();
        loginGmail(username2, password2);
        ip.searchOnMainPage("toning");
        srp.clickOnSearchResult();
        pp.clickToBookService();
        tbp.clickSeeStartTimes();
        tbp.clickBookThisTime();
        tbp.logout();
        driver.get("https://gmail.com");
        sleep(4);
        logoutGmail();
        driver.get(URL);
        loginGmail(username, password);
        dip.clickBookings();
        dbp.verifyIsBooked();

    }


    @Test
    public void checkBadRegistration() {
        driver.get(URL);
        driver.manage().window().maximize();
        loginGmail(username, password)
            .scrollToForm()
            .fillRegistration("", "", "", "", "", "", 0,"", "", "")
            .clickSkip();
    }
}
