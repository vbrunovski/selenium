package test;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class GetTestDataFromExcel {
    static WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public static void SetUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\vitali.brunovski\\downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        driver = new ChromeDriver();

    }

    static class User {
        public User(String name, String email, String pass) {
            this.name = name;
            this.email = email;
            this.pass = pass;
        }

        public final String name;
        public final String email;
        public final String pass;
    }

    void testGithubReg(User user){
        driver.get("https://github.com");
        WebElement usernameG = driver.findElement(By.xpath("//*[@id=\"user[login]\"]"));
        usernameG.sendKeys(user.name);
        WebElement emailG = driver.findElement(By.xpath("//*[@id=\"user[email]\"]"));
        emailG.sendKeys(user.email);
        WebElement passG = driver.findElement(By.xpath("//*[@id=\"user[password]\"]"));
        passG.sendKeys(user.pass);
    }

    List<User> readFromExcelFile(String fileName) throws IOException, URISyntaxException {
        // Specify the path of file
        File src = new File(getClass().getClassLoader().getResource(fileName).toURI());
        // load file
        FileInputStream fis = new FileInputStream(src);
        // Load workbook
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        // Load sheet- Here we are loading first sheetonly
        XSSFSheet sh1 = wb.getSheetAt(0);

        ArrayList<User> results = new ArrayList<>();
        for (int i = sh1.getFirstRowNum(); i <= sh1.getLastRowNum(); i++) {
            Row row = sh1.getRow(i);
            String name = row.getCell(0).getStringCellValue();
            String email = row.getCell(1).getStringCellValue();
            String pass = row.getCell(2).getStringCellValue();
            results.add(new User(name, email, pass));
        }
        return results;
    }

    List<User> readFromTextFile(String fileName) throws IOException, URISyntaxException {
        File f = new File(getClass().getClassLoader().getResource(fileName).toURI());
        if (!f.exists()) fail("File not exists!");

        ArrayList<User> results = new ArrayList<>();
        List<String> lines = FileUtils.readLines(f, "UTF-8");
        for (String line : lines) {
            String[] words = line.split(",");
            String name = words[0];
            String email = words[1];
            String pass = words[2];
            results.add(new User(name, email, pass));
        }
        return results;
    }

    @Test
    public void getDataFromExcel() throws IOException, URISyntaxException {
        for (User user: readFromExcelFile("test.xlsx")) {
            testGithubReg(user);
        }
        for (User user: readFromTextFile("test.txt")) {
            testGithubReg(user);
        }
    }
}
