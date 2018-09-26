package beauty;

import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.Assert.fail;

public class RegStep1 extends Page {

    //private final By becomeProviderBtn = By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[2]/li[2]/a");
    //private final By createAccountBtn = By.xpath("//*[@id=\"wrapper\"]/app-root/app-site-layout/div/app-provider-intro/div/div[3]/div/a");
    private final By firstnameForm = By.xpath("//div/form/div/div/div/input[@formcontrolname=\"firstName\"]");
    private final By lastnameForm = By.xpath("//div/form/div/div/div/input[@formcontrolname=\"lastName\"]");
    private final By emailForm = By.xpath("//div/form/div/div/div/input[@formcontrolname=\"emailAddress\"]");
    private final By phoneForm = By.xpath("//div/form/div/div/div/input[@formcontrolname=\"phone\"]");
    private final By countryForm = By.xpath("//div/form/div/div/div/select[@formcontrolname=\"countryId\"]");
    private final By cityForm = By.xpath("//div/form/div/div/div/select[@formcontrolname=\"cityId\"]");
    private final By districtForm = By.xpath("//div/form/div/div/div/select[@formcontrolname=\"districtId\"]");
    private final By addressForm = By.xpath("//div/form/div/div/div/input[@formcontrolname=\"address\"]");
    private final By zipForm = By.xpath("//div/form/div/div/div/input[@formcontrolname=\"zipcode\"]");
    private final By languageForm = By.xpath("/html/body/div[1]/app-root/app-site-layout/div/app-profile-steps/div[2]/div[2]/div[1]/div/div[2]/app-user-profile/div/form/div/div[6]/div[2]/mat-select/div/div[1]/span");
    private final By saveBtn = By.cssSelector("#next1");
    private final By myProfile = By.xpath("/html/body/div/app-root/app-provider-layout/div/app-left-nav/div/div/ul[3]/li[1]/a");
    private final By becomeProviderBtn = By.xpath("/html/body/div/app-root/app-site-layout/app-site-header/header/div/div/nav/div/div[2]/ul[2]/li[2]/a");
    private final By clickToBg = By.xpath("/html/body/div[1]/app-root/app-site-layout/div/app-profile-steps/div[2]/div[2]/div[1]/div/div[2]/app-user-profile/div/form/div/div[5]/div[2]/label");
    private final By englishElement = By.xpath("/html/body/div[2]/div[2]/div/div/mat-option[1]/mat-pseudo-checkbox");

    public RegStep1(WebDriver driver) {
        super(driver);
    }

    RegStep1 scrollToForm() {
        //click(myProfile);
        scrollToElement(By.xpath("/html/body/div/app-root/app-site-layout/div/app-profile-steps/div[2]/div[2]/div[1]/div/div[2]/app-user-profile/div/form/div/div[1]/h3"));
        sleep(2);
        return this;
    }

    RegStep1 becomeProvider(){
        //click(becomeProviderBtn);
        sleep(2);
        return this;
    }

    RegStep2 clickSkip() {
        click(saveBtn);
        return new RegStep2(driver);
    }

    RegStep1 fillRegistration(String firstName, String lastName, String email, String phone, String country, String city, String district, String address, String zip, String ... languages) {
        driver.findElement(firstnameForm).sendKeys(firstName);
        driver.findElement(lastnameForm).sendKeys(lastName);
        WebElement emailElement = driver.findElement(emailForm);
        emailElement.clear();
        emailElement.sendKeys(email);

        driver.findElement(phoneForm).sendKeys(phone);

        WebElement countryElement = driver.findElement(countryForm);
        Select countrySelect = new Select(countryElement);
        countrySelect.selectByVisibleText(country);
        sleep(2);
        countrySelect.selectByIndex(0);
        sleep(2);
        countrySelect.selectByVisibleText(country);
        sleep(2);

        WebElement cityElement = driver.findElement(cityForm);
        Select citySelect = new Select(cityElement);
        citySelect.selectByVisibleText(city);
        sleep(2);
        citySelect.selectByIndex(0);
        sleep(2);
        citySelect.selectByVisibleText(city);

        WebElement distElement = driver.findElement(districtForm);
        Select distSelect = new Select(distElement);
        distSelect.selectByVisibleText(district);

        driver.findElement(addressForm).sendKeys(address);
        driver.findElement(zipForm).sendKeys(zip);

        WebElement langElement = driver.findElement(languageForm);
        langElement.click();

        WebElement englishLang = driver.findElement(englishElement);
        englishLang.click();

        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_ESCAPE);

        } catch (AWTException e) {
            e.printStackTrace();
            fail(e.getMessage());

        }

        //WebElement langElement = driver.findElement(languageForm);
        //langElement.click();

        //Select langSelect = new Select(langElement);
        //get all list
        //langSelect.getOptions(); // not working
        //for (String lang: languages) {
           // langSelect.selectByVisibleText(lang);
        //}
        return this;
    }
}
