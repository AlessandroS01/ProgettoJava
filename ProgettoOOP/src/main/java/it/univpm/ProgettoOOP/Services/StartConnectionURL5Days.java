package it.univpm.ProgettoOOP.Services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.ProgettoOOP.Model.Weather;


/**
 * Class which open the connection with the API.
 */
public class StartConnectionURL5Days extends StartConnectionURL {
	
	private final String url5Days = "api.openweathermap.org/data/2.5/forecast?";

	
	/** 
	   Method which opens up the API of OPENWEATHER about the 5 days incoming.
	   Through the use of @client i send an HttpRequest based on the URI
	   written inside the brackets and the response is parsed inside the @Parsing class
	   trough @parse method
	 * @return 
	*/
	
	@Override
	public Weather startConnection ( String city) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest .newBuilder().uri(URI.create("http://" + url5Days + "q=" + city + "&appid" + Key)).build();
		HttpResponse response = (HttpResponse) client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
		Parsing parse = new Parsing ();
		return parse.parseWindTemp(response);
		
		/**
		   client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body); // <----- this line is needed to catch the informations of the API
		 
				//.thenApply(Parsing :: parse);
		
		Parsing parse = new Parsing ();
		return parse.parseWindTemp(response);
		*/
	}
	
}
