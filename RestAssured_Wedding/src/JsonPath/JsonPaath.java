package JsonPath;

import io.restassured.path.json.JsonPath;

public class JsonPaath 
{
	public static JsonPath rawtoJson(String response)
	{
		 JsonPath js1 = new JsonPath(response);
		 return js1;
	}

}
