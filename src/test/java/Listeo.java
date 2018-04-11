
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;

public class Listeo {
    static WebDriver driver;
    @BeforeClass
    public static void SetUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    //scroll to specific element
    public static void scrollToElement(WebElement el){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", el);
    }

    //sign up with google RoseP0nyDreamS
    @Test
    public void SignUp() throws InterruptedException {
        driver.get("https://bo.digital-magic.io/");

        WebElement signin = driver.findElement(By.className("sign-in"));
        signin.click();
        Thread.sleep(2000);

        driver.manage().window().maximize();
        WebElement google = driver.findElement(By.cssSelector(".btn-google"));
        google.click();
        Thread.sleep(2000);

        WebElement elLogin = driver.findElement(By.cssSelector("input#identifierId"));
        elLogin.sendKeys("web.xmm@gmail.com");

        WebElement elClick = driver.findElement(By.xpath("//content/span[contains(text(),'Next')]"));
        elClick.click();
        Thread.sleep(3000);

        WebElement elPass = driver.findElement(By.cssSelector("input[name='password']"));
        elPass.sendKeys("Dakota666");

        WebElement elClick2 = driver.findElement(By.xpath("//div[@id='passwordNext']"));
        elClick2.click();
        Thread.sleep(2000);

        //WebElement toEl1 = driver.findElement(By.xpath("//div/form/div/div/div/input[@class=\"ng-touched\"]"));
        WebElement toEl1 = driver.findElement(By.xpath("//div/form/div/div/div/input"));
        scrollToElement(toEl1);
        Thread.sleep(2000);

        WebElement fnameEl = driver.findElement(By.xpath("//div/form/div/div/div/input[@formcontrolname=\"firstName\"]"));
        fnameEl.sendKeys("Test");

        WebElement lnameEl = driver.findElement(By.xpath("//div/form/div/div/div/input[@formcontrolname=\"lastName\"]"));
        lnameEl.sendKeys("Test");

        WebElement emailEl = driver.findElement(By.xpath("//div/form/div/div/div/input[@formcontrolname=\"emailAddress\"]"));
        emailEl.clear();
        emailEl.sendKeys("web.xmm@gmail.com");

        //Pochemu ne rabotaet?
        //String emailaddress = emailEl.getText();
        //System.out.println(emailaddress);
        //assertEquals("web.xmm@gmail.com", emailaddress);

        WebElement phoneEl = driver.findElement(By.xpath("//div/form/div/div/div/input[@formcontrolname=\"phone\"]"));
        phoneEl.sendKeys("58104458");

        WebElement countryEl = driver.findElement(By.xpath("//div/form/div/div/div/select[@formcontrolname=\"countryId\"]"));
        Select countrySelect = new Select(countryEl);
        countrySelect.selectByVisibleText("Estonia");
        Thread.sleep(2000);

        Select countrySelect2 = new Select(countryEl);
        countrySelect2.selectByIndex(0);
        Thread.sleep(2000);

        countrySelect.selectByVisibleText("Estonia");
        Thread.sleep(2000);

        WebElement cityEl = driver.findElement(By.xpath("//div/form/div/div/div/select[@formcontrolname=\"cityId\"]"));
        Select citySelect = new Select(cityEl);
        citySelect.selectByVisibleText("Tallinn");

        WebElement distEl = driver.findElement(By.xpath("//div/form/div/div/div/select[@formcontrolname=\"districtId\"]"));
        Select distSelect = new Select(distEl);
        distSelect.selectByIndex(0);

        WebElement addrEl = driver.findElement(By.xpath("//div/form/div/div/div/input[@formcontrolname=\"address\"]"));
        addrEl.sendKeys("Test Address");

        WebElement zipEl = driver.findElement(By.xpath("//div/form/div/div/div/input[@formcontrolname=\"zipcode\"]"));
        zipEl.sendKeys("12345");

        WebElement langEl = driver.findElement(By.xpath("//div/form/div/div/div/select[@formcontrolname=\"languages\"]"));
        Select langSelect = new Select(langEl);
        //get all list
        langSelect.getOptions(); // not working
        langSelect.selectByVisibleText("English");
        langSelect.selectByVisibleText("Eesti");

        WebElement skipEl = driver.findElement(By.xpath("//div/form/div/div/a[@class='button preview pull-right']"));
        skipEl.click();

        WebElement hairserviEl = driver.findElement(By.xpath("//ul/li[.='Hair service']/span[@class='icon check-icon glyphicon glyphicon-unchecked']"));
        String tmp = hairserviEl.getText();
        System.out.print(tmp);
        hairserviEl.click();
    }
}

//RoseP0nyDreamS
