package beauty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends Page {

    private WebDriver driver;
    private final static By headerResult = By.xpath("/html/body/div/app-root/app-site-layout/div/app-search/div[2]/div/div/div[2]/div/div/div/a/div[2]/div/h3");

    @Override
    protected WebDriver getDriver(){return driver;}

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSearchResult(){
        sleep(1);
        click(headerResult);
    }
}
