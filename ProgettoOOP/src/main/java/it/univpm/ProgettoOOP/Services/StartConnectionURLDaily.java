package it.univpm.ProgettoOOP.Services;

import java.net.MalformedURLException; //
import java.net.URI;



import org.json.simple.*;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;

import it.univpm.ProgettoOOP.Model.Meteo;


import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import it.univpm.ProgettoOOP.Model.Weather;
import java.io.*; // aggiunta per evitare errore su io exceptions

public class StartConnectionURLDaily extends StartConnectionURL{
	
	/**
	 * @param urlDaily used to keep the initial part of the url
	 */
	private final String urlDaily = "api.openweathermap.org/data/2.5/weather?q=";
	

	
	/* 
	   Method which opens up the API of OPENWEATHER about the current day.
	   Through the use of @client i send an HttpRequest based on the URI
	   written inside the brackets and the response is parsed inside the @Parsing class
	   trough @parse method
	*/
	
	/*public JSONObject startConnectionDaily ( String city )  {
		OkHttpClient client = new OkHttpClient();
	    Request request = new Request.Builder().url("http://" + urlDaily + "q=" + city + "&appid" + Key).build();
		try {
			Response response = client.newCall(request).execute();
			return new JSONObject(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		return null;*/

	/**
	 * Constructor of the class
	 */
	public StartConnectionURLDaily(String cityName) {
		super(cityName);
	}
	
	public JSONObject startConnectionDaily() {
		String line = "";
		JSONObject json = null;
		String filter = "";
		
		URLConnection startConnection;
		try {
			startConnection = new URL(urlDaily + getCityName() + "&units=metric&appid=" + Key).openConnection();
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
	
