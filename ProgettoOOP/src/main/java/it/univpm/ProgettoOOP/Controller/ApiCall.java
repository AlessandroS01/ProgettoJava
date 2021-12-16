package it.univpm.ProgettoOOP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgettoOOP.Model.Meteo;
import it.univpm.ProgettoOOP.Services.StartConnectionURLDaily;
import java.net.URL;
import org.json.simple.*;

@RestController
public class ApiCall {
	
	@Autowired
	
	
	@RequestMapping ( value = "/getAnconaDaily"  , method = RequestMethod.GET)
	public ResponseEntity <Object> getWeather (){
		StartConnectionURLDaily start = new StartConnectionURLDaily();
		return new ResponseEntity <>( start.startConnection( "Ancona") , HttpStatus.OK);
	}


}
