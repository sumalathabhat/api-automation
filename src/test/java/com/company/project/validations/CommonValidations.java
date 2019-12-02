package com.company.project.validations;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import io.restassured.response.Response;

public class CommonValidations {

	static Logger logger= LoggerFactory.getLogger("Class that can contain common validations across tests");
	 public static boolean isJSONValid(String test) {
	        try {
	            new JSONObject(test);
	        } catch (JSONException ex) {
	            try {
	                new JSONArray(test);
	            } catch (JSONException ex1) {
	                return false;
	            }
	        }
	        return true;
	    }
	 
	 public static void validatejson(Response response)
	 {
		 Assert.assertTrue(isJSONValid(response.asString()),"The given String is not a valid JSON");
	 }
	 
}
