package OAuth;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class OAuth_Test 
{
	public static String getToken()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String acc = given().log().all()
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().post("oauthapi/oauth2/resourceOwner/token")
		.then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(acc);
		String token = js.getString("access_token");
		
		System.out.println("The token is: "+token);
		return token;
	}
	
	public static void main(String args[])
	{
		getToken();
	}

	
}
