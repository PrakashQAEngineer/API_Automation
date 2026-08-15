package pojoClassSerlization1;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;

public class Addbook1 

{
	
	
	public static void main(String args[])
	{
		
		
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
         
         
         
        RequestSpecification rq = new  RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
        .addHeader("Content-Type", "application/json").build();
        
      ResponseSpecification res =   new ResponseSpecBuilder().expectStatusCode(200)
                                 .expectBody("scope", equalTo("APP")).build();
        
		RequestSpecification rqq = given().log().all().spec(rq)
		.body(a1);
		
		rqq.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().spec(res);
	}

}
