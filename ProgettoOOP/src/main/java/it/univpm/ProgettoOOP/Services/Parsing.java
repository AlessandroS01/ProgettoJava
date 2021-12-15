package it.univpm.ProgettoOOP.Services;

import org.json.simple.*;

import it.univpm.ProgettoOOP.Model.Meteo;


public class Parsing {
	
	
	/* this method is used to parse the response obtained through the HttpClient
	   and the return is null because thenApply method requires a String parameter 
	   but in this case inside the @parse method there's no necessities to print 
	   a String as a return  
	*/
	public void parseWindTemp ( String response) {
		JSONObject wind = new JSONObject ();
		wind . get("wind");
		JSONObject temp = new JSONObject ();
		temp . get("main");
		Meteo weather = new Meteo ();
		
		int speed = (int) wind.get("speed");
		float degree = (float) wind.get("deg");
		
		double tempMin = (double) temp.get("temp_min");
		double tempMax = (double) temp.get("temp_max");
		double tempNow = (double) temp.get("feels_like");
		
		weather.setSpeedWind(speed);
		weather.setWindDegree(degree);
		weather.setTemperatureMin(tempMin);
		weather.setTemperatureMax(tempMax);
		weather.setTemperatureNow(tempNow);
	}
	


}
