package Parse_JSON;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ParseJson 
{
	public static void main(String args[])
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(GetBodyData.getBodyDataa()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();
	     // now we are going to extract all the response
	
	System.out.println(response);
	
	JsonPath js = new JsonPath(response);//for parsing json
	String place = js.getString("place_id");
	System.out.println("This is Place Id: "+place);
		
	}

}
