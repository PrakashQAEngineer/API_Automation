package RestAssuredMainData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Payload.ResponseExtractorPayload;
import Payload.ResponseExtractorUpdatePayload;
import JsonPath.JsonPaath;

public class ResponseExtractor 
{
	public static String place = "";
	public static void main(String args[])
	{
		
		//post place***************************
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String res = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(ResponseExtractorPayload.responsePaydata()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)")
		.extract().response().asString();
		
		
		JsonPath js = new JsonPath(res);
		  place = js.getString("place_id");
		 System.out.println("Place ID is: "+place);
		 
		 //Upadate Place **************************
		 
		 given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		 .body(ResponseExtractorUpdatePayload.updatePlace()).when().put("maps/api/place/update/json")
		 .then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		 
      		/////Get Place   **************************
      	
		 String get = given().log().all().queryParam("place_id", place).queryParam("key", "qaclick123").header("Accept", "*/*")
		 .when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		 
		 System.out.println(get);	
		 
		 JsonPath js1 = new JsonPath(get);
		 
		 JsonPath strr  = JsonPaath.rawtoJson(get);
		 String getAddress = strr.getString("address");
		 System.out.println("The address is: "+getAddress);
		 
		 Assert.assertEquals("New Delhi", getAddress);
		 
	}

}
