package beauty;

import ddt.User;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


/*
import javax.xml.ws.WebEndpoint;
 */
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
    private final static By lang = By.xpath("//*[@id=\"mat-select-1\"]");
    private final static By saveBtn = By.xpath("//*[@id=\"next1\"]");
    private final static By userNameBtn = By.xpath("/html/body/div/app-root/app-site-layout/app-site-header/header/div/div/nav/div/div[2]/ul[2]/li[1]/a");
    private final static By dashboardBtn = By.xpath("/html/body/div/app-root/app-site-layout/app-site-header/header/div/div/nav/div/div[2]/ul[2]/li[1]/ul/li[3]/a");


    public DashboardMyProfilePage(WebDriver driver) {
        super(driver);
    }



    public void clearProfile(){
        clearInput(firstname);
        clearInput(lastname);
        clearInput(email);
        clearInput(phoneNumber);
        clearInput(address);
        clearInput(zipCode);

    }

    public static Collection<UserProfile> testData() {
        return Arrays.asList(
            new UserProfile("", "Brunovski", "brunovski.90@gmail.com", "58104459", "Estonia", "Tallinn", "Kesklinn", "Address 12-2", "12345", "Eesti"),
            new UserProfile("Andrei", "", "", "51001111", "Estonia", "Tallinn", "Kesklinn", "Address 44-2", "11111", "English"),
            new UserProfile("Semen", "Plahov", "", "8887788", "Estonia", "Tallinn", "Pirita", "Address 11-12", "44411", "Eesti"),
            new UserProfile("Semen", "Plahov", "asd@asd.com", "", "Estonia", "Tallinn", "Pirita", "Address 11-12", "44411", "Eesti"),
            new UserProfile("Semen", "Plahov", "asd@asd.com", "8887788", "", "Tallinn", "Pirita", "Address 11-12", "44411", "Eesti"),
            new UserProfile("Semen", "Plahov", "asd@asd.com", "8887788", "Estonia", "", "Pirita", "Address 11-12", "44411", "Eesti"),
            new UserProfile("Semen", "Plahov", "asd@asd.com", "8887788", "Estonia", "Tallinn", "", "Address 11-12", "44411", "Eesti"),
            new UserProfile("Semen", "Plahov", "asd@asd.com", "8887788", "Estonia", "Tallinn", "Pirita", "", "44411", "Eesti"),
            new UserProfile("Semen", "Plahov", "asd@asd.com", "8887788", "Estonia", "Tallinn", "Pirita", "Address 11-12", "", "Eesti")
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
        writeInput(phoneNumber, userProfile.phoneNumber);

        WebElement addressEl = driver.findElement(address);
        //addressEl.sendKeys(userProfile.address);
        writeInput(address, userProfile.address);

        WebElement zipEl = driver.findElement(zipCode);
        //zipEl.sendKeys(userProfile.zip);
        writeInput(zipCode, userProfile.zip);

        WebElement countryEl = driver.findElement(country);
        countryEl.sendKeys(userProfile.country);
        Select countrySelect = new Select(countryEl);

        if(userProfile.country.isEmpty()){
            selectFirstElement(country);
        }
        else {
            countrySelect.selectByVisibleText(userProfile.country);
        }
        sleep(2);

        Select countrySelect2 = new Select(countryEl);
        countrySelect2.selectByIndex(0);
        sleep(2);

        countrySelect.selectByVisibleText(userProfile.country);
        sleep(2);

        WebElement cityEl = driver.findElement(city);
        cityEl.sendKeys(userProfile.city);
        Select citySelect = new Select(cityEl);
        if(userProfile.city.isEmpty()){
            selectFirstElement(city);
        }
        else {
            citySelect.selectByVisibleText(userProfile.city);
        }
        sleep(2);

        Select citySelect2 = new Select(cityEl);
        citySelect2.selectByIndex(0);
        sleep(2);

        citySelect.selectByVisibleText(userProfile.city);
        sleep(2);

        WebElement distEl = driver.findElement(district);
        Select distSelect = new Select(distEl);
        if(userProfile.district.isEmpty()){
            selectFirstElement(city);
        }
        else {
            distSelect.selectByVisibleText(userProfile.district);
        }

        WebElement langElement = driver.findElement(lang);
        langElement.click();
        WebElement elementEnglish = driver.findElement(By.xpath("//*[@id=\"mat-option-3\"]"));
        elementEnglish.click();
        //Select langSelect = new Select(langElement);
        //get all list
        //langSelect.getOptions();
        //langSelect.deselectAll();
        //langSelect.selectByVisibleText(userProfile.lang);

        //click(saveBtn);
        //sleep(2);

        validateField(userProfile.firstname, "A name is required!", firstname);
        validateField(userProfile.lastname, "A name is required!", lastname);
        validateField(userProfile.email, "Invalid email!", email);
        validateField(userProfile.phoneNumber, "Invalid phone!", phoneNumber);
        validateField(userProfile.zip, "Invalid zip code!", zipCode);

    }

    private void validateField(String value, String errorText, By by) {
        if (value.isEmpty()){
            assertTrue(checkTextFound(by, errorText));
        }  else{
            assertFalse(checkTextFound(by, errorText));
        }
    }

    private boolean checkTextFound(By by, String text) {
        return driver.findElement(by).findElement(By.xpath("..")).getText().contains(text);
    }

    public void clickDashBoard(){
        click(userNameBtn);
        sleep(1);
        click(dashboardBtn);
    }
}
