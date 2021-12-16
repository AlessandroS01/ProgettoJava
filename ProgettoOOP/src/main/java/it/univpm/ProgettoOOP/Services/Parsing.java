package it.univpm.ProgettoOOP.Services;

import java.net.http.HttpResponse;
import java.util.Map;

import org.json.simple.*;

import it.univpm.ProgettoOOP.Model.Place;
import it.univpm.ProgettoOOP.Model.Weather;


public class Parsing {
	
	/** 
	*  Used to parse the response obtained through the HttpClient
	*/
	public Weather parseWindTemp ( HttpResponse response) {
		JSONObject wind = (JSONObject) response.body();
		wind . get("wind");
		JSONObject sys = (JSONObject) response.body();
		sys . get("sys");
		JSONObject weath = (JSONObject) response.body();
		weath . get("weather");
		Place weather;
		
		float speed = (int) wind.get("speed");
		int degree = (int) wind.get("deg");
		float gust = (float) wind.get("gust");
		
		String country = (String) sys.get("country");
		String city = (String) sys.get("name");
		
		String main = (String) weath.get("main");
		
		weather = new Place (speed , degree, gust , main , country , city);
		return weather ;
	}
	


}
