package beauty;

import common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProviderPage extends Page {
    private final static By toScroll1 = By.xpath("/html/body/div/app-root/app-site-layout/div/app-provider-page/div/div[2]/div[1]/div[4]/div/div/table/tbody/tr[1]");
    private final static By bookServicebtn = By.xpath("/html/body/div/app-root/app-site-layout/div/app-provider-page/div/div[2]/div[1]/div[4]/div/div/table/tbody/tr[2]/td[4]/a");

    public ProviderPage(WebDriver driver) {
        super(driver);
    }

    public TimeBookingPage clickToBookService(){
        scrollToElement(toScroll1);
        click(bookServicebtn);
        sleep(1);
        return new TimeBookingPage(driver);
    }
}
