import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Payload.AddPlacePayload_1;

public class AddPlace1 
{
	
	
	public static void main(String args[])
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String resp = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(AddPlacePayload_1.AddPlace1()).when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
		         .body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		        
		
	}

}
