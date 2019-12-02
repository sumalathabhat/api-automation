package com.company.project.validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import io.restassured.response.Response;
import utils.ResponseCode;

public class StatusCodeValidations implements ResponseCode {
	
	private static final Logger logger = LoggerFactory.getLogger("This class validates all error responses");
 
	/* Method to validate all bad requests */
	public void goodRequest(Response response)
	{
		Assert.assertTrue((response.getStatusCode()== OK),response.jsonPath().getString("message"));	
	}
	
	/* Method to validate all bad requests */
	public void badRequest(Response response)
	{
		Assert.assertTrue((response.getStatusCode()== BAD_REQUEST),response.jsonPath().getString("message"));	
	}
	
	/* Method to validate all forbidden requests */
	public void forbidden(Response response)
	{
		Assert.assertTrue((response.getStatusCode()==FORBIDDEN), response.jsonPath().getString("message"));
	}
	
	/* Method to validate all GATEWAY_TIMEOUT requests */
	public void gatewayTimeout(Response response)
	{
		Assert.assertTrue((response.getStatusCode()==GATEWAY_TIMEOUT), response.jsonPath().getString("message"));

	}


}
