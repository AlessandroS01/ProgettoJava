package it.univpm.ProgettoOOP.Services;

import java.util.Timer;
import java.util.TimerTask;
import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.simple.*;




import org.json.*;


public class StartConnectionURL {
	
	/**
	 * @param Key is used to generate the API.
	 * @param cityName is used for instantiate the name of the city
	 */
	protected final String Key = "ef3288292630c5a8c91c5b45de242182";
	protected String cityName;
	


	public StartConnectionURL() {};
		
	

	
	public StartConnectionURL(String cityName) {
		this.cityName = cityName;
		if( cityName == null ) this.cityName = "ancona";
	}
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
	
	
	
}
	
	
	
	
