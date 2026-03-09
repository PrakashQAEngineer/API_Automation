package OAuth;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class getCourseDetails 
{
	public static void main(String args[])
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("access_token", OAuth_Test.getToken())
		.header("Connection","keep-alive")
		.when().get("oauthapi/getCourseDetails")
		.then().log().all().statusCode(401);
		
		System.out.println(OAuth_Test.getToken());
		
	}

}
