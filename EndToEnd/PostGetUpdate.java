package EndToEnd;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static  io.restassured.RestAssured.*;
//import org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;


public class PostGetUpdate 
{
	public static String placeId;
	public static void main(String args[])
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		//POST Method
		String PostPlace = given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(PostBody.pBody()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
		.body("scope", equalTo("APP"),"status", equalTo("OK")).header("Server", "Apache/2.4.52 (Ubuntu)").extract().response()
		.asString();
		
		System.out.println(PostPlace);
		
		JsonPath js = new JsonPath(PostPlace);
		placeId = js.getString("place_id");
		System.out.println(placeId);
		
		
		//GET Method
		
		String getData = given().queryParam("place_id", ""+placeId+"").queryParam("key", "qaclick123")
		.header("User-Agent","PostmanRuntime/7.44.1").when().get("maps/api/place/get/json").then()
		.assertThat().statusCode(200).body("name", equalTo("Sparsh Yog")).extract().response().asString();
		
		System.out.println("Before Update:  "+getData);
		
		//UPDATE Method
		
		String up_data = given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(UpdateBody.Updatedata()).when().put("maps/api/place/update/json").then().assertThat().statusCode(200)
		.body("msg", equalTo("Address successfully updated")).header("Server", "Apache/2.4.52 (Ubuntu)").extract().response()
		.asString();
		
		System.out.println("The Updated data: "+up_data);
		
		JsonPath jss = new JsonPath(up_data);
		String res_out = jss.getString("msg");
		System.out.println(res_out);
		
		//GET Method after Update
		String gettData = given().queryParam("place_id", ""+placeId+"").queryParam("key", "qaclick123")
				.header("User-Agent","PostmanRuntime/7.44.1").when().get("maps/api/place/get/json").then()
				.assertThat().statusCode(200).body("name", equalTo("Sparsh Yog")).extract().response().asString();
				
				System.out.println("After Update:  "+gettData);
		
		
	}

}
