package it.univpm.ProgettoOOP.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

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
	
	public JSONObject getWeatherDaily ( String city) {
		OkHttpClient client = new OkHttpClient();
		Request request =new Request.Builder().url("http://" + url5Days + "q=" + city + "&appid" + Key).build();
		try{
		Response response = client.newCall(request).execute();
		JSONObject caso;
		caso = new JSONObject(response.body().string());
		return JSONObject( response.body().string());
		} catch (IOException e ) {
			e.printStackTrace();
		}
		
		return null;
		/*	HttpRequest request = HttpRequest .newBuilder().uri(URI.create("http://" + url5Days + "q=" + city + "&appid" + Key)).build();
		HttpResponse response;
		try{
			response =  client.send(request,  HttpResponse.BodyHandlers.ofString());
			return new JSONObject(s);
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		*/
		//Parsing parse = new Parsing ();
		//return parse.parseWindTemp(response);
		
		/**
		   client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body); // <----- this line is needed to catch the informations of the API
		 
				//.thenApply(Parsing :: parse);
		
		Parsing parse = new Parsing ();
		return parse.parseWindTemp(response);
		*/
	}
	
}
