import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC3Test {

    //Getting all the response

    @Test
    public void googlemaps()

    {
        //Get Uri
        RestAssured.baseURI="https://maps.googleapis.com";

        RequestSpecification httprequest = RestAssured.given();

        Response response = httprequest.request(Method.GET, "//maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

        String responsebody=response.getBody().asString();

        System.out.println("The response is" +responsebody);

        Headers allheaders=response.headers();
        for (Header header : allheaders)
        {
            System.out.println(header.getName() +" "+ header.getValue() );
        }


    }
}
