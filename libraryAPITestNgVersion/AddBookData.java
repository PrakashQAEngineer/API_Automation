package libraryAPITestNgVersion;

public class AddBookData 
{
	public static String addBook(String isbn, String aisle)
	{
		return "{\r\n"
				+ "\"name\":\"Yoga with Jyoti\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"Jyoti Singh\"\r\n"
				+ "}\r\n"
				+ "";
	}

}
