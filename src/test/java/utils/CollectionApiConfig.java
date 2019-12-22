package utils;

import java.util.ResourceBundle;

public class CollectionApiConfig extends ApiConfig {
	
	private static ResourceBundle resourceBundle=ResourceBundle.getBundle("configs/collections");
    final static String path = resourceBundle.getString("collectionsPath");

	public static String getCollectionsByCity(String city){
		return String.format(path+resourceBundle.getString("query_by_city"), resourceBundle.getString(city));
       
    }
	
	public static String getCollectionsByCoOrdinates(String lat , String lon){
		return String.format(path+resourceBundle.getString("query_by_co_ordinates"), resourceBundle.getString(lat), resourceBundle.getString(lon));
    }
	
	public static String getCollectionsCount(String city, String count){
		return String.format(path+resourceBundle.getString("query_by_count"), resourceBundle.getString(city), resourceBundle.getString(count));
       
    }
}
