package excel_Input;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExcelInputData1 
{
	public static void main(String args[]) throws IOException
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().header("Content-Type","application/json").queryParam("Content-Type", "application/json")
		.body(Files.readAllBytes(Paths.get("D:\\Development\\loc_add.json5"))).when()
		.post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200);
	}

}
