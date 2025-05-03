package Files;

public class Payload 
{
	public  String addPlace()
	{
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427369\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Sparsh Yog\",\r\n"
				+ "  \"phone_number\": \"(+91) 7381490634\",\r\n"
				+ "  \"address\": \"Rajinder nagar\",\r\n"
				+ "  \"types\": [\r\n"
				+ "      \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
	}
   
	public static void main(String args[])
	{
		Payload p1 = new Payload();
		p1.addPlace();
	}
}
