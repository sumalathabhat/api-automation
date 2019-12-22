package com.company.project.tests.collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.company.project.tests.BaseTest;
import com.company.project.validations.CollectionsValidations;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ApiUtils;
import utils.CollectionApiConfig;
import utils.ResponseCode;

public class RestautantCollectionCounts extends BaseTest implements ResponseCode{
	 private static final Logger logger= LoggerFactory.getLogger("Restaurant collection api tests (by count)");
	 CollectionsValidations restValidate = new CollectionsValidations();

	//Set count =5 and expect valid collections
	 @Test
	 public void getRestaurantCollectionsCount()
	 {
		logger.info("Fetch all the resturant collections based on valid city_id and count"); 
		RestAssured.baseURI = CollectionApiConfig.getHost();
		String uri = CollectionApiConfig.getCollectionsCount("city_id1","count1");
		Response response= ApiUtils.getApiResponse(OK,uri);
		restValidate.goodRequest(response); //valid json aa kada chusthunnadu
		restValidate.validateCollectionsData(response);

	 }

	//Set count =0, expect empty collections list
	 @Test
	 public void getRestaurantCollectionsEmptyCount()
	 {
		logger.info("Fetch all the resturant collections based on valid city_id and count =0"); 
		RestAssured.baseURI = CollectionApiConfig.getHost();
		String uri = CollectionApiConfig.getCollectionsCount("city_id1","count2");
		Response response= ApiUtils.getApiResponse(OK,uri);
		restValidate.validateEmptyCollections(response);
	 }

	 
	 //Set count=null and expect empty collections
	 @Test
	 public void getRestaurantCollectionsInvalidCount()
	 {
		logger.info("Fetch all the resturant collections based on valid city_id and count =null"); 
		RestAssured.baseURI = CollectionApiConfig.getHost();
		String uri = CollectionApiConfig.getCollectionsCount("city_id1","count3");
		Response response= ApiUtils.getApiResponse(OK,uri);
		restValidate.validateEmptyCollections(response);
	 }
	 

	//Set count=-1 and expect empty collections
	 @Test
	 public void getRestaurantCollectionsNegativeCount()
	 {
		logger.info("Fetch all the resturant collections based on valid city_id and count =-1"); 
		RestAssured.baseURI = CollectionApiConfig.getHost();
		String uri = CollectionApiConfig.getCollectionsCount("city_id1","count4");
		Response response= ApiUtils.getApiResponse(OK,uri);
		restValidate.validateEmptyCollections(response);
	 }
	 
	 //If the count being passed is greater than number of available restaurants expect empty collections list (Assumption.)
	 @Test
	 public void getRestaurantCollectionsCountMoreThanAvailable()
	 {
		logger.info("Fetch all the resturant collections based on valid city_id and count > available restaurants"); 
		RestAssured.baseURI = CollectionApiConfig.getHost();
		String uri = CollectionApiConfig.getCollectionsCount("city_id1","count5");
		Response response= ApiUtils.getApiResponse(OK,uri);
		restValidate.validateEmptyCollections(response);
	 }
	 
	 //pass invalid cityId with count = 5 and expect 400
	 @Test
	 public void getRestaurantCollectionsInvalidCityCount()
	 {
		logger.info("Fetch all the resturant collections based on invalid city_id and count = 5"); 
		RestAssured.baseURI = CollectionApiConfig.getHost();
		String uri = CollectionApiConfig.getCollectionsCount("city_id2","count1");
		Response response = ApiUtils.getApiResponse(BAD_REQUEST,uri);
	  	restValidate.validateBadRequests(response);
	 }
	 
	 
	 	 
	 //count to be checked across coordinates??? like it was checked across cityId in the above. just To cover all possible scenarios & test cases???
	 
}
