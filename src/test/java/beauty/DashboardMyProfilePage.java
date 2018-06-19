package beauty;

import ddt.User;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.xml.ws.WebEndpoint;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DashboardMyProfilePage extends Page {

    private final static By firstname = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-profile/div[2]/div[1]/div/div/div[2]/div/app-user-profile/div/form/div/div[2]/div[1]/input");
    private final static By lastname = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-profile/div[2]/div[1]/div/div/div[2]/div/app-user-profile/div/form/div/div[2]/div[2]/input");
    private final static By email = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-profile/div[2]/div[1]/div/div/div[2]/div/app-user-profile/div/form/div/div[3]/div[1]/input");
    private final static By phoneNumber = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-profile/div[2]/div[1]/div/div/div[2]/div/app-user-profile/div/form/div/div[3]/div[2]/input");
    private final static By address = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-profile/div[2]/div[1]/div/div/div[2]/div/app-user-profile/div/form/div/div[5]/div[2]/input");
    private final static By zipCode = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-profile/div[2]/div[1]/div/div/div[2]/div/app-user-profile/div/form/div/div[6]/div[1]/input");
    private final static By country = By.xpath("//*[@id=\"countryDropDown\"]");
    private final static By city = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-profile/div[2]/div[1]/div/div/div[2]/div/app-user-profile/div/form/div/div[4]/div[2]/select");
    private final static By district = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-profile/div[2]/div[1]/div/div/div[2]/div/app-user-profile/div/form/div/div[5]/div[1]/select");
    private final static By lang = By.xpath("/html/body/div/app-root/app-provider-layout/div/div/app-profile/div[2]/div[1]/div/div/div[2]/div/app-user-profile/div/form/div/div[6]/div[2]/select");
    private final static By saveBtn = By.xpath("//*[@id=\"next1\"]");

    public DashboardMyProfilePage(WebDriver driver) {
        super(driver);
    }

    public void clearProfile(){
        WebElement fnameEl = driver.findElement(firstname);
        fnameEl.clear();
        WebElement lnameEl = driver.findElement(lastname);
        lnameEl.clear();
        WebElement emailEl = driver.findElement(email);
        emailEl.clear();
        WebElement phoneNumberEl = driver.findElement(phoneNumber);
        phoneNumberEl.clear();
        WebElement addressEl = driver.findElement(address);
        addressEl.clear();
        WebElement zipCodeEl = driver.findElement(zipCode);
        zipCodeEl.clear();
    }

    public static Collection<UserProfile> testData() {
        return Arrays.asList(
            new UserProfile("Vitali", "", "brunovski.90@gmail.com", "58104459", "Estonia", "Tallinn", "Kesklinn", "Address 12-2", "12345", "Eesti"),
            new UserProfile("Andrei", "Petrov", "petrov91@gmail.com", "51001111", "Estonia", "Tallinn", "Kesklinn", "Address 44-2", "11111", "English"),
            new UserProfile("Semen", "Plahov", "plahov.88@gmail.com", "513319991", "Estonia", "Tallinn", "Pirita", "Address 11-12", "44411", "Eesti")
        );
    }

    public void submitForm(UserProfile userProfile){
        WebElement fnameEl = driver.findElement(firstname);
        //fnameEl.sendKeys(userProfile.firstname);
        writeInput(firstname, userProfile.firstname);

        WebElement lnameEl = driver.findElement(lastname);
        //lnameEl.sendKeys(userProfile.lastname);
        writeInput(lastname, userProfile.lastname);

        WebElement emailEl = driver.findElement(email);
        //emailEl.sendKeys(userProfile.email);
        writeInput(email, userProfile.email);

        WebElement phoneEl = driver.findElement(phoneNumber);
        //phoneEl.sendKeys(userProfile.phoneNumber);

        WebElement addressEl = driver.findElement(address);
        //addressEl.sendKeys(userProfile.address);
        writeInput(address, userProfile.address);

        WebElement zipEl = driver.findElement(zipCode);
        //zipEl.sendKeys(userProfile.zip);
        writeInput(zipCode, userProfile.zip);

        WebElement countryEl = driver.findElement(country);
        countryEl.sendKeys(userProfile.country);
        Select countrySelect = new Select(countryEl);
        countrySelect.selectByVisibleText(userProfile.country);
        sleep(2);

        Select countrySelect2 = new Select(countryEl);
        countrySelect2.selectByIndex(0);
        sleep(2);

        countrySelect.selectByVisibleText(userProfile.country);
        sleep(2);

        WebElement cityEl = driver.findElement(city);
        cityEl.sendKeys(userProfile.city);
        Select citySelect = new Select(cityEl);
        citySelect.selectByVisibleText(userProfile.city);
        sleep(2);

        Select citySelect2 = new Select(cityEl);
        citySelect2.selectByIndex(0);
        sleep(2);

        citySelect.selectByVisibleText(userProfile.city);
        sleep(2);

        WebElement distEl = driver.findElement(district);
        Select distSelect = new Select(distEl);
        distSelect.selectByVisibleText(userProfile.district);

        WebElement langElement = driver.findElement(lang);
        Select langSelect = new Select(langElement);
        //get all list
        //langSelect.getOptions();
        langSelect.deselectAll();
        langSelect.selectByVisibleText(userProfile.lang);

        click(saveBtn);
        sleep(2);


        /*
        if(userProfile.lastname.isEmpty()){
            assertTrue(driver.getPageSource().contains("A name is required!"));
        }
        else{
            assertFalse(driver.getPageSource().contains("A name is required!"));
        }
        */

        getPageSource(userProfile.lastname, "A name is required");

    }

    public void getPageSource(UserProfile userProfile, String text){

        //firstname
        if(userProfile.firstname.isEmpty()){
            assertTrue(driver.getPageSource().contains(text));
        }
        else{
            assertFalse(driver.getPageSource().contains(text));
        }

        //lastname
        if(userProfile.lastname.isEmpty()){
            assertTrue(driver.getPageSource().contains(text));
        }
        else{
            assertFalse(driver.getPageSource().contains(text));
        }
    }
}
