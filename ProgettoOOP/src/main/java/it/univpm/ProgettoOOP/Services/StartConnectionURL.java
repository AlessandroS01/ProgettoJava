package it.univpm.ProgettoOOP.Services;


import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.simple.*;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import org.json.*;


/** This class is used as a model extended by :
 *  @StartConnectionURLDaily 
 *  @StartConnectionURL5Days
 */
public class StartConnectionURL {
	
	/**
	 * @param Key is used to generate the API.
	 * @param cityName is used for instantiate the name of the city
	 */
	protected final String Key = "ef3288292630c5a8c91c5b45de242182";
	protected String cityName;
	
	
	public StartConnectionURL(String cityName) {
		this.cityName = cityName;
	}
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
	
	
	
}
	
	
	
	
