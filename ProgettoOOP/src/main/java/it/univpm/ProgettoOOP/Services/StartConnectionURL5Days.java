package it.univpm.ProgettoOOP.Services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StartConnectionURL5Days extends StartConnectionURL {
	
	private final String url5Days = "api.openweathermap.org/data/2.5/forecast?";
	
	
	/* 
	   Method which opens up the API of OPENWEATHER about the 5 days incoming.
	   Through the use of @client i send an HttpRequest based on the URI
	   written inside the brackets and the response is parsed inside the @Parsing class
	   trough @parse method
	*/
	@Override
	public void startConnection ( String city) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest .newBuilder().uri(URI.create("http://" + url5Days + "q=" + city + "&appid" + Key)).build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body); // <----- this line is needed to catch the informations of the API
				//.thenApply(Parsing :: parse);
	}
}
