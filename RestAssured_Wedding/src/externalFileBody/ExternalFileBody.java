package externalFileBody;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths; 

public class ExternalFileBody 
{
	@Test
	
	public void externalFile() throws IOException
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String res = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(new String (Files.readAllBytes(Paths.get("D:\\JsonBody.json5"))))
		.when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("status", equalTo("OK"))
		.extract().response().asString();
		
		JsonPath js = new JsonPath(res);
		String placeId = js.get("place_id");
		
		System.out.println("The Place Id is: "+placeId);
		
	}
}
