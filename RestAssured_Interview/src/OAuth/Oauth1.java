package OAuth;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojoClasses.API;
import pojoClasses.DeserlizationClasses;
import pojoClasses.WebAutomation;

import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;

public class Oauth1 
{
	public static void main(String args[])
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		//Auth Server
		String respo = given().log().all().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "grant_type")
		.formParam("scope", "trust")
		.when().post("/oauthapi/oauth2/resourceOwner/token").then().log().all().assertThat().statusCode(200)
		.body("token_type", equalTo("Bearer")).extract().response().asString();
		
		//Oauth body
		
		JsonPath js = new JsonPath(respo);
		 String token = js.getString("access_token");
		 
		 DeserlizationClasses gc = 	 given().log().all().queryParam("access_token", token).when().get("/oauthapi/getCourseDetails")
		 .as(DeserlizationClasses.class);
		 
		 System.out.println("**************************************************");
		 System.out.println(gc.getLinkedIn());
		 System.out.println(gc.getInstructor());
		 System.out.println(gc.getCourses().getWebAutomation().get(0).getCourseTitle());
		 
	    List<API> ai = gc.getCourses().getApi();
	    for(int i=0;i<ai.size();i++)
	    {
	      if(ai.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
	      {
	    	  System.out.println(ai.get(i).getPrice());
	    	  break;
	      }
	    }
	    
	    //print all the course title in webautomation
	    
	    List<WebAutomation> wb = gc.getCourses().getWebAutomation();
	      for(int i=0;i<wb.size();i++)
	      {
	    	  System.out.println("All the course title under web automation are:--- "+wb.get(i).getCourseTitle());
	      }
		 
	      Assert.assertEquals(gc.getCourses().getMobile().get(0).getPrice(), "50","Mobile course price is not matching");
		 }

	
}
