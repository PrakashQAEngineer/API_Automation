package NestedJson;

import Payload.NestedJsonPayload;
import io.restassured.path.json.JsonPath;

public class NSJSon1 
{
	public static void main(String args[])
	{
		JsonPath js  = new JsonPath(NestedJsonPayload.nsData());
		  int nocourse = js.getInt("courses.size()");
		  
		  System.out.println("The no of cources are: "+nocourse);
	}

}
