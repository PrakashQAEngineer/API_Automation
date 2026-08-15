package pojoClassSerlization1;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;

public class Addbook1 

{
	
	
	public static void main(String args[])
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		//Serlization
		AddPlace1 a1 = new AddPlace1();
		a1.setAccuracy(50);
		a1.setName("SparshYog");
		a1.setPhone_number("8800105645");
		a1.setAddress("Fateh Nagar");
		a1.setWebsite("http://sparshyog.com");
		a1.setLanguage("India");
		
		List<String> ls = new ArrayList<>();
         ls.add("Yoga Park");
         ls.add("Yoga Studio");
         a1.setTypes(ls);
        
         Location1 l1 = new Location1();
         l1.setLat(38.383494);
         l1.setLng(33.427362);
         
         a1.setLocation(l1);
         
         
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body(a1)
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).body("status", equalTo("OK"));
		
	}

}
