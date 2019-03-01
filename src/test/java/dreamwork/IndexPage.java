package dreamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IndexPage {
    private final WebDriver driver;
    private final By searchField = By.xpath("//*[@id=\"sform\"]/div/div[1]/div/input");
    private final By searchBtn = By.xpath("//*[@id=\"sform\"]/div/div[3]/button");
    private final By homeLink = By.xpath("//*[@id=\"intro\"]/div[1]/nav/div/div[1]/a");
    private final By blogText = By.xpath("/html/body/section/div/div/div[2]/div[1]/p");

    public IndexPage(WebDriver driver){
        this.driver = driver;
    }

    public void MoreButton(){
        List<WebElement> moreBtn = driver.findElements(By.className("btn-rm"));
        System.out.println("Na stranice knopok: " + moreBtn.size());
    }

    public void verifySearchIsWorking(String query) throws InterruptedException {
        WebElement searchInput = driver.findElement(searchField);
        searchInput.sendKeys(query);

        driver.findElement(searchBtn).click();

        Thread.sleep(5000);

        driver.findElement(homeLink).click();

        Thread.sleep(3000);

        List<WebElement> searchQueries = driver.findElements(By.cssSelector(".popular-jobs a"));
        for(int i=0; i<searchQueries.size(); i++){
            if(searchQueries.get(i).getText().equals("mongodb")){
                System.out.println("V poiske prisutsvtuet zapros " + query);
                break;
            }//System.out.println(searchQueries.get(i).getText());
        }

    }

    public void verifyThatBlogPostExists(){
        WebElement text = driver.findElement(blogText);
        text.getText();
        if(text.getText().length() > 0){
            System.out.println("Blog post sushsestvuet, tak kak dlina posta ravna " + text.getText().length());
        }
        else{
            System.out.println("Blog post otsutstvuet, tak kak dlina posta ravna " + text.getText().length());
        }
        //System.out.println("Text: " + text.getText());
    }

    public void countMenuItems(){
        List<WebElement> items = driver.findElements(By.xpath("//*[@id=\"navbar\"]/ul[1]"));
        for (WebElement ddlList : items)
        {
            System.out.println(ddlList.findElements(By.tagName("li")).size());
        }
    }

}
