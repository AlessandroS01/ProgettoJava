package it.univpm.ProgettoOOP.Services;


import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.*;



public class StartConnectionURL {
	// both are final because we should not change their values
	private final String URL_daily = "api.openweathermap.org/data/2.5/weather?";
	private final String Key = "ef3288292630c5a8c91c5b45de242182";
	// variable used to open the Url in the following methods
	/*private static HttpURLConnection connection;
	*/
	
	/* 
	   Method which opens up the API of OPENWEATHER about the current day.
	   Through the use of @client i send an HttpRequest based on the URI
	   written inside the brackets and the response is parsed inside the @Parsing class
	   trough @parse method
	*/
	public void StartConnectionDaily ( String city) {
		
		HttpClient client = HttpClient.newHttpClient ();
		HttpRequest request = HttpRequest .newBuilder().uri(URI.create("http://" + URL_daily + "q=" + city + "&appid" + Key)).build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body) // <----- this line is needed to catch the informations of the API
			.thenApply(Parsing :: parse); 
		/*try {
			// open up the URL and put what is written in the page
			// in an inputStream
			URL url = new URL (URL + "q=" + city + "&appid=" + Key);
			connection = (HttpURLConnection) url.openConnection();
			InputStream input ;
			input = connection.getInputStream();
			
			Reader reader = new InputStreamReader ( input);
			
			
			////// AGGIUNGERE METODI CHE MI VANNO A RIEMPIRE LE CLASSI 
			 
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
			connection.disconnect();
			
		}
		*/
	}
	
	
	
	
	
}
