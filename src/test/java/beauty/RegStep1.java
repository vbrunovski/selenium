package beauty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegStep1 extends Page {

    private final WebDriver driver;

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
    private final By languageForm = By.xpath("//div/form/div/div/div/select[@formcontrolname=\"languages\"]");
    private final By skipBtn = By.xpath("//div/form/div/div/a[@class='button preview pull-right']");

    public RegStep1(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    WebDriver getDriver() {
        return driver;
    }

    RegStep1 scrollToForm() {
        scrollToElement(By.xpath("//div/form/div/div/div/input"));
        sleep(2);
        return this;
    }

    RegStep2 clickSkip() {
        click(skipBtn);
        return new RegStep2(driver);
    }

    RegStep1 fillRegistration(String firstName, String lastName, String email, String phone, String country, String city, int districtIndex, String address, String zip, String ... languages) {
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

        Select countrySelect2 = new Select(countryElement);
        countrySelect2.selectByIndex(0);
        sleep(2);

        countrySelect.selectByVisibleText(country);
        sleep(2);

        WebElement cityElement = driver.findElement(cityForm);
        Select citySelect = new Select(cityElement);
        citySelect.selectByVisibleText(city);

        WebElement distElement = driver.findElement(districtForm);
        Select distSelect = new Select(distElement);
        distSelect.selectByIndex(districtIndex);

        driver.findElement(addressForm).sendKeys(address);
        driver.findElement(zipForm).sendKeys(zip);

        WebElement langElement = driver.findElement(languageForm);
        Select langSelect = new Select(langElement);
        //get all list
        langSelect.getOptions(); // not working
        for (String lang: languages) {
            langSelect.selectByVisibleText(lang);
        }
        return this;
    }
}
