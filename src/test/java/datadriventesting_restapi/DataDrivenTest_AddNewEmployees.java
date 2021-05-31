package datadriventesting_restapi;
/*
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class DataDrivenTest_AddNewEmployees {
    @Test(dataProvider = "empdataprovider")
    void addNewEmployees(String ename, String eage, String esal){
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpRequest = RestAssured.given();
        //here we created data which we can send along with the post request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", ename);
        requestParams.put("salary", esal);
        requestParams.put("age", eage);
        //add a header stating the request body is a JSON
        httpRequest.header("Content-Type", "application/json");
        //add the JSON body to the request
        httpRequest.body(requestParams.toJSONString());
        //post request
        Response response = httpRequest.request(Method.POST,"/create");
        //capture response body to perform validations
        String responseBody = response.getBody().asString();

        System.out.println("EResponseBody is: " + responseBody);

        Assert.assertEquals(responseBody.contains(ename), true);
        Assert.assertEquals(responseBody.contains(esal), true);
        Assert.assertEquals(responseBody.contains(eage), true);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        //get all data from /employees ?

    }

    @DataProvider(name="empdataprovider")
     String[][] getEmpdata() throws IOException {

        //read data from excel
        String path = "C:\\Users\\ismyf\\IdeaProjects\\selenium\\src\\test\\java\\datadriventesting_restapi\\test2.xlsx";
        int rowNum = XLUtils.getRowCount(path, "Sheet1");
        int colCount = XLUtils.getCellCount(path, "Sheet1", 1);

        //String empData[][] = {{"abc123", "3000", "40"}, {"xyz111", "20000", "19"}, {"hello113", "9000", "36"}};
        //return (empData);

        String empData[][] = new String[rowNum][colCount];
        for(int i=1; i<=rowNum; i++){
            for(int j=0; j<colCount; j++){
                empData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
        return empData;
    }
}
*/

//https://www.youtube.com/watch?v=brFtzAF1vMw&list=PLUDwpEzHYYLuMRzT6LFq4r8DwKZdcqHmY&index=3