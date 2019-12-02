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

public class RestautantCollectionCityTest extends BaseTest implements ResponseCode{
	 private static final Logger logger= LoggerFactory.getLogger("Restaurant collection api tests");
	 CollectionsValidations restValidate = new CollectionsValidations();
	 
	
	 //Pass valid city_id and expect return of restaurants collections
	 @Test
	 public void getRestaurantCollectionsCity()
	 {
		logger.info("Fetch all the resturant collections based on valid city_id"); 
		RestAssured.baseURI = CollectionApiConfig.getHost();
		String uri = CollectionApiConfig.getCollectionsByCity("city_id1");
		Response response= ApiUtils.getApiResponse(OK,uri);
		restValidate.goodRequest(response);
		restValidate.validateCollectionsData(response);
	 }
	 
	
	  //Pass negative city_id and expect system does not return any collection
	  
	  @Test public void getRestaurantCollectionsNegativeId() {
	  logger.info("Fetch all the resturant collections based on valid city_id");
	  RestAssured.baseURI = CollectionApiConfig.getHost(); String uri =
	  CollectionApiConfig.getCollectionsByCity("city_id2"); Response response=
	  ApiUtils.getApiResponse(OK,uri); restValidate.goodRequest(response);
	  restValidate.validateEmptyCollections(response); }
	  
	  //Pass 0 for city_id and expect 400
	  
	  @Test public void getRestaurantCollectionsInvalidCity() {
	  logger.info("Fetch all the resturant collections based on valid city_id");
	  RestAssured.baseURI = CollectionApiConfig.getHost(); String uri =
	  CollectionApiConfig.getCollectionsByCity("city_id3"); Response response=
	  ApiUtils.getApiResponse(BAD_REQUEST,uri);
	  restValidate.validateBadRequests(response); }
	 
	 
}
