package it.univpm.ProgettoOOP.Services;


import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.*;



public class StartConnectionURL {
	// is final because we should not change its value
	protected final String Key = "ef3288292630c5a8c91c5b45de242182";
	
	/* 
	   Method which opens up the API of OPENWEATHER about the current day.
	   Through the use of @client i send an HttpRequest based on the URI
	   written inside the brackets and the response is parsed inside the @Parsing class
	   trough @parse method
	*/
	public void startConnection ( String city ) {
	}
		
		//return HttpRequest .newBuilder().uri(URI.create("http://" + url + "q=" + city + "&appid" + Key)).build();
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
	
	
	
	
