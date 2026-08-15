package libraryAPITestNgVersion;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddBook 
{
	@Test(dataProvider = "bookdata")
	public void addingBook(String isbn , String aisle)
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().header("Content-Type", "text/plain")
		.body(AddBookData.addBook(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).body("Msg", equalTo("successfully added"));
		
		
	}
	
   @DataProvider(name = "bookdata")
     public Object[][]  getBookData()
     {
	    Object[][] bookdata = new Object[2][2];
	    bookdata[0][0] = "car";
	    bookdata[0][1] = "12223";
	    
	    bookdata[1][0] = "truck";
	    bookdata[1][1] = "78788";
	    
	    return bookdata;
     }

}
