package simple_Rest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Intro 
{
	public static void main(String args[])
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String data = given().log().all().queryParam("key", "qaclick123").headers("Content-Type", "application/json", "Connection", "keep-alive")
		.body(IntroData.getBody()).when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
		.body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)")
		.extract().response().asString();
		
		JsonPath js = new JsonPath(data);
		String placeId = js.getString("place_id");
		System.out.println("The place Id is: "+placeId);
		
	}

}
