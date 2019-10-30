package saule;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Api {
    @org.junit.Test
    public void createWallet(){
        RestAssured.baseURI = "https://develop.sauledev.com/api/wallets";

        String requestBody = "{\n" +
                "  \"userId\": \"117\",\n" +
                "  \"walletType\": \"USER_REAL\",\n" +
                "  \"currencyCode\": \"USD\"\n" +
                "}";


        Response response = null;

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post("https://develop.sauledev.com/api/wallets");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());

        if(response.getStatusCode() == 500){
            System.out.println("User with such ID already in database, please use unique ID");
        }
    }

   @org.junit.Test
    public void getBalance(){
       RestAssured.baseURI = "https://develop.sauledev.com/api/wallets/balance";

       Response response = null;

       try {
           response = RestAssured.given()
                   .when()
                   .get("?userId=106&walletType=USER_REAL&currencyCode=USD");
       } catch (Exception e) {
           e.printStackTrace();
       }

       System.out.println("Response :" + response.asString());
       System.out.println("Status Code :" + response.getStatusCode());
   }

   @org.junit.Test
    public void getHistory(){
       RestAssured.baseURI = "https://develop.sauledev.com/api/wallets/history";

       Response response = null;

       try {
           response = RestAssured.given()
                   .when()
                   .get("?userId=106&walletType=USER_REAL&currencyCode=USD&page=1");
       } catch (Exception e) {
           e.printStackTrace();
       }

       System.out.println("Response :" + response.asString());
       System.out.println("Status Code :" + response.getStatusCode());
   }
}
