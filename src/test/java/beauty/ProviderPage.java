package beauty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProviderPage extends Page{
    private WebDriver driver;
    private final static By toScroll1 = By.xpath("/html/body/div/app-root/app-site-layout/div/app-provider-page/div/div[2]/div[1]/div[4]/div/div/table/tbody/tr[1]");
    private final static By bookServicebtn = By.xpath("/html/body/div/app-root/app-site-layout/div/app-provider-page/div/div[2]/div[1]/div[4]/div/div/table/tbody/tr[2]/td[4]/a");

    @Override
    protected WebDriver getDriver(){return driver;}

    public ProviderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToBookService(){
        scrollToElement(toScroll1);
        click(bookServicebtn);
        sleep(1);
    }


}
