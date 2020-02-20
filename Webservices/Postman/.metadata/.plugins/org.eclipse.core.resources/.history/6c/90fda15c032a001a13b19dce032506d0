package servicenow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllIncidents_XML {

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
		
		//get response in xml format method one 
				Response response = RestAssured.given().accept(ContentType.XML).get();
				//get response in xml format method two
				Response response1 = RestAssured.given().header(new Header("Accept", "application/xml")).get();


				//get response in xml format method three
				Map<String, String>  headers = new HashMap<String, String>();
				headers.put("Accept", "application/xml");
				Response response3 = RestAssured.given().headers(headers).get();

				//get response in xml format method one with particular param 

				Map<String, String> paramMap = new HashMap<String, String>();
				paramMap.put("category", "Network");
				paramMap.put("state", "-5");
				Response response4 = RestAssured.given().params(paramMap).accept(ContentType.XML).get();

				int responseCode = response.getStatusCode();

				String contentType = response.getContentType();

				System.out.println(contentType);

				XmlPath content = response.xmlPath();

				List<String> IncidentNumbers = content.getList("response.result.number");
				System.out.println(IncidentNumbers.size());

				
				XmlPath content2 = response4.xmlPath();
				
				List<String> IncidentNumbers1 = content2.getList("response4.result.number");
				System.out.println(IncidentNumbers1.size());
		
		
	}
	
}
