package it.univpm.ProgettoOOP.Services;
import java.util.Timer;
import java.util.TimerTask; 

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
public class Parsing {
	
	
	
	Timer timer;
	
	
	public Parsing() {
		timer = new Timer();
		timer.schedule(new RemindTask(),3600000);
	} 
	class RemindTask extends TimerTask {
  boolean time2 = true;
		@Override
		public void run() {
		while(time2) {
	         	StartConnectionURLDaily daily = new StartConnectionURLDaily("ancona");
				
				JSONObject Obj = daily.startConnectionDaily();
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
				
				Weather weatSupport = new Weather ( time , speed , deg , gust , weather);
				Vector <Weather> weatVec = new Vector <Weather>();
				weatVec.add(weatSupport);
				
				Place weatherXPlaceDaily = new Place ( state , nameCity , weatVec);
				 weatherXPlaceDaily.getCity(); 
				 weatherXPlaceDaily.getWeatherXTime();
				 weatherXPlaceDaily.getState();
				 
			}
			
			
			
		}
			
			
			
		}
		   
		   
	   }
	/* 
	 * 
	 * timer.schedule(parsingConnDaily, 3600000); // esempio
	 * 
	 * 
	 */
	
	/**
	 * Method that parse the values written inside the
	 * currentWeather API
	 */
/*	public Place parsingConnDaily( JSONObject obj , String city) {
		
		StartConnectionURLDaily daily = new StartConnectionURLDaily( city);
		
		JSONObject Obj = daily.startConnectionDaily();
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
		
		Weather weatSupport = new Weather ( time , speed , deg , gust , weather);
		Vector <Weather> weatVec = new Vector <Weather>();
		weatVec.add(weatSupport);
		
		Place weatherXPlaceDaily = new Place ( state , nameCity , weatVec);
		return weatherXPlaceDaily;
		
	}
	
	public Place parsingConn5Days( JSONObject obj , String city) {
		return null;
	}
	
	


} */ 
   
   