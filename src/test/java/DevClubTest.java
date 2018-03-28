import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.hamcrest.CoreMatchers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DevClubTest {

	static String baseUrl = "http://www.devclub.eu/";
	static WebDriver driver;

	@BeforeClass
	public static void preTest() throws MalformedURLException {
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void afterTest() {
		driver.quit();
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
