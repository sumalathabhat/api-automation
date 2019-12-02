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

public class RestautantCollectionCoOrdinatesTest extends BaseTest implements ResponseCode{
	 private static final Logger logger= LoggerFactory.getLogger("Restaurant collection api tests");
	 CollectionsValidations restValidate = new CollectionsValidations();
	 
	
	 //Pass valid city co-ordinates and expect return of restaurants collections
	 @Test
	 public void getRestaurantCollectionsCoOrdinates()
	 {
		logger.info("Fetch all the resturant collections based on valid city_id"); 
		RestAssured.baseURI = CollectionApiConfig.getHost();
		String uri = CollectionApiConfig.getCollectionsByCoOrdinates("latitude" , "longitude");
		Response response= ApiUtils.getApiResponse(OK,uri);
		restValidate.goodRequest(response);
		restValidate.validateCollectionsData(response);
	 }
	 
	//Pass valid city co-ordinates(southern hemisphere) and expect system collection
	 @Test
	 public void getRestaurantCollectionsNegativeCoOrdinates()
	 {
		logger.info("Fetch all the resturant collections based on valid city_id"); 
		RestAssured.baseURI = CollectionApiConfig.getHost();
		String uri = CollectionApiConfig.getCollectionsByCoOrdinates("latitude2" , "longitude2");
		Response response= ApiUtils.getApiResponse(OK,uri);
		restValidate.goodRequest(response);
		restValidate.validateCollectionsData(response);
	 }
	 
	 
	 
}
