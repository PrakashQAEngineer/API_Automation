package NestedJson;

import Payload.NsJson2_Body_Course;
import io.restassured.path.json.JsonPath;

public class NsJson2 
{
	public static void main(String args[])
	{
		JsonPath js = new JsonPath(NsJson2_Body_Course.nsJson2Data());
		int countCourse = js.getInt("courses.size()");
		System.out.println(countCourse);  //printing the course amount
		
		int prcamt = js.getInt("dashboard.purchaseAmount");
		System.out.println("the totasl no of amounts are: "+prcamt);

		String fstTitle = js.getString("courses.title[0]");
		System.out.println("the titlew of the first course is: "+fstTitle);
	}

}
