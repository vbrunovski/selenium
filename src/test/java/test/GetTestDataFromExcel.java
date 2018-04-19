package test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.FileInputStream;
import java.net.MalformedURLException;

public class GetTestDataFromExcel {
    static WebDriver driver;

    @BeforeClass
    public static void SetUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vitali.brunovski\\downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\vitali.brunovski\\downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void getDataFromExcel() {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
                    fileToBeRead));

            HSSFSheet sheet = workbook.getSheet("Zakladka2");

            HSSFRow row = sheet.getRow(1);

            HSSFCell cell = row.getCell((short) 0);

            System.out.println(cell.getRichStringCellValue());

        } catch (Exception e) {
            System.out.println("!! ERORR!!!!!!!!!!  " + e);
        }
    }
}
