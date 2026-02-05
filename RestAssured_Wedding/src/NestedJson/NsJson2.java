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
		System.out.println("the title of the first course is: "+fstTitle);
		
		//print all cources title and their prices
		
		for(int i=0; i<countCourse;i++)
		{
			String cr_title = js.getString("courses.title["+i+"]");
			int cr_price = js.getInt("courses.price["+i+"]");
			
			System.out.println("The title of the price is: "+cr_title+ " And the price is: "+cr_price);
			
			// no of copies sold by rpa
			if(cr_title.contains("RPA"))
			{
				int rpa_copy = js.getInt("courses.copies["+i+"]");
						System.out.println("the no of copies sold by RPA is: "+rpa_copy);
						break;
			}
		}
	}

}
