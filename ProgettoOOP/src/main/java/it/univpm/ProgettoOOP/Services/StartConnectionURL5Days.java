package it.univpm.ProgettoOOP.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Service;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.*;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import it.univpm.ProgettoOOP.Model.Weather;


/**
 * Class which open the connection with the API.
 */
public class StartConnectionURL5Days extends StartConnectionURL {
	
	/**
	 * @param ulr5Days used to keep the initial part of the url
	 */
	private final String url5Days = "api.openweathermap.org/data/2.5/forecast?q=";


	
	/** 
	   Method which opens up the API of OPENWEATHER about the 5 days incoming.
	   Through the use of @client i send an HttpRequest based on the URI
	   written inside the brackets and the response is parsed inside the @Parsing class
	   trough @parse method
	 * @return 
	*/
	
/*	@Override
	public JSONObject startConnection ( String city) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest .newBuilder().uri(URI.create("http://" + url5Days + "q=" + city + "&appid" + Key)).build();
		Response response = (HttpResponse) client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
		Parsing parse = new Parsing ();
		return parse.parseWindTemp(response);
		
		/**
		   client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body); // <----- this line is needed to catch the informations of the API
		 
				//.thenApply(Parsing :: parse);
		
		Parsing parse = new Parsing ();
		return parse.parseWindTemp(response);
		*/

	/**
	 * Constructor of the class
	 */
	public StartConnectionURL5Days(String cityName) {
		super(cityName);
	}
	
	
	/**
	 *
	 */
	public JSONObject startConnection5Days() {
		String line = "";
		JSONObject json = null;
		String filter = "";
		
		URLConnection startConnection;
		try {
			startConnection = new URL(url5Days + getCityName() + "&units=metric&appid=" + Key).openConnection();
			InputStream in = startConnection.getInputStream();
			
			InputStreamReader reader = new InputStreamReader (in);
			BufferedReader readStream = new BufferedReader(reader);
			
			while ( (line = readStream.readLine()) != null) {
				filter += line;
			}
			
			in.close();
			json = (JSONObject) JSONValue.parseWithException(filter);
			
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		} catch (IOException e ) {
			e.printStackTrace();
		}
		
		return json;
		
	}
		
}
	
