package beauty;

import common.GenericTest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.Properties;

import static beauty.Weekday.*;

public class BeautyOnlineTest implements GenericTest {

    static WebDriver driver;
    private String sitelogin = props.getProperty("security.login");
    private String sitepassword = props.getProperty("security.password");
    private String URL = "https://" + sitelogin + ":" + sitepassword  +"@bo.digital-magic.io/";
    private static Properties props = GenericTest.getProperties();

    private static String username = props.getProperty("beauty.gmaillogin");
    private static String password = props.getProperty("beauty.gmailpassword");
    private static String username2 = props.getProperty("beauty.gmaillogin2");
    private static String password2 = props.getProperty("beauty.gmailpassword2");

    @BeforeClass
    public static void SetUp(){
		driver = GenericTest.getDriver();
    }

    @Test
    public void checkProviderFormWithGoogle() {
        driver.get(URL);
        driver.manage().window().maximize();

        new LoginPage(driver)
			.loginGmail(username, password)
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

        new LoginPage(driver).loginGmail(username, password);
		new DashboardServicesPage(driver)
				.services()
				.fillPriceAndDuration("10", "11.50")
				.clickSave()
				.clickWorkingShedule().openingHours("00:00", "06:00");
    }

    @Test
    public void bookingTime() throws InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();
		new LoginPage(driver).loginGmail(username2, password2);
		new SearchPage(driver)
				.searchOnMainPage("toning")
				.clickOnSearchResult()
				.clickToBookService()
				.clickSeeStartTimes()
				.clickBookThisTime()
				.logout();

        driver.get("https://gmail.com");
        Thread.sleep(4000);
        new LoginPage(driver).logoutGmail();

        driver.get(URL);
        new LoginPage(driver).loginGmail(username, password);
        new DashboardIndexPage(driver)
				.clickBookings()
				.verifyIsBooked();
    }


    @Test
    public void checkBadRegistration() {
        driver.get(URL);
        driver.manage().window().maximize();
		new LoginPage(driver).loginGmail(username, password)
            .scrollToForm()
            .fillRegistration("", "", "", "", "", "", 0,"", "", "")
            .clickSkip();
    }

    @Test
    public void checkPrivateMessage(){
        DashboardIndexPage dip = new DashboardIndexPage(driver);
        SearchPage sp = new SearchPage(driver);
        driver.get(URL);
        driver.manage().window().maximize();
        new LoginPage(driver).loginGmail(username2, password2);
        dip.clickHome();
        sp.searchOnMainPage("toning").
            clickOnSearchResult().
            clickSendMessage("Hello, my name is Vitali");

    }
}
