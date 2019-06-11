import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

//Get request
public class TC2 {


    @Test
    void googlemaps()

    {
        //uri

        RestAssured.baseURI="https://maps.googleapis.com";

        //Request object

        RequestSpecification httprequest = RestAssured.given();

        //Response object

        Response response=httprequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

        //Print response code

        int statuscode=response.getStatusCode();
        System.out.println("The status code"+statuscode);
        Assert.assertEquals(statuscode,200);


        String responsebody=response.getBody().asString();
        System.out.println("The response payload " +responsebody );


        //header validation

        String contentType=response.header("Content-Type");
        System.out.println("Content Type is:"+contentType);
        Assert.assertEquals(contentType, "application/xml; charset=UTF-8");


    }

}
