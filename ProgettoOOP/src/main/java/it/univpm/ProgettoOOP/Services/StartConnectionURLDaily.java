package it.univpm.ProgettoOOP.Services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StartConnectionURLDaily extends StartConnectionURL{
	
	private final String urlDaily = "api.openweathermap.org/data/2.5/weather?";
	
	@Override
	public void startConnection ( String city ) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest .newBuilder().uri(URI.create("http://" + urlDaily + "q=" + city + "&appid" + Key)).build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body) // <----- this line is needed to catch the informations of the API
				.thenApply(Parsing :: parse);
	}


	
}
