import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class AddPlace2 
{
	public static void main(String args[])
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
        body("{\r\n"
        		+ "  \"location\": {\r\n"
        		+ "    \"lat\": -40.383494,\r\n"
        		+ "    \"lng\": 33.427369\r\n"
        		+ "  },\r\n"
        		+ "  \"accuracy\": 58,\r\n"
        		+ "  \"name\": \"Sparsh Yog\",\r\n"
        		+ "  \"phone_number\": \"(+91) 8800105645\",\r\n"
        		+ "  \"address\": \"Fateh nagar\",\r\n"
        		+ "  \"types\": [\r\n"
        		+ "      \"Yoga Studio\"\r\n"
        		+ "  ],\r\n"
        		+ "  \"website\": \"http://google.com\",\r\n"
        		+ "  \"language\": \"French-IN\"\r\n"
        		+ "}\r\n"
        		+ "").when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200);
		
	}

}
