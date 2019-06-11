import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC4Test {

    @Test
    void Registation()
    {

        //Specify base URI
        RestAssured.baseURI="http://restapi.demoqa.com/customer";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();


        //Request paylaod sending along with post request
        JSONObject requestParams=new JSONObject();

        requestParams.put("FirstName","ohnXYZ");
        requestParams.put("LastName","YZJohn");
        requestParams.put("UserName","ohnXYZ");
        requestParams.put("Password","ohnXYZxyx");
        requestParams.put("Email","ohnXYZ@gmail.com");

        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams.toJSONString()); // attach above data to the request

        //Response object
        Response response=httpRequest.request(Method.POST,"/register");


        //print response in console window

        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);

        //success code validation
        String successCode=response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");

    }


}
