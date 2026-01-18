package Payload;

import RestAssuredMainData.ResponseExtractor;
public class ResponseExtractorUpdatePayload 
{
	public static String updatePlace()
	{
		
		return "{\r\n"
				+ "    \"place_id\": \""+ResponseExtractor.place+"\",\r\n"
				+ "    \"address\": \"New Delhi\",\r\n"
				+ "    \"key\": \"qaclick123\"\r\n"
				+ "}";
	}

}



