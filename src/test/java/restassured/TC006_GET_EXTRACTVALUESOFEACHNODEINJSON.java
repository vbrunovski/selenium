package restassured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TC006_GET_EXTRACTVALUESOFEACHNODEINJSON {
    @Test
    public void getWeatherDetails(){
        //Specify baseuri
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        //Request object creating
        RequestSpecification httpRequest = RestAssured.given();

        //Response object creating
        Response response = httpRequest.request(Method.GET, "/Tallinn");

        JsonPath jsonpath = response.jsonPath();

        System.out.println(jsonpath.get("City").toString());
        System.out.println(jsonpath.get("Temperature").toString());
        System.out.println(jsonpath.get("Humidity").toString());
        System.out.println(jsonpath.get("WeatherDescription").toString());
        System.out.println(jsonpath.get("WindDirectionDegree").toString());

        Assert.assertEquals(jsonpath.get("Temperature"), "6.88 Degree celsius");

    }
}
