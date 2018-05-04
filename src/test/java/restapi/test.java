package restapi;

import beauty.LoginPage;
import common.GenericTest;
import okhttp3.OkHttpClient;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.Set;

public class test implements GenericTest {
    private static WebDriver driver;
    private static String URL;
    private static Properties props = GenericTest.getProperties();

    private static String username = props.getProperty("beauty.gmaillogin");
    private static String password = props.getProperty("beauty.gmailpassword");

    private final String baseUrl = "https://bo.digital-magic.io";
    private final OkHttpClient client = new OkHttpClient().newBuilder()
        .followRedirects(false)
        .followSslRedirects(false).build();

    @BeforeClass
    public static void SetUp(){
        driver = GenericTest.getDriver();
    }


    @Test
    public void testAuth() throws Exception {
        driver.get(URL);
        driver.manage().window().maximize();
        new LoginPage(driver).loginGmail(username, password);
        Set<Cookie> cookies = driver.manage().getCookies();
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
