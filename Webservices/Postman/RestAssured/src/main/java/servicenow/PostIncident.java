package servicenow;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class PostIncident {

	@SuppressWarnings("unused")
	@Test
	public void getAllIncidents()
	{
		String URL = "https://dev77970.service-now.com/api/now/v2/table/change_request";
		String username = "admin";
		String passwd = "Thiaga1989$";
		
		//Endpoint
		RestAssured.baseURI = URL;
		
		//Authentication
		RestAssured.authentication = RestAssured.basic(username, passwd);
		
		File jsonFile = new File("postdata.json");
		 
		Response post = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(jsonFile)
				.post();		
	
		System.out.println(post.contentType());
		
		JsonPath response = post.jsonPath();
		String id = response.get("result.number");
		System.out.println("Created ID is "+id);
		
	}
	
}
