package RestAssuredMainData;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Payload.AllMethodin1BodyData;
import Payload.updateAllMethodin1;

public class AllMethodin1 
{
	public static String  place = ""; 
	
	public static void main(String args[])
	{
		
		
		//add place
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	String res = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(AllMethodin1BodyData.getBodyAllMethodin1()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"), "status",equalTo("OK")).extract().response().asString();
	
	  JsonPath js = new JsonPath(res);
	   place = js.getString("place_id");
	   System.out.println(place);
	   
	   //update place
	   System.out.println("********************** Update Place ************************");
	   given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	   .body(updateAllMethodin1.updateAllMethodin11()).when().put("maps/api/place/update/json").then().log().all()
	   .assertThat().statusCode(200);
	   
	   /// Get Method
	   System.out.println("************************This is the Get Method***************************************");
	   
	   String gettResponse = given().log().all().queryParam("place_id", place).queryParam("key","qaclick123").header("Accept", "*/*").when().get("maps/api/place/get/json")
	   .then().log().all().assertThat().statusCode(200).extract().response().asString();
	   
	   System.out.println(gettResponse);
	   }

	   
}
