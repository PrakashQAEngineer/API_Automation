package libraryBookApi;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddBook 
{
	public static void main(String args[]) throws IOException
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().header("Content-Type", "text/plain")
		.body(new String(Files.readAllBytes(Paths.get("E:\\testjson.json"))))
		.when().post("Library/Addbook.php").then().log().all().assertThat().statusCode(200);
	}

}
