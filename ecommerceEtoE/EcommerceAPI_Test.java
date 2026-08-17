package ecommerceEtoE;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EcommerceAPI_Test 
{
	public static void main(String args[])
	{
		
		LoginPojoRequest login = new LoginPojoRequest();
		login.setUserEmail("im7prakash@gmail.com");
		login.setUserPassword("@QWertyuiop16");
		
		LpginPojoResponse loginres = new LpginPojoResponse();
		
		
	   RequestSpecification req =	new RequestSpecBuilder().setContentType(ContentType.JSON)
		.setBaseUri("https://rahulshettyacademy.com").build();
	   
	   ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectBody("message", equalTo("Login Successfully")).build();
	      RequestSpecification rq = given().spec(req).body(login);
	      loginres =  rq.when().post("/api/ecom/auth/login").then().spec(res).extract().response().as(LpginPojoResponse.class);
	      System.out.println("The asseccs token for the login user is: "+loginres.getToken());
	      
	      String token = loginres.getToken();
	      String userId = loginres.getUserId();
	      System.out.println("The User id is: "+loginres.getUserId());
	      System.out.println("The message is: "+loginres.getMessage());
	      
	      
	      // ADD Product
	      
	     RequestSpecification rq_ad_pr = new RequestSpecBuilder().addHeader("Authorization", token)
	    		 .setBaseUri("https://rahulshettyacademy.com").build();
	     AddProductDeserlizationPojo apd1 =  given().log().all().spec(rq_ad_pr).param("productName", "SparshYog")
	        .param("productAddedBy", userId)
	        .param("productCategory", "fashion")
	        .param("productSubCategory", "shirts")
	        .param("productPrice", "11500")
	        .param("productDescription", "Addias Originals")
	        .param("productFor", "women")
	        .multiPart("productImage", new File("C:\\Users\\user\\Downloads\\FullSizeRe5nder_cleanup.jpg"))
	        .when().post("/api/ecom/product/add-product").then().log().all().assertThat().statusCode(201)
	        .body("message", equalTo("Product Added Successfully")).extract().response().as(AddProductDeserlizationPojo.class);     
	     
	    String prdId = apd1.getProductId();
	    System.out.println("Product Id is: "+prdId);
	    
	    
	    //create Order
	    
	    Orders od = new Orders();
	    od.setCountry("India");
	    od.setProductOrderedId(prdId);
	    
	    List<Orders> li = new ArrayList<>();
	    li.add(od);
	    
	    CreateOrderRequestPojo crp = new CreateOrderRequestPojo();
	    crp.setOrders(li);
	    
	    RequestSpecification rsf = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
	    		.addHeader("Authorization", token).setContentType(ContentType.JSON).build();
	    
	    String ctOrder = given().log().all().spec(rsf).body(crp).when().post("/api/ecom/order/create-order")
	    .then().log().all().assertThat().statusCode(201).body("message", equalTo("Order Placed Successfully"))
	    .extract().response().asString();
	    
	    
	    JsonPath js = new JsonPath(ctOrder);
	    	String order = js.getString("orders");
	    	String addprdid = js.getString("productOrderId");
	    	
	    	System.out.println("The order Id is: "+order+ "and the ProductOrderId is: "+addprdid);
	}

}
