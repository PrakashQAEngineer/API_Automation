package DynamicJson;

import org.testng.annotations.Test;

import dynamicJsonPayloadData.payload1;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynaJson 
{
	@Test
	
	public void addBook()
	{
	   RestAssured.baseURI = "https://rahulshettyacademy.com";
	   String res = given().log().all().header("Content-Type", "application/json").body(payload1.payDynamic())
	   .when().post("Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().response().asString();
	   
	   JsonPath js = new JsonPath(res);
	     String id = js.get("ID");
	     System.out.println(id);
	   
	}

}
