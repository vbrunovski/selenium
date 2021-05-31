package restassured;
/*
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TC005_GET_VALIDATINGJSONRESPONSE {
    @Test
    public void getWeatherDetails(){
        //Specify baseuri
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        //Request object creating
        RequestSpecification httpRequest = RestAssured.given();

        //Response object creating
        Response response = httpRequest.request(Method.GET, "/Tallinn");

        //Print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);

        Assert.assertEquals(responseBody.contains("Tallinn"), true);

    }
}
*/