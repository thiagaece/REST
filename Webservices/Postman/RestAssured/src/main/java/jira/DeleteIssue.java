package jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIssue {
	@Test
	public void deleteIssue() {
		RestAssured.baseURI = "https://thiaga1989.atlassian.net/rest/api/2/issue/10003";
		RestAssured.authentication = RestAssured.preemptive().basic("thiagaece@gmail.com", "XHmcuUXEFfzQjbPjEnGDA572");
		
		Response response = RestAssured
				.given()
				.header("Content-Type","application/json")
				.log().all()
				.delete();
		
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		if(statusCode == 204)
			System.out.println("Issue has been deleted successfully");
		else 
			System.out.println("Issue is not deleted");
		
		
	}

}

