package it.univpm.ProgettoOOP.Services;

import java.net.MalformedURLException; //
import java.net.URI;



import org.json.simple.*;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import it.univpm.ProgettoOOP.Model.Weather;
import java.io.*; 

public class StartConnectionURLCurrent extends StartConnectionURL{
	
	/**
	 * @param urlDaily used to keep the initial part of the url
	 */
	private final String urlCurrent = "api.openweathermap.org/data/2.5/weather?q=";
	
	/**
	 * Constructor of the class
	 */
	public StartConnectionURLCurrent(String cityName) {
		super(cityName);
	}
	
	
	/**
	 * Open and the start the connection between user and localhost. 
	 * @return the JSONObject written inside the API.
	 */
	public JSONObject startCurrentConnection() {
		String line = "";
		JSONObject json = null;
		String filter = "";
		
		URLConnection startConnection;
		try {
			startConnection = new URL("https://" + urlCurrent + getCityName() + "&units=metric&appid=" + Key).openConnection();
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
	
