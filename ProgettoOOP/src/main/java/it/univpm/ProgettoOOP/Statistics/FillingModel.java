package it.univpm.ProgettoOOP.Statistics;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.univpm.ProgettoOOP.Exception.WrongFileException;
import it.univpm.ProgettoOOP.Model.Place;
import it.univpm.ProgettoOOP.Model.Weather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class FillingModel {
	
	private	String fileCurrentTime = "C:\\Users\\Lenovo\\git\\repository4\\ProgettoOOP\\src\\main\\resources\\ApiCallsByTime";
	private	String fileForecast = "C:\\Users\\Lenovo\\git\\repository4\\ProgettoOOP\\src\\main\\resources\\ApiForecast";
	private	Place placeCurrent ;
	private	Place placeForecast ;
	private Vector <Weather> weatXCurrentTime ;
	private Vector <Weather> weatXForecast ;
	
	

	public JSONObject readFile( String path) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileCurrentTime));
			String line = reader.readLine();
			JSONObject jsonObj = null ;
			while( line != null) {
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(line);
				jsonObj = (JSONObject) obj;
				
				line = reader.readLine();
			}
			return jsonObj;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void fillWeatXCurrentTime() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileCurrentTime));
			String line = reader.readLine();
			JSONObject obj = readFile(fileCurrentTime);
			JSONObject objWind;
			JSONArray objWeat;
			Weather support ;
			
			Long date;
			java.util.Date time;
			
			float speed;
			int deg;
			float gust;
			
			String weather;
			while( line != null ) {
				objWind = (JSONObject) obj.get("wind");
				objWeat = (JSONArray) obj.get("weather");
			
				date = (Long) obj.get("dt");
				time = new java.util.Date((long)date*1000);
			
				speed = (float) objWind.get("wind");
				deg = (int) objWind.get("deg");
				gust = (float) objWind.get("gust");
			
				weather = (String) objWeat.get(1);
				
				support = new Weather(time , speed , deg , gust , weather);
				this.weatXCurrentTime.add(support);
				
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void fillPlaceCurrent() {
		JSONObject obj = readFile(fileCurrentTime);
		
		JSONObject sys = (JSONObject) obj.get("sys");
		
		String city = (String) obj.get("name"); 
		String country = (String) sys.get("country");
		
		fillWeatXCurrentTime();
		
		this.placeCurrent= new Place(country , city, this.weatXCurrentTime);
		
	}


	public Place getPlaceCurrent() {
		return placeCurrent;
	}


	public void setPlaceCurrent(Place placeCurrent) {
		this.placeCurrent = placeCurrent;
	}


	public Place getPlaceForecast() {
		return placeForecast;
	}


	public void setPlaceForecast(Place placeForecast) {
		this.placeForecast = placeForecast;
	}
	

	
	
}
	


