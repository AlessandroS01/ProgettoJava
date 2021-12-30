package it.univpm.ProgettoOOP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgettoOOP.Exception.WrongFileException;
import it.univpm.ProgettoOOP.Filter.MyFilter;
import it.univpm.ProgettoOOP.Model.Place;
import it.univpm.ProgettoOOP.Model.Weather;
import it.univpm.ProgettoOOP.Services.StartConnectionURL5Days;
import it.univpm.ProgettoOOP.Services.StartConnectionURLCurrent;
import it.univpm.ProgettoOOP.Statistics.FillingModel;
import it.univpm.ProgettoOOP.Timer.WriteLocalFile;

import java.util.Vector;

import org.json.simple.*;

@RestController
public class Roots {
	
	/**
	 * This is a root that has as @return the informations of
	 * the current time taken with the API.
	 */
	@GetMapping ( "/getCurrentAncona" )
	public JSONObject getCurrentWeather (){
		StartConnectionURLCurrent start = new StartConnectionURLCurrent("ancona");
		return start.startCurrentConnection();
	}

	/**
	 * This is a root that has as @return the informations of
	 * the forecast for the next 5 days taken with the API.
	 */
	@GetMapping ( "/getAncona5Days" )
	public JSONObject getWeather5Days () {
		StartConnectionURL5Days startForecast = new StartConnectionURL5Days("ancona");
		return startForecast.startConnection5Days();
	}
	
	/**
	 * This is a root used to call the Weather API and write automatically every hour
	 * the informations inside @ApiCallsByTime(local file situated in the resources).
	 * The @return is "Carimento Completato" if everything works properly.
	 * If the root has a problem while searching for the file it gives "The file given doesn't exist" 
	 * as @return
	 */
	@GetMapping ( "/writerEvery3Hours")
	public String writer() {
		WriteLocalFile write = new WriteLocalFile();
		try {
			write.WriteOnLocalFile3Hours();
		} catch (WrongFileException e) {
			return e.sendMessage();
		}
		return "Caricamento completato";
	}
	
	/**
	 * This is a root used to call the Forecast API and write automatically 
	 * the informations inside @ApiForecast(local file situated in the resources).
	 * The @return is "Carimento Completato" if everything works properly.
	 * If the root has a problem while searching for the file it gives "The file given doesn't exist" 
	 * as @return
	 */
	@GetMapping ( "/writerForecast")
	public String writerForecast() {
		WriteLocalFile write = new WriteLocalFile();
		try {
			write.WriteOnLocalFileForecast();
		} catch (WrongFileException e) {
			return e.sendMessage();
		}
		return "Caricamento completato";
	}
	
	/**
	 * This is a root in which the user can choose the weather during the time 
	 * he provides in the @method filterPerHour written inside @class MyFilter.
	 * @return @class Place created using a Vector of Weather with @param hours equal
	 * 		to every object of the Vector.
	 */
	@RequestMapping({"/filterPerHour/{time}" , "/filter4PM/"})
	public Place filtered(@PathVariable ( value = "time", required = false )String time) {
		MyFilter filter = new MyFilter();
		return filter.filterPerHour(time);
	}
	
	
	
	@GetMapping("/ciao")
	public Place ciao() {
		FillingModel c= new FillingModel();
		
		return c.fillPlaceCurrent();
	}
	
	@GetMapping("/hello")
	public Place hello() {
		FillingModel c= new FillingModel();
		
		return c.fillPlaceForecast();
	}
	
}
