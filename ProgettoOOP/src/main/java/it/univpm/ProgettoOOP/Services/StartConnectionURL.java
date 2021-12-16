package it.univpm.ProgettoOOP.Services;


import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.*;

import it.univpm.ProgettoOOP.Model.Weather;


/** This class is used as a model extended by :
 *  @StartConnectionURLDaily 
 *  @StartConnectionURL5Days
 */
public class StartConnectionURL {
	
	/**
	 * @param Key is used to generate the API.
	 */
	protected final String Key = "ef3288292630c5a8c91c5b45de242182";
	

	public Weather startConnection ( String city ) {
		return null;
	}
	
}
	
	
	
	
