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
import it.univpm.ProgettoOOP.Model.Place;
import it.univpm.ProgettoOOP.Model.Weather;
import it.univpm.ProgettoOOP.Services.StartConnectionURL5Days;
import it.univpm.ProgettoOOP.Services.StartConnectionURLCurrent;
import it.univpm.ProgettoOOP.Timer.WriteLocalFile;

import org.json.simple.*;

@RestController
public class ApiCall {
	

	@GetMapping ( "/getCurrentAncona" )
	public JSONObject getCurrentWeather (){
		StartConnectionURLCurrent start = new StartConnectionURLCurrent("ancona");
		return start.startCurrentConnection();
	}

	
	@GetMapping ( "/getAncona5Days" )
	public JSONObject getWeather5Days () {
		StartConnectionURL5Days startForecast = new StartConnectionURL5Days("ancona");
		return startForecast.startConnection5Days();
	}
	
	@GetMapping ( "/writer")
	public String writer() {
		WriteLocalFile write = new WriteLocalFile();
		try {
			write.WriteOnLocalFile();
		} catch (WrongFileException e) {
			return e.sendMessage();
		}
		return "Caricamento completato";
	}
	
}
