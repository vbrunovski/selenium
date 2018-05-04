package beauty;

import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends Page {
    private WebDriver driver;
    private final static By whatWeAreLooking = By.xpath("/html/body/div/app-root/app-site-layout/div/app-home/div/div/div/div/div/form/div/div[1]/input");
    private final static By searchBtn = By.xpath("/html/body/div/app-root/app-site-layout/div/app-home/div/div/div/div/div/form/div/button");
    private final static By logo = By.xpath("/html/body/div/app-root/app-site-layout/app-site-header/header/div/div/nav/div/div[1]/div/a");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage searchOnMainPage(String text){
        click(logo);
        writeInput(whatWeAreLooking, text);
        click(searchBtn);
        return new SearchResultPage(driver);
    }
}
