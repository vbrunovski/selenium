package restassured;
/*
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TC002_POST_REQUEST {
    @Test
    void registrationSuccessful(){
        //Specify baseuri
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";

        //Request object creating
        RequestSpecification httpRequest = RestAssured.given();

        //Request payload sending along with post request
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "asdqa");
        requestParams.put("LastName", "asdqa");
        requestParams.put("UserName", "asdqa");
        requestParams.put("Password", "asdqa");
        requestParams.put("Email", "qaasd@asd.com");

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString()); //attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.POST, "/register");
        //Print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is " + statusCode);
        Assert.assertEquals(statusCode, 201);

        //Success code validation. Extract success code from body
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");


    }
}
*/