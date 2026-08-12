package post_get_Put1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class PostGetPut1 
{
	public static void main(String args[])
	{
		String bname = "SparshYog";
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		
		String getPlaceId = given().log().all().queryParam("key", "qaclick123").headers("Content-Type", "application/json" , "Accept", "*/*")
		.body(PostGetPut1data.postdata())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.extract().response().asString();
		
		 JsonPath js = PostGetPut1data.jsonn(getPlaceId);
		String plc_id = js.getString("place_id");
		
		System.out.println("PlaceId is: "+plc_id);
		
       ///get OPeration 
       /// 
       String brandname = given().log().all().queryParams("place_id", plc_id, "key", "qaclick123")
       .when().get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200).body("website", equalTo("https://sparshyog.com"))
       .extract().response().asString();
       
       JsonPath jss = PostGetPut1data.jsonn(brandname);
        String strr = jss.getString("name");
       
       Assert.assertEquals(bname, strr);
       
       //PUT data API
       
       given().queryParams("key", "qaclick123", "place_id", plc_id).header("Content-Type", "application/json")
       .body(PostGetPut1data.putData(plc_id)).when().put("/maps/api/place/update/json").then().log().all()
       .assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
       
       
	}

}
