package test;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.fail;

public class GetTestDataFromTxt {
    //private static WebDriver driver;
    //public File fileToBeRead = new File("С:\\test.txt");

    @BeforeClass
    public static void SetUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\vitali.brunovski\\downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        //driver = new ChromeDriver();
    }

    @Test
    public void ReadFromTxt() throws IOException, URISyntaxException {
        //driver.get("http://google.com");

        File f = new File(getClass().getClassLoader().getResource("test.txt").toURI());
        if (!f.exists()) fail("File not exists!");

        List<String> lines = FileUtils.readLines(f, "UTF-8");
        for (String line : lines) {
            String[] words = line.split(" ");
            for (String word: words) {
                System.out.println(word);
            }
        }
    }
}
