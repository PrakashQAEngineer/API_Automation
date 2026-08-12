package ComplexJson1;

import io.restassured.path.json.JsonPath;

public class ComplexJsonPath 
{
	public static void main(String args[])
	{
		
		JsonPath js = new JsonPath(ComplexJsonData.cmData());
		int tot_price = 0;
		int tot_cop = 0;
		int sum=0;
			
			int courses = js.getInt("courses.size()");
			System.out.println("The no. of courses are: "+courses);
			
			int puramount = js.getInt("dashboard.purchaseAmount");
			System.out.println("The purchase amount is: "+puramount);
			
			String getfsttitle = js.getString("courses.title[0]");
			System.out.println("The title of the first course is: "+getfsttitle);
			
			// Print All course titles and their respective Prices
			
			int price=0;
			String title = "";
			
			for(int i=0;i<courses;i++)
			{
				title = js.getString("courses.title["+i+"]");
				price = js.getInt("courses.price["+i+"]");
				
				System.out.println("The course is: "+title+ " and the price is: "+price);
			}
			
			//Print no of copies sold by RPA Course
			
		for(int i=0;i<courses;i++)
		{
			if(js.getString("courses.title["+i+"]").equalsIgnoreCase("RPA"))
			{
				int rpa = js.getInt("courses.copies["+i+"]");
				System.out.println("RPA copoes sold are: "+rpa);
				break;
			}
		}
		
		//Verify if Sum of all Course prices matches with Purchase Amount
		
		for(int i=0;i<courses; i++)
		{
			tot_price = js.getInt("courses.price["+i+"]");
			tot_cop = js.getInt("courses.copies["+i+"]");
			sum = sum + tot_price*tot_cop;
		}
		
		if(sum==puramount)
			System.out.println("The sum and Purchase amount is same"+sum);
	}
	

}
