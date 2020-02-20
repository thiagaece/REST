package jira;

import java.io.File;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIssue {
	@Test
	public void createIssue() {
		RestAssured.baseURI = "https://thiaga1989.atlassian.net/rest/api/2/issue";
		RestAssured.authentication = RestAssured.preemptive().basic("thiagaece@gmail.com", "XHmcuUXEFfzQjbPjEnGDA572");
		
		File data = new File("./jiracreate.json");
		
		Response response = RestAssured
				.given()
				.header("Content-Type","application/json")
				.log().all()
				.body(data)
				.post();
		
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		if(statusCode == 201)
			System.out.println("Response is pass");
		else 
			System.out.println("Response is bad");
		
		
		JsonPath jsonPath = response.jsonPath();
		
		jsonPath.prettyPrint();
		 String id = jsonPath.get("result.id");
		 System.out.println(id);
		
		
	}

}

