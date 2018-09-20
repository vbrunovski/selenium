package beauty;

import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {

	private final By login = By.className("sign-in");
	private final By btnGoogle = By.cssSelector(".btn-google");
	private final By googleUsername = By.cssSelector("input#identifierId");
	private final By signInRegisterBtn = By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[2]/li[1]/a");
	private final By clickNextBtn = By.xpath("//content/span[contains(text(),'Далее')]");
	//private final By clickNextBtn = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/content/span");
	private final By googlePassword = By.cssSelector("input[name='password']");
	private final By clickNextBtn2 = By.xpath("//div[@id='passwordNext']");


	public LoginPage(WebDriver driver) {
		super(driver);
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
			WebElement useAnotherAccountBtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/div/form/content/section/div/content/div/div/ul/li[2]"));
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
		WebElement elEl = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[4]/header/div[2]/div[3]/div/div[2]/div/a"));
		elEl.click();
		WebElement logoutEL = driver.findElement(By.xpath("//*[@id=\"gb_71\"]"));
		logoutEL.click();
		sleep(2);

		//WebElement el3 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[1]/content/div/div/div[2]/div"));
		//el3.click();
		//sleep(2);
		//WebElement el4 = driver.findElement(By.xpath("//*[@id=\"identifierLink\"]"));
		//el4.click();
	}



}
