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
 * Class that aims to create objects of Place and fill them.
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
	 */
	private	String fileCurrentTime = "C:\\Users\\manue\\Desktop\\demoprogettojava\\ProgettoJava2\\ProgettoOOP\\src\\main\\resources\\ApiCallsByTime";
	private	String fileForecast = "C:\\Users\\manue\\Desktop\\demoprogettojava\\ProgettoJava2\\ProgettoOOP\\src\\main\\resources\\ApiForecast";
	private	Place placeCurrent ;
	private	Place placeForecast ;
	private Vector <Weather> weatXCurrentTime = new Vector <Weather>();
	private Vector <Weather> weatForecast = new Vector <Weather>();
	
	
	/**
	 * Method which create the String Date from the @param seconds given by the API
	 * @return the right date in which the user call the API 
	 */
	public String dtToTime( long seconds) {
		LocalDateTime dateTime = LocalDateTime.ofEpochSecond(seconds, 0, ZoneOffset.ofHours(1));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE,MMMM d,yyyy h:mm,a", Locale.ENGLISH);
		return dateTime.format(formatter);
	}
	
	
	/**
	 * Method that aims to open and read @file ApiCallsByTime.
	 * @return Vector <JSONObject> which is stored inside the local file 
	 */
	public Vector <JSONObject> readFileCurrent() {
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
	 * Method that aims to open and read @file ApiForecast.
	 * @return JSONObject which is stored inside the local file 
	 */
	public JSONObject readFileForecast() {
		JSONObject jsonObj = new JSONObject(); 
		JSONParser parser = new JSONParser();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileForecast));
			String line = reader.readLine();
			Object obj;
			
			obj = parser.parse(line);
			jsonObj = (JSONObject) obj;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jsonObj;
	}
	
	
	/**
	 * Method which sets the Vector weatXCurrentTime
	 * @return weatXCurrentTime but with values found in ApiCallsByTime
	 */
	public Vector <Weather> fillWeatXCurrentTime() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileCurrentTime));
			String line = reader.readLine();
			Vector <JSONObject> obj = readFileCurrent();
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
					
				if( (double) objWind.get("speed") != 0 )
					speed = (double) objWind.get("speed");
				else speed = 0;

				if( (long) objWind.get("deg") != 0 )
					deg = (long) objWind.get("deg");
				else deg = 0;
				
				if ( (double) objWind.get("gust") != 0 ) 
					gust = (double) objWind.get("gust");
				else gust = 0;
				
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
	 * placeCurrent has a Vector of Weather as attribute.
	 * @return placeCurrent with the values written inside ApiCallsByTime 
	 */
	public Place fillPlaceCurrent() {
		Vector <JSONObject> obj = readFileCurrent();
		
		JSONObject sys = (JSONObject) obj.firstElement().get("sys");
	
		String city = (String) obj.firstElement().get("name"); 
		String country = (String) sys.get("country");
		
		fillWeatXCurrentTime();
		
		this.placeCurrent= new Place(country , city, this.weatXCurrentTime);
		return placeCurrent;
	}

	
	/**
	 * Method which sets the Vector weatForecast
	 * @return weatForecast but with values found int ApiCallsByTime
	 */
	public Vector <Weather> fillWeatForecast() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileForecast));
			String line = reader.readLine();

			JSONObject obj = readFileForecast();
			JSONArray arrList ;
			Weather support ;
			JSONObject objList;
			JSONArray arrWeat;
			JSONObject objWeather;
			JSONObject objWind;
			
			Long date;
			String time;
			
			double speed;
			long deg;
			double gust;
			
			String weather;
			arrList = (JSONArray) obj.get("list");

			for( int i = 0 ; i < 40 ; i++) {
				objList = (JSONObject) arrList.get(i);
				objWind = (JSONObject) objList.get("wind");
				arrWeat = (JSONArray) objList.get("weather");
				objWeather = (JSONObject) arrWeat.get(0);
				
				date = (Long) objList.get("dt");
				time = dtToTime(date);
				
				if ( (double) objWind.get("gust") != 0 ) 
					gust = (double) objWind.get("gust");
				else gust = 0;
				
				if( (double) objWind.get("speed") != 0 )
					speed = (double) objWind.get("speed");
				else speed = 0;

				if( (long) objWind.get("deg") != 0 )
					deg = (long) objWind.get("deg");
				else deg = 0;
				
				weather = (String) objWeather.get("main");
				
				support = new Weather(time , speed , deg , gust , weather);
				this.weatForecast.add(support);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return this.weatForecast;
		
	}
	
	
	/**
	 * Method that sets values to placeForecast.
	 * It calls @method fillWeatForecast() for doing that because 
	 * placeForecast has a Vector of Weather as attribute.
	 * @return placeForecast with the values written inside ApiForecast 
	 */
	public Place fillPlaceForecast() {
		JSONObject obj = readFileForecast();
		
		JSONObject objCity = (JSONObject) obj.get("city");
	
		String city = (String) objCity.get("name"); 
		String country = (String) objCity.get("country");
		
		fillWeatForecast();
		
		this.placeForecast= new Place(country , city, this.weatForecast);
		return placeForecast;
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
	


