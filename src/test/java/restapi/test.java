package restapi;

import beauty.LoginPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.GenericTest;
import okhttp3.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class test implements GenericTest {
    private static WebDriver driver;
    private static String URL;

	private static Properties props = GenericTest.getProperties();
    private static String username = props.getProperty("beauty.gmaillogin");
    private static String password = props.getProperty("beauty.gmailpassword");

    private ObjectMapper objectMapper = new ObjectMapper();

    private final String baseUrl = "https://bo.digital-magic.io";
    private final OkHttpClient client = new OkHttpClient().newBuilder()
        .followRedirects(false)
        .followSslRedirects(false).build();

    @BeforeClass
    public static void SetUp(){
		Properties props = GenericTest.getProperties();

		String login = props.getProperty("security.login");
		String password = props.getProperty("security.password");
		URL = "https://" + login + ":" + password  +"@bo.digital-magic.io";
    }


    static class SearchRecord {
    	public String id;
    	public String name;
	}

    static class SearchResult {
    	public List<SearchRecord> cities;
    	public List<SearchRecord> districts;
    	public List<SearchRecord> categories;
    	public List<SearchRecord> services;
    	public List<SearchRecord> resources;
	}

	SearchResult searchSuggestion(String query) {
		String url = baseUrl + "/api/search/suggestions/" + query;
		Request request = new Request.Builder()
				.get()
				.url(url)
				.build();

		try (Response response = client.newCall(request).execute()) {
			if (response.code() != 200) {
				throw new IllegalArgumentException("Unexpected response status:" + response.code() + "; " + response.body().string());
			}
			String body = response.body().string();
			System.out.println(body);

			return objectMapper.readValue(body, SearchResult.class );
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

    @Test
    public void search() throws IOException {
		SearchResult result = searchSuggestion("barber");
		assertEquals(1, result.categories.size());
		assertEquals("Barber", result.categories.get(0).name);

		result = searchSuggestion("hair");
		assertEquals(5, result.categories.size());
		assertEquals(32, result.services.size());
    	assertEquals("Hair care", result.categories.get(0).name);

	}

    @Test
    public void testAuth() throws Exception {
		driver = GenericTest.getDriver();
        driver.get(URL);
        driver.manage().window().maximize();
		Thread.sleep(1000);
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("COOKIES: " + cookies.stream().map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining("\n")));
        new LoginPage(driver).loginGmail(username, password);
        cookies = driver.manage().getCookies();
		System.out.println("COOKIES: " + cookies.stream().map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining("\n")));
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

    @Test
    public void testCookie() throws InterruptedException {
		driver = GenericTest.getDriver();
		driver.get("http://www.google.com");
		Thread.sleep(1000);
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies.stream().map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining("\n")));
	}
}
