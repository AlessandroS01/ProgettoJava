package it.univpm.ProgettoOOP.Services;

import java.net.MalformedURLException; //
import java.net.URI;
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
	
