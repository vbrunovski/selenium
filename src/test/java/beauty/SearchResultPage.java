package beauty;

import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends Page {

    private final static By headerResult = By.xpath("/html/body/div/app-root/app-site-layout/div/app-search/div[2]/div/div/div[2]/div/div/div/a/div[2]/div/h3");
    private final static By tmp = By.xpath("/html/body/div/app-root/app-site-layout/div/app-search/div[2]/div/div/div[2]/div/div/div/a/div[1]");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public ProviderPage clickOnSearchResult(){
        sleep(1);
        click(headerResult);
        return new ProviderPage(driver);
    }

}
