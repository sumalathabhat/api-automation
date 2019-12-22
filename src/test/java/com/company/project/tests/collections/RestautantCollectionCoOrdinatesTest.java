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


	 //Pass valid city co-ordinates (+ve, +ve) and expect return of restaurants collections
	 @Test
	 public void getRestaurantCollectionsPositivePositiveCoOrdinates()
	 {
		logger.info("Fetch all the resturant collections based on valid coordinates(+, +)"); 
		RestAssured.baseURI = CollectionApiConfig.getHost();
		String uri = CollectionApiConfig.getCollectionsByCoOrdinates("latitude" , "longitude");
		Response response= ApiUtils.getApiResponse(OK,uri);
		restValidate.goodRequest(response);
		restValidate.validateCollectionsData(response);
	 }

	//Pass valid city co-ordinates(-ve, +ve) and expect return of restaurants collections
	 @Test
	 public void getRestaurantCollectionsNegativePositiveCoOrdinates()
	 {
		logger.info("Fetch all the resturant collections based on valid coordinates(-, +)"); 
		RestAssured.baseURI = CollectionApiConfig.getHost();
		String uri = CollectionApiConfig.getCollectionsByCoOrdinates("latitude2" , "longitude2");
		Response response= ApiUtils.getApiResponse(OK,uri);
		restValidate.goodRequest(response);
		restValidate.validateCollectionsData(response);
	 }


 	//Pass valid city co-ordinates(+ve, -ve) and expect return of restaurants collections
	 @Test
	 public void getRestaurantCollectionsPositiveNegativeCoOrdinates()
	 {
		logger.info("Fetch all the resturant collections based on valid coordinates(+, -)"); 
		RestAssured.baseURI = CollectionApiConfig.getHost();
		String uri = CollectionApiConfig.getCollectionsByCoOrdinates("latitude3" , "longitude3");
		Response response= ApiUtils.getApiResponse(OK,uri);
		restValidate.goodRequest(response);
		restValidate.validateCollectionsData(response);
	 }
	
	
	//Pass valid city co-ordinates(-ve, -ve) and expect return of restaurants collections
	 @Test
	 public void getRestaurantCollectionsNegativeNegativeCoOrdinates()
	 {
		logger.info("Fetch all the resturant collections based on valid coordinates(-, -)"); 
		RestAssured.baseURI = CollectionApiConfig.getHost();
		String uri = CollectionApiConfig.getCollectionsByCoOrdinates("latitude4" , "longitude4");
		Response response= ApiUtils.getApiResponse(OK,uri);
		restValidate.goodRequest(response);
		restValidate.validateCollectionsData(response);
	 }
	 
	 //Pass invalid city co-ordinates (i.e. coordinates of Thar desert or something which is basically not a proper city) and expect 400
	 @Test
	 public void getRestaurantCollectionsInvalidCoOrdinates()
	 {
		logger.info("Fetch all the resturant collections based on invalid coordinates"); 
		RestAssured.baseURI = CollectionApiConfig.getHost();
		String uri = CollectionApiConfig.getCollectionsByCoOrdinates("latitude5" , "longitude5");
		Response response= ApiUtils.getApiResponse(BAD_REQUEST,uri);
		restValidate.validateBadRequests(response);
	 }
	 
	 //Pass city co-ordinates as String and expect 400
	 @Test
	 public void getRestaurantCollectionsInvalidCoOrdinates()
	 {
		logger.info("Fetch all the resturant collections based on coordinates given as string"); 
		RestAssured.baseURI = CollectionApiConfig.getHost();
		String uri = CollectionApiConfig.getCollectionsByCoOrdinates("latitude6" , "longitude6");
		Response response= ApiUtils.getApiResponse(BAD_REQUEST,uri);
		restValidate.validateBadRequests(response);
	 }
	 
	 //valid lo kuda okko quadrant ki oka sari test chesamu. kani oka quadrant lo multiple tests cheste better reliability vastundi.
	

}
