package it.univpm.ProgettoOOP.Services;
 

import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Vector;

import org.json.simple.*;

import it.univpm.ProgettoOOP.Model.Place;
import it.univpm.ProgettoOOP.Model.Weather;

/**
 * Class that parse and instantiate the values 
 * written in the API in our model
 */


		
		
	         	


	
	
	/**
	 * Method that parse the values written inside the
	 * currentWeather API
	 */
	 public class Parsing {
		 
		 
	
   

	public Place parsingConnDaily( JSONObject obj , String city) {
		
		StartConnectionURLCurrent daily = new StartConnectionURLCurrent( city);
		
		JSONObject Obj = daily.startCurrentConnection();
		JSONObject ObjWind = (JSONObject) Obj.get("wind");
		JSONArray Arr = new JSONArray(); 
		
		Arr = (JSONArray) Obj.get("weather");
		
		String state = (String) Obj.get("country");
		String nameCity = (String) Obj.get("name");
		
		Long date = (Long) Obj.get("dt");
		java.util.Date time = new java.util.Date((long)date*1000);
		
		float speed = (float) ObjWind.get("wind");
		int deg = (int) ObjWind.get("deg");
		float gust = (float) ObjWind.get("gust");
		
		String weather = (String) Arr.get(2);
		
		Weather weat = new Weather ( time , speed , deg , gust , weather);
		
		Place weatherXPlaceDaily = new Place ( state , nameCity , weat);
		return weatherXPlaceDaily;
		
		}
	

	public Place parsingConn5Days( JSONObject obj , String city) {
		return null;
	}
	
	


} 
  


   
   