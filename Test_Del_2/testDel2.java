package Test_Del_2;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class testDel2 
{
	public static void main(String args[])
	{
		filedel2 fd = new filedel2();
	   RestAssured.baseURI = "https://rahulshettyacademy.com";
	   given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	   .body(fd.del2()).when().post("maps/api/place/add/json").then().log().all()
	   .assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)");
	   
	}

}
