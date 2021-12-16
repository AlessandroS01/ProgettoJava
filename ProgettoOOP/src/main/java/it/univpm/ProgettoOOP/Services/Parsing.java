package it.univpm.ProgettoOOP.Services;

import java.net.http.HttpResponse;
import java.util.Map;

import org.json.simple.*;

import it.univpm.ProgettoOOP.Model.Localita;
import it.univpm.ProgettoOOP.Model.Meteo;


public class Parsing {
	
	
	/** 
	*  Used to parse the response obtained through the HttpClient
	*/
	public Meteo parseWindTemp ( HttpResponse response) {
		JSONObject wind = (JSONObject) response.body();
		wind . get("wind");
		JSONObject sys = (JSONObject) response.body();
		sys . get("sys");
		Localita weather;
		
		int speed = (int) wind.get("speed");
		float degree = (float) wind.get("deg");
		
		String country = (String) sys.get("country");
		String city = (String) sys.get("name");
		
		weather = new Localita ( speed, degree, country, city);
		return weather ;
	}
	


}
