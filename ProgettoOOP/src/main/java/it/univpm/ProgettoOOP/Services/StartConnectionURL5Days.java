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



/**
 * Class which open the connection with the API.
 */
public class StartConnectionURL5Days extends StartConnectionURL {
	
	/**
	 * @param ulr5Days used to keep the initial part of the url
	 */
	private final String url5Days = "api.openweathermap.org/data/2.5/forecast?q=";
	
	/**
	 * Constructor of StartConnectionURL5Days class
	 */
	public StartConnectionURL5Days(String cityName) {
		super(cityName);
	}

	public JSONObject startConnection5Days() {
		String line = "";
		JSONObject json = null;
		String filter = "";
		
		URLConnection startConnection;
		try {
			startConnection = new URL("https://" + url5Days + getCityName() + "&units=metric&appid=" + Key).openConnection();
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
	
	
	/**
	 * Creare metodo che scriva in un file di testo le informazioni della'API
	 * di tipo forecast
	 */
}
	
