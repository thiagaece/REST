package servicenow_with_base;

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
import io.restassured.specification.RequestSpecification;

public class PostIncident extends BaseClass{

	@SuppressWarnings("unused")
	@Test
	public void createIncident()
	{
		//@BeforeSuite runs first
		File jsonFile = new File("postdata.json");
		 
		Response post = header.contentType(ContentType.JSON)
				.body(jsonFile)
				.post();		
	
		System.out.println(post.contentType());
		
		JsonPath response = post.jsonPath();
		CQ_ID = response.get("result.number");
		System.out.println("Created ID is "+CQ_ID);
		
	}
	
}
