package it.univpm.ProgettoOOP.Services;

import java.net.MalformedURLException; // aggiunta per evitare errore sulla rixhiesta di malformed
import java.net.URI;


import org.json.simple.*;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;

import it.univpm.ProgettoOOP.Model.Meteo;

import java.io.*; // aggiunta per evitare errore su io exceptions

public class StartConnectionURLDaily extends StartConnectionURL{
	
	private final String urlDaily = "api.openweathermap.org/data/2.5/weather?";
	
	
	/* 
	   Method which opens up the API of OPENWEATHER about the current day.
	   Through the use of @client i send an HttpRequest based on the URI
	   written inside the brackets and the response is parsed inside the @Parsing class
	   trough @parse method
	*/
	
	public JSONObject startConnectionDaily ( String city )  {
		OkHttpClient client = new OkHttpClient();
	    Request request = new Request.Builder().url("http://" + urlDaily + "q=" + city + "&appid" + Key).build();
		try {
			Response response = client.newCall(request).execute();
			return new JSONObject(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		return null;
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
