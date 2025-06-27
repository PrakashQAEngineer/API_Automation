package Multi_API;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MultiAPI 
{
	
	public static String pl_id;

	public static void main(String args[])
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		//insert the Place
		String res = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(MultiAPiBody.getBody()).when().post("maps/api/place/add/json").then().assertThat()
		.statusCode(200).body("scope",equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)").extract()
        .response().asString();
		
		System.out.println("result: "+res);
		JsonPath js  = new JsonPath(res);
		pl_id = js.getString("place_id");
		
		System.out.println("The place id is: "+pl_id);
		
		//update the place
		
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		String upd = given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(UpdateBody.update()).when().put("maps/api/place/update/json").then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("Update: "+upd);
		
		System.out.println("Test: "+UpdateBody.update());
	}

	

}
