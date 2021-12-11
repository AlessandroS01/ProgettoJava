package it.univpm.ProgettoOOP.Services;


import java.io.*;
import java.net.*;
import org.json.simple.*;


public class StartConnectionURL {
	// both are final because we don't have to change their values
	private final String URL = "api.openweathermap.org/data/2.5/weather?";
	private final String Key = "ef3288292630c5a8c91c5b45de242182";
	// variable used to open the Url in the following methods
	private static HttpURLConnection connection;
	
	// method which opens up the API of OPENWEATHER about the current day 
	public void StartConnectionDaily ( String city) {
		
		try {
			// open up the URL and put what is written in the page
			// in an inputStream
			URL url = new URL (URL + "q=" + city + "&appid=" + Key);
			connection = (HttpURLConnection) url.openConnection();
			InputStream input ;
			input = connection.getInputStream();
			
			Reader reader = new InputStreamReader ( input);
			/*
			 * AGGIUNGERE METODI CHE MI VANNO A RIEMPIRE LE CLASSI 
			 */
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
			connection.disconnect();
			
		}
		
	}
	
	
	
	
	
}
