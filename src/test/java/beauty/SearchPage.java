package beauty;

import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends Page {

    private final static By whatWeAreLooking = By.xpath("/html/body/div/app-root/app-site-layout/div/app-home/div/div/div/div/div/form/div/div[1]/input");
    private final static By searchBtn = By.xpath("/html/body/div/app-root/app-site-layout/div/app-home/div/div/div/div/div/form/div/button");
    private final static By homeBtn = By.xpath("/html/body/div/app-root/app-site-layout/app-site-header/header/div/div/nav/div/div[2]/ul[1]/li[1]/a");
    private final static By heading = By.xpath("/html/body/div/app-root/app-site-layout/div/app-search/div[2]/div/div/div[2]/div/div/div/a/div[2]/div/h3");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage searchOnMainPage(String text){
        click(homeBtn);
        writeInput(whatWeAreLooking, text);
        click(searchBtn);
        return new SearchResultPage(driver);
    }
}
