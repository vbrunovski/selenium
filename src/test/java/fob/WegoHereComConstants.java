package fob;

import org.openqa.selenium.By;

public class WegoHereComConstants   {
    private final By routePathHour = By.xpath("//*[@id=\"routes_list\"]/div[2]/ul/li[1]/div/div[2]/div[1]/span/span[1]");
    private final By routePathMin = By.xpath("//*[@id=\"routes_list\"]/div[2]/ul/li[1]/div/div[2]/div[1]/span/span[3]");

    public By getRoutePathHour(){
        return routePathHour;
    }

    public By getRoutePathMin(){
        return routePathMin;
    }
}
