package post_get_Put1;

import io.restassured.path.json.JsonPath;

public class PostGetPut1data 
{
	public static String postdata()
	{
		return "{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -38.383494,\r\n"
				+ "        \"lng\": 33.427362\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 50,\r\n"
				+ "    \"name\": \"SparshYog\",\r\n"
				+ "    \"phone_number\": \"(+91) 8800105645\",\r\n"
				+ "    \"address\": \"C-46, Fateh Nagar, Delhi\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"shoe park\",\r\n"
				+ "        \"shop\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"https://sparshyog.com\",\r\n"
				+ "    \"language\": \"India-IN\"\r\n"
				+ "}";
	}
	
	public static JsonPath jsonn(String raw)
	{
		JsonPath jss = new JsonPath(raw);
		return jss;
	}

	public static String putData(String plid)
	{
		return "{\r\n"
				+ "\"place_id\":\""+plid+"\",\r\n"
				+ "\"address\":\"BrajrajNagar winter walk, Jyoti\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "";
	}
}
