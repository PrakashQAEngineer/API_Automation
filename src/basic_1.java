import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Files.Payload;

public class basic_1 
{
	public static void main(String args[])
	{
		Payload p1 = new Payload();
		
		// given -  all inputs details
		// when - Submit the API - resource, https methods
		// then  - Validate the reponse
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(p1.addPlace()).when().post("maps/api/place/add/json")
		      .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		      .header("Server", "Apache/2.4.52 (Ubuntu)");
		
	}

}
