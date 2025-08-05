package ComplexJsonParse4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SumAllCourse 
{
	
	@Test
	  public void SumAlCourse()
	  {
		JsonPath js = new JsonPath(PayloadData.payData());
		   int count = js.getInt("courses.size()");
		   int sum=0;
		   
		   System.out.println("The Size of the Course is: "+count);
		   
		   int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		   System.out.println("The purchase Amount is; "+purchaseAmount);
		   
		   for(int i=0; i<count;i++)
		   {
			   int price = js.getInt("courses["+i+"].price");
			   int copies = js.getInt("courses["+i+"].copies");
			   
			   System.out.println(price);
			   int finalPrice = price * copies;
			   sum = sum+finalPrice;
			   
		   }   
		   
		   System.out.println("The total no of price is: "+sum);	
		   Assert.assertEquals(purchaseAmount, sum);
		   
		   
		   
		
	  }

}
