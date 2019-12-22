package com.company.project.validations;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import io.restassured.response.Response;
import utils.ApiUtils;

public class CollectionsValidations extends StatusCodeValidations {

	private static final Logger logger= LoggerFactory.getLogger("Collections api validation ");
	StatusCodeValidations validateCodes = new StatusCodeValidations();
	
	
    public boolean validateCollectionsData(Response response){
    	
        List<Map> collections = response.jsonPath().get("collections.collection");
        long nullCount = collections.stream().filter(collection -> collection.get("collection_id") == null || collection.get("share_url") == null).count();
        logger.info("Null value count in collcetions data-  "+nullCount);
        return nullCount==0;
    }
    
    public boolean validateEmptyCollections(Response response){
    	validateCodes.goodRequest(response);
    	return response.jsonPath().get("collections")==null;
        
    }
    
    public void validateBadRequests(Response response)
    {
		validateCodes.badRequest(response);
    }
    
    public void goodRequest(Response response)
    {
    	Assert.assertTrue(CommonValidations.isJSONValid(response.asString()),"The given String is not a valid JSON");
        validateCodes.goodRequest(response);
    }
    
    
}
