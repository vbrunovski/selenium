package ddt;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.fail;

public final class FileReader {

    static Collection<User> readFromExcelFile(String fileName) throws IOException, URISyntaxException {
        // Specify the path of file
        File src = new File(FileReader.class.getClassLoader().getResource(fileName).toURI());
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

    static Collection<User> readFromTextFile(String fileName) throws IOException, URISyntaxException {
        File f = new File(FileReader.class.getClassLoader().getResource(fileName).toURI());
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

}
