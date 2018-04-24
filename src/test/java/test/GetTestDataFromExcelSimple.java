package test;
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
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class GetTestDataFromExcelSimple {
    static WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public static void SetUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\vitali.brunovski\\downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void getDataFromExcel() {

        try {
            // Specify the path of file
            File src = new File(getClass().getClassLoader().getResource("test.xlsx").toURI());

            // load file
            FileInputStream fis = new FileInputStream(src);

            // Load workbook
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            // Load sheet- Here we are loading first sheetonly
            XSSFSheet sh1 = wb.getSheetAt(0);

            String name = "no value";
            String email = "no value";
            String pass = "no value";

            //List<Person> people = new ArrayList<Person>();

            for (int i = sh1.getFirstRowNum(); i <= sh1.getLastRowNum(); i++) {
                Row row = sh1.getRow(i);
                for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                    String cellValue = row.getCell(j).getStringCellValue();
                    //System.out.println(cellValue);
                    if(j == 0){
                        name = cellValue;
                    }
                    else if(j == 1){
                        email = cellValue;
                    }
                    else if(j == 2){
                        pass = cellValue;
                    }

                }
                System.out.println(name + " " + email + " " + pass);

                driver.get("https://github.com");

                WebElement usernameG = driver.findElement(By.xpath("//*[@id=\"user[login]\"]"));
                usernameG.sendKeys(name);
                WebElement emailG = driver.findElement(By.xpath("//*[@id=\"user[email]\"]"));
                emailG.sendKeys(email);
                WebElement passG = driver.findElement(By.xpath("//*[@id=\"user[password]\"]"));
                passG.sendKeys(pass);

            }

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}