package Test_basic;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import Test_basic.file;



public class Basic 
{
	public static void main(String args[])
	{
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(file.getBody()).log().all().when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
		.body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)");
	}

}
