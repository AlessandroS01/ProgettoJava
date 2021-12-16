package it.univpm.ProgettoOOP.Services;

import java.net.MalformedURLException; // aggiunta per evitare errore sulla rixhiesta di malformed
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import it.univpm.ProgettoOOP.Model.Weather;
import java.io.*; // aggiunta per evitare errore su io exceptions

public class StartConnectionURLDaily extends StartConnectionURL{
	
	private final String urlDaily = "api.openweathermap.org/data/2.5/weather?";
	
	
	/** 
	*   Method which opens up the API of OPENWEATHER about the current day.
	*   Through the use of @client i send an HttpRequest based on the URI
	*   written inside the brackets and the response is parsed inside the @Parsing class
	*   trough @parse method
	*/
	@Override
	public Weather startConnection ( String city ) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest .newBuilder().uri(URI.create("http://" + urlDaily + "q=" + city + "&appid" + Key)).build();
		HttpResponse response = (HttpResponse) client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
			//	.thenApply(HttpResponse::body); // <----- this line is needed to catch the informations of the API
			//	.thenApply(Parsing :: parse); 
		Parsing parse = new Parsing ();
		return parse.parseWindTemp(response);
	}
	/*try {
	 * @manuel
	 * response = client.newCall(request).execute();
	 * return new JSONObject(response.body().string()); // metodo che ho trovato 
	 * 
	 * 
	 * 
	 * 
	 * 
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
