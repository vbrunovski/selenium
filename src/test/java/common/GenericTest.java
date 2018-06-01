package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public interface GenericTest {

    static Properties getProperties() {
        InputStream is = ClassLoader.getSystemResourceAsStream("test.properties");
        try {
            Properties props = new Properties();
            props.load(is);
            return props;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    static WebDriver getDriver() {
    	Properties props = getProperties();
        System.setProperty("webdriver.chrome.driver", props.getProperty("chromedriver.path"));
        System.setProperty("webdriver.gecko.driver", props.getProperty("geckodriver.path"));
        //return new ChromeDriver();
        return new FirefoxDriver();
	}

}
