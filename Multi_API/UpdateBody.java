package Multi_API;

public class UpdateBody 
{
	
	
	public static String update()
	{
		
		
		String place = MultiAPI.pl_id;
		
	    return "{\r\n"
				+ "    \"place_id\": \""+place+"\",\r\n"
				+ "    \"address\": \"Rajinder prakash\",\r\n"
				+ "    \"key\": \"qaclick123\"\r\n"
				+ "}";
		
	}

}
