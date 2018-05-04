package restapi;

import beauty.Page;
import common.GenericTest;
import okhttp3.OkHttpClient;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.Properties;
import java.util.Set;

public class test extends Page implements GenericTest {
    private static WebDriver driver;
    private static String URL;
    private static Properties props = GenericTest.getProperties();

    private final By login = By.className("sign-in");
    private final By btnGoogle = By.cssSelector(".btn-google");
    private final By googleUsername = By.cssSelector("input#identifierId");
    private final By signInRegisterBtn = By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[2]/li[1]/a");
    private final By clickNextBtn = By.xpath("//content/span[contains(text(),'Next')]");
    private final By googlePassword = By.cssSelector("input[name='password']");
    private final By clickNextBtn2 = By.xpath("//div[@id='passwordNext']");

    private static String username = props.getProperty("beauty.gmaillogin");
    private static String password = props.getProperty("beauty.gmailpassword");

    private final String baseUrl = "https://bo.digital-magic.io";
    private final OkHttpClient client = new OkHttpClient().newBuilder()
        .followRedirects(false)
        .followSslRedirects(false).build();

    @Override
    protected WebDriver getDriver(){return driver;}

    @BeforeClass
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\vitali.brunovski\\downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.private.browsing.autostart",true);

        String login = props.getProperty("security.login");
        String password = props.getProperty("security.password");
        URL = "https://" + login + ":" + password  +"@bo.digital-magic.io/";
        driver = new FirefoxDriver();
    }

    public Set<Cookie> loginGmail(String username, String password){

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
            sleep(4);
            return driver.manage().getCookies();
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
            sleep(4);
            return driver.manage().getCookies();
        }

    }


    @Test
    public void testAuth() throws Exception {
        driver.get(URL);
        driver.manage().window().maximize();
        Set<Cookie> cookies = loginGmail(username, password);
        System.out.println(cookies);
        /*
        Request request = new Request.Builder()
            .get()
            .url(baseUrl + "/auth/google/authorize?sp=true&dev=false")
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.code() != 303) {
                throw new IllegalArgumentException("Unexpected response status:" + response.code() + "; " + response.body().string());
            }
            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }

            System.out.println(response.body().string());
        }
        */
    }
}
