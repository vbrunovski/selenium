package beauty;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ListeoTest extends Page {

    static WebDriver driver;
    private static String URL = "https://beauty:RoseP0nyDreamS@bo.digital-magic.io/";
    private static String username = "web.xmm@gmail.com";
    private static String password = "Dakota777";

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


    @Override
    protected WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\vitali.brunovski\\downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    public RegStep1 loginFacebook(String username, String password){
        return new RegStep1(driver);
    }

    public RegStep1 loginGmail(String username, String password){
        click(signInRegisterBtn);
        sleep(1);
        driver.findElement(login).click();
        sleep(1);
        driver.findElement(btnGoogle).click();
        sleep(1);
        writeInput(googleUsername, username);
        driver.findElement(clickNextBtn).click();
        sleep(2);
        driver.findElement(googlePassword).sendKeys(password);
        driver.findElement(clickNextBtn2).click();
        sleep(2);
        return new RegStep1(driver);

    }

    //RoseP0nyDreamS
    @Test
    public void checkProviderFormWithGoogle() {
        driver.get(URL);
        driver.manage().window().maximize();
        //String authString = new String(Base64.encodeBase64(("beauty" + ":" + "RoseP0nyDreamS").getBytes()));
        regStep4 = loginGmail(username, password)
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
        dsp.Services().fillPriceAndDuration("10", "11.50").clickSave().clickWorkingShedule();
        dwsp.MyShedule("07:00");
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
