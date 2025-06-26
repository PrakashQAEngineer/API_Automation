package ParseJson2;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class parsejson2 
{
	public static void main(String args[])
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	String resp = 	given().log().all().queryParam("key", "qaclick123").headers("Content-Type","application/json")
		.body(bodyFileParse.parseBody()).when().post("maps/api/place/add/json").then()
		.assertThat().statusCode(200).body("scope",equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
	
	    System.out.println(resp);
	    
	    JsonPath js  = new JsonPath(resp);
	    String pl_id = js.getString("place_id");
	    System.out.println("Place ID is: "+pl_id);
	}

}
