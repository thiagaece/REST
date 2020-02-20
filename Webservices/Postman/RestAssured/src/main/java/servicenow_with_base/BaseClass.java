package servicenow_with_base;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	public static String CQ_ID;
	public static RequestSpecification header;
	
	@BeforeSuite
	public void init()
	{
		String URL = "https://dev77970.service-now.com/api/now/v2/table/change_request";
		String username = "admin";
		String passwd = "Thiaga1989$";
		
		//Endpoint
		RestAssured.baseURI = URL;
		
		//Authentication
		RestAssured.authentication = RestAssured.basic(username, passwd);
		
		header = RestAssured.given();
	}

}
