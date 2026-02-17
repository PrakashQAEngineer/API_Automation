package dynamicJsonPayloadData;

public class payload1 
{
	 public static String payDynamic(String isbn,String aisle)
	 {
		 return "{\r\n"
		 		+ "\"name\":\"Learn Selenium Automation with Java\",\r\n"
		 		+ "\"isbn\":\""+isbn+"\",\r\n"
		 		+ "\"aisle\":\""+aisle+"\",\r\n"
		 		+ "\"author\":\"Prakash Singh\"\r\n"
		 		+ "}\r\n"
		 		+ "";
	 }

}
