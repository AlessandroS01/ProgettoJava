package it.univpm.ProgettoOOP.Statistics;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.univpm.ProgettoOOP.Model.Place;

public class stat  {
	
   private Vector <Place> place = new Vector<Place>();
   private JSONObject obj = new JSONObject();
	
	public stat( Vector <Place> place,JSONObject obj ) {
		this.place = place;
		this.obj = obj;
	}
	
	/*public double getWindMin(JSONObject obj ) {
	}
	
	public double getWindMax(JSONObject obj) {}

	public double getTempMin(JSONObject obj) {}
    
	public double gegtTempMax(JSONObject obj) {}
     */ 
}
