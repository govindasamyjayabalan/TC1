import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1Test {
//Get Request
    @Test
    void Weatherdetails()

        {
            //base URI
            RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";

            //Request object
            RequestSpecification httprequest= RestAssured.given();

            //Response object
            Response response = httprequest.request(Method.GET,"/Chennai");

            //Getting response in body
            String responsebody=response.getBody().asString();
            System.out.println("The response payload " +responsebody );

            //Assertion
            int statusCode=response.getStatusCode();
            System.out.println("Status code is: "+statusCode);
            Assert.assertEquals(statusCode,200);


    }

}
