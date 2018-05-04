package test1;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.hamcrest.CoreMatchers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DevClubTest {

	static String baseUrl = "http://www.devclub.eu/";
	static String url2 = "https://whois.net";
	static String whoisDomainName = "petromaks.ee";
	static String domain1a = "http://1a.ee/ru";
	static WebDriver driver;
	static String gmailUrl = "http://gmail.com";
	static String gmailLogin = "web.xmm@gmail.com";
	static String gmailPassword = "asdasd";

	@BeforeClass
	public static void preTest() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void afterTest() {
		//driver.quit();
	}

	@Test
	public void test1(){
		driver.get("http://petromaks.ee");
		List<WebElement> elements = driver.findElements(By.className("alignnone"));
		System.out.print(elements);


	}




	@Test
	public void gmailLogin() throws InterruptedException{
		driver.get(gmailUrl);
		//maximize window
		driver.manage().window().maximize();
		WebElement elLogin = driver.findElement(By.cssSelector("input#identifierId"));
		elLogin.sendKeys(gmailLogin);
		WebElement elClick = driver.findElement(By.xpath("//content/span[contains(text(),'Next')]"));
		elClick.click();

		//WebElement elPass = driver.findElement(By.xpath("//div/input[@name='password']"));
		//WebElement elPass = driver.findElement(By.cssSelector("div div div div input"));
		Thread.sleep(2000);
		WebElement elPass = driver.findElement(By.cssSelector("input[name='password']"));
		//String pass = elPass.getTagName();
		//System.out.println(pass);
		//WebDriverWait wait = new WebDriverWait(driver, 5);

		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		elPass.sendKeys(gmailPassword);

		WebElement elClick2 = driver.findElement(By.xpath("//div[@id='passwordNext']"));
		elClick2.click();

		WebElement elEl = driver.findElement(By.xpath("//div/div/a/span"));
		elEl.click();

		WebElement elEmail = driver.findElement(By.xpath("//div/div/div[@class='gb_Ib']"));
		String email = elEmail.getText();
		assertEquals(gmailLogin, email);
	}

	@Test
	public void oneA() throws InterruptedException {
			//launch browser
			driver.get(domain1a);


			//find reg button and click on it
			WebElement elToEnd = driver.findElement(By.cssSelector(".ait-index-product-photo"));
			WebElement el = driver.findElement(By.linkText("Контакты"));
			String regText = el.getText();
			System.out.println(regText);
			Thread.sleep(2000);
			//JavascriptExecutor jse = (JavascriptExecutor)driver;
			//jse.executeScript("window.scrollBy(0,1050)", "");
			driver.manage().window().maximize();


			//ne rabotaet isDisplayed()
			if(el.isSelected()){
				el.click();
				System.out.println("Element is visible");
			}
			else {
				//scroll down to the specific element
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", el);
				el.click();
				System.out.println("Element is NOT visible");
			}



		    //click button

			//delay 10 sec to display HTML
			//Thread.sleep(10000);
			//WebElement elContactEmail = driver.findElement(By.xpath("/html/body/#page/div/div/div/div/div/div/div/ul/ul/li/a.mail"));
			WebElement elContactEmail = driver.findElement(By.cssSelector("a.mail"));
			String contactEmail = elContactEmail.getText();
			System.out.println(contactEmail);


	}






	@Test
	public void OneACat() throws InterruptedException{
		driver.get(domain1a);
		driver.manage().window().maximize();
		WebElement el1 = driver.findElement(By.linkText("Мобильные телефоны и смартфоны"));
		el1.click();
		WebElement el3 = driver.findElement(By.cssSelector(".select-opener"));
		el3.click();
		WebElement el4 = driver.findElement(By.cssSelector(".drop-list ul li a span"));
		el4.click();
        Thread.sleep(5000);
        //zapixivaem vse ceny v spisok List
		List<WebElement> wl = driver.findElements(By.cssSelector("div.price-v2  "));
		// Podaem na vhod e (ljubamaja peremennaja) i preobrazuem ee v cifry, to est preobrazuem WebElement v BigDecimal
		List<BigDecimal> prices = wl.stream().map(e -> new BigDecimal(e.getAttribute("data-sell-price-w-vat"))).collect(Collectors.toList());
		//Price - tekushij element element, Last - predidushij
		BigDecimal last = null;
		for (BigDecimal price : prices) {
		    if (last != null) {
		        assertTrue("Sorting is incorrect: " + last + " < " + price, last.compareTo(price) <= 0);
            }
            last = price;
        }




		/*
		WebElement elForm = driver.findElement(By.cssSelector(".click-desk-bar-text"));
		elForm.click();
		WebElement elName = driver.findElement(By.id("cd_offline_name"));
		elName.sendKeys("Vitali");
		WebElement elEmail = driver.findElement(By.id("cd_offline_email"));
		elEmail.sendKeys("web.xmm@gmail.com");
		WebElement elMsg = driver.findElement(By.id("cd_offline_msg"));
		elMsg.sendKeys("Hello, World");
		WebElement elSubmit = driver.findElement(By.id("cd_offline_button"));
		elSubmit.click();
		*/


		// Kak sravnit 2 ceny ?
		/*
		WebElement el2 = driver.findElement(By.cssSelector(".jcf-class-jcf-checkbox.chk-area.chk-unchecked"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", el2);

		if ( !driver.findElement(By.cssSelector(".jcf-class-jcf-checkbox.chk-area.chk-unchecked")).isSelected() )
		{
			//click checkbox
			el2.click();
		}
		*/
	}


	@Test
	public void whoIsNet(){
		//zaderzka 5 sekund
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//zapuskaem brauzer
		driver.get(url2);
		String title = driver.getTitle();
		String currentUrl = driver.getCurrentUrl();
		String pageSource = driver.getPageSource();
		System.out.println("Title: " + title + "Current URL " + currentUrl);
		//System.out.println(pageSource);
		WebElement textHeading = driver.findElement(By.tagName("h1"));
		String textHeading2 = textHeading.getText();
		System.out.println(textHeading2);
		assertEquals("Your Domain Starting Place...", textHeading2);

		//get img
		WebElement wImg = driver.findElement(By.cssSelector("div#home_search_div header img"));
		String wImg2 = wImg.getTagName();
		System.out.println(wImg2);
		String imgName = wImg.getAttribute("src");
		System.out.println(imgName);
		assertEquals("https://whois.net/images/home/whois.png", imgName);

		//vvod znacheniya v poiskovoe pole
		WebElement search = driver.findElement(By.cssSelector("#searchBox table tbody tr td input"));
		assertEquals("input", search.getTagName());

		search.sendKeys(whoisDomainName);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = \"DEVCLUB#115\"]")));
		//
		try {
			//WebElement registerButton = driver.findElement(By.xpath("//a[href() = \"javascript:doDmainSearch()\"]"));
			WebElement registerButton = driver.findElement(By.cssSelector("#domain_search + a"));
			registerButton.click();
			Thread.sleep(10000);
			WebElement domainRegistered = driver.findElement(By.cssSelector("h2.unAvl"));
			String domainRegistered2 = domainRegistered.getText();
			System.out.println(domainRegistered2);
			assertEquals(whoisDomainName +" is already registered", domainRegistered2);


		}
		catch(Exception e){
			System.out.println(e);
		}


		//WebElement domain = driver.findElement(By.className("unAvl"));
		//String domain2 = domain.getText();
		//System.out.println(domain2);

	}

	@Test
	public void testHome() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseUrl);
		String title = driver.getTitle();
		WebElement nextSession = driver.findElement(By.cssSelector("div.ng-scope h3"));
		String headingText = nextSession.getText();

		assertEquals("DevClub", title);
		assertEquals("Встреча #115", headingText);
	}

	private void switchToNewWindow() {
		driver.getWindowHandles().stream()
				.filter(h -> !h.equals(driver.getWindowHandle()))
				.findFirst().ifPresent(handle -> driver.switchTo().window(handle));
	}

	@Test
	public void testRegister() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseUrl);
		WebElement registerButton = driver.findElement(By.cssSelector("div.ng-scope div.mt20 a"));
		String registerUrl = registerButton.getAttribute("href");
		//WebElement registerButton = driver.findElement(By.partialLinkText("Зарегистрироваться"));
		assertEquals("Зарегистрироваться на встречу!", registerButton.getText().trim());
		registerButton.click();

		switchToNewWindow();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("DEVCLUB#115"));

		assertEquals(registerUrl, driver.getCurrentUrl());
		assertThat(driver.getTitle(), CoreMatchers.containsString("DEVCLUB#115"));

		WebElement search = driver.findElement(By.cssSelector("input#q.js-search-query-input.ui-autocomplete-input"));
		assertEquals("input", search.getTagName());

		search.sendKeys("devclub");
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = \"DEVCLUB#115\"]")));
		/*
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.ui-autocomplete.list.sill.sill")));

		Thread.sleep(2000);

		boolean found = false;
		List<WebElement> foundElements = driver.findElements( By.cssSelector(" ul.ui-autocomplete.list.sill.sill a.ui-corner-all"));
		for (WebElement el: foundElements) {
			System.out.println(el.getText());
			if (el.getText().contains("DEVCLUB#115")) {
				found = true;
			}
		}
		assertTrue("Search result not found", found);
		*/
	}

}
