package ComplexJsonParse4;

import io.restassured.path.json.JsonPath;

public class JsonParse4 
{
	public static void main(String args[])
	{
		JsonPath js = new JsonPath(PayloadData.payData());
		
		//Print no of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		
		//print purchase amount
		
		int pAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(pAmount);
		
		//Print title of the first Course
		
		String firstTitle = js.getString("courses[0].title");
		System.out.println(firstTitle);
		
		//print ALl Course title with respective prices
		
		for(int i=0;i<count;i++)
		{
			String title = js.getString("courses["+i+"].title");
			int price  = js.getInt("courses["+i+"].price");
			System.out.println("The tile of the course is :  "+title);
			System.out.println("The Price of the course is : "+price);
		}
	}
	
	
	


}
