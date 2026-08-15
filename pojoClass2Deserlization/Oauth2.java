package pojoClass2Deserlization;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Oauth2 
{
  public static void main(String args[])
  {
	  //setting the Auth Server
	  RestAssured.baseURI = "https://rahulshettyacademy.com";
	 String token =  given().log().all().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	  .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
	  .formParam("grant_type", "client_credentials")
	  .formParam("scope", "trust")
	  .when()
	  .post("/oauthapi/oauth2/resourceOwner/token").then().log().all().assertThat().statusCode(200)
	  .body("scope", equalTo("create")).extract().response().asString();
	 
	 JsonPath js = new JsonPath(token);
	 String acc = js.getString("access_token");
	  
	  // Setting the Oauth
	  
	 PojoOauth1 c1 =  given().log().all().queryParam("access_token", acc).when().get("/oauthapi/getCourseDetails")
	  .then().log().all().extract().response().as(PojoOauth1.class);
	 
	 System.out.println(c1.getLinkedIn());
	 System.out.println(c1.getCourses().getWebAutomation().get(1).getCourseTitle()+ " and Price is: "+c1.getCourses().getWebAutomation().get(1).getPrice());
  }
}
