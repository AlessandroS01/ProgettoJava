package it.univpm.ProgettoOOP.Statistics;

import java.util.Locale;
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
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;


/**
 * Class that aims to create and fill the @package Model.
 */
public class FillingModel {
	
	/**
	 *	@param fileCurrentTime and fileForecast are the paths for the local files.
	 *  @param placeCurrent uses
	 *  	@param weatXCurrentTime and they're used to take and store informations written in 
	 *  	the local file ApiCallsByTime
	 *  @param placeForecast uses
	 *  	@param weatXForecast and they're used to take and store informations written in 
	 *  	the local file ApiForecast
	 *  
	 */
	private	String fileCurrentTime = "C:\\Users\\Lenovo\\git\\repository4\\ProgettoOOP\\src\\main\\resources\\ApiCallsByTime";
	private	String fileForecast = "C:\\Users\\Lenovo\\git\\repository4\\ProgettoOOP\\src\\main\\resources\\ApiForecast";
	private	Place placeCurrent ;
	private	Place placeForecast ;
	private Vector <Weather> weatXCurrentTime = new Vector <Weather>();
	private Vector <Weather> weatForecast = new Vector <Weather>();
	
	/**
	 * Method which create the String Date from the @param seconds given by the API
	 * @return the right date in which the user call the API 
	 * 
	 */
	public String dtToTime( long seconds) {
		LocalDateTime dateTime = LocalDateTime.ofEpochSecond(seconds, 0, ZoneOffset.ofHours(1));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE,MMMM d,yyyy h:mm,a", Locale.ENGLISH);
		return dateTime.format(formatter);
	}
	
	/**
	 * Method that aims to open and read both local files.
	 * @return Vector <JSONObject> which are stored in the local file 
	 */
	public Vector <JSONObject> readFile( String path) {
		Vector <JSONObject> jsonObj = new Vector <JSONObject> (); 
		JSONParser parser = new JSONParser();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileCurrentTime));
			String line = reader.readLine();
			JSONObject jsonAppoggio = null ;
			Object obj;
			
			while( line != null) {
				obj = parser.parse(line);
				jsonAppoggio = (JSONObject) obj;
				jsonObj.add(jsonAppoggio);
				
				line = reader.readLine();
			}
		}catch(Exception e) {
		System.out.println("daje");
		}
		return jsonObj;
	}
	
	/**
	 * Method which sets the Vector weatXCurrentTime
	 * @return weatXCurrentTime but with values found int ApiCallsByTime
	 */
	public Vector <Weather> fillWeatXCurrentTime() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileCurrentTime));
			String line = reader.readLine();
			Vector <JSONObject> obj = readFile(fileCurrentTime);
			JSONObject objWind;
			JSONArray objWeat;
			JSONObject objWeather;
			Weather support ;
			
			Long date;
			String time;
			
			double speed;
			long deg;
			double gust;
			
			String weather;
			
			for (int i = 0 ; line!=null ; i++) {
				objWind = (JSONObject) obj.get(i).get("wind");
				objWeat = (JSONArray) obj.get(i).get("weather");
				objWeather = (JSONObject) objWeat.get(0);
				
				date = (Long) obj.get(i).get("dt");
				time = dtToTime(date);
			
			
				weather = (String) objWeather.get("main");
				
				if ( (double) objWind.get("gust") != 0 ) 
					gust = (double) objWind.get("gust");
				else gust = 0;
				
				if( (double) objWind.get("speed") != 0 )
					speed = (double) objWind.get("speed");
				else speed = 0;

				if( (long) objWind.get("deg") != 0 )
					deg = (long) objWind.get("deg");
				else deg = 0;
				
				
				support = new Weather(time , speed , deg , gust , weather);
				weatXCurrentTime.add(support);
				
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return this.weatXCurrentTime;
		
	}
	
	/**
	 * Method that sets values to placeCurrent.
	 * It calls @method fillWeatXCurrentTime() for doing that because 
	 * placeCurrent has a Vector of Weather as attribute
	 * @return placeCurrent with the values written inside ApiCallsByTime 
	 */
	public Place fillPlaceCurrent() {
		Vector <JSONObject> obj = readFile(fileCurrentTime);
		
		JSONObject sys = (JSONObject) obj.firstElement().get("sys");
	
		String city = (String) obj.firstElement().get("name"); 
		String country = (String) sys.get("country");
		
		fillWeatXCurrentTime();
		
		this.placeCurrent= new Place(country , city, this.weatXCurrentTime);
		return placeCurrent;
	}

	/**
	 * Method which sets the Vector weatXCurrentTime
	 * @return weatXCurrentTime but with values found int ApiCallsByTime
	 */
	public Vector <Weather> fillWeatForecast(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileCurrentTime));
			String line = reader.readLine();
			Vector <JSONObject> obj = readFile(fileCurrentTime);
			JSONObject objWind;
			JSONArray objWeat;
			JSONObject objWeather;
			Weather support ;
			
			Long date;
			String time;
			
			double speed;
			long deg;
			double gust;
			
			String weather;
			
			for (int i = 0 ; line!=null ; i++) {
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return this.weatForecast;
		
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
	public String getFileCurrentTime() {
		return fileCurrentTime;
	}
	public void setFileCurrentTime(String fileCurrentTime) {
		this.fileCurrentTime = fileCurrentTime;
	}
	public String getFileForecast() {
		return fileForecast;
	}
	public void setFileForecast(String fileForecast) {
		this.fileForecast = fileForecast;
	}
	
	
	
	
}
	


