package it.univpm.ProgettoOOP.Statistics;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.univpm.ProgettoOOP.Model.Place;

public class stat  {
	
	Place place;
	JSONObject obj = new JSONObject();
	
	public stat(Place place,JSONObject obj ) {
		this.place = place;
		this.obj = obj;
	}
	
	public double getWindMin(JSONObject obj ) {
		
		
	}
	
	public double getWindMax(JSONObject obj) {}

	public double getTempMin(JSONObject obj) {}
    
	public double gegtTempMax(JSONObject obj) {}
      
}
