package EndToEnd;

import io.restassured.path.json.JsonPath;

public class ReuseableMethod 
{
	public static JsonPath RawToJson(String getData)
	{
		JsonPath js = new JsonPath(getData);
		return js;
	}

}
