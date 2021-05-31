package restassured;
/*

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.annotations.Test;


public class TC001_GET_REQUEST {

    //How to test api
    //Define baeUri
    //Request object
    //Response object
    //ResponseBody
    //Verification of: status code, status line, headers(content type, etc), response time

    @Test
    void getWeatherDetails(){
        //Specify baseuri
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        //Request object creating
        RequestSpecification httpRequest = RestAssured.given();

        //Response object creating
        Response response = httpRequest.request(Method.GET, "/Tallinn");

        //Print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is " + statusCode);
        Assert.assertEquals(statusCode, 200);

        //Status line verification
        String statusLine = response.getStatusLine(); // what is it?
        System.out.println("Status line is " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }
}

 */
