package EndToEnd;

public class UpdateBody 
{
	
	public static String  Updatedata()
	{
		String pl_id = PostGetUpdate.placeId;
		
		return "{\r\n"
				+ "    \"place_id\": \""+pl_id+"\",\r\n"
				+ "    \"address\": \"Bhoot Bangla\",\r\n"
				+ "    \"key\": \"qaclick123\"\r\n"
				+ "}";
	}

}
