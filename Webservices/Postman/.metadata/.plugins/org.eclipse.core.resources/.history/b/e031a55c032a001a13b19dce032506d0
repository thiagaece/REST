package servicenow;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidents_XML_Filter {

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
		
		//Get all incidents
		Response response = RestAssured
				.given()
				.accept(ContentType.XML)
				.get();
		
		//Check Status code
		int sCode = response.getStatusCode();
		System.out.println("Status Code is" + sCode);
		
		//response time
		long time = response.getTime();
		System.out.println("Response time is" +time);
		
		//Content type
		String contentType = response.getContentType();
		System.out.println("Content type is "+contentType);
		
		//print in proper format
		response.prettyPrint();
		
		//convert the response to JSON
		JsonPath jsonPath = response.jsonPath();
		
		//Print incidents
		List<String> incidentList = jsonPath.getList("result.number");
		System.out.println("Count of Incidents :"+ incidentList.size());
		
		for (String incident : incidentList) {
			System.out.println(incident);			
		}
		
		List<String> idList = jsonPath.getList("result.sys_id");
		
		for (String id : idList) {
			System.out.println(id);			
		}
		
	}
	
}
