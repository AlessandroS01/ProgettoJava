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

import it.univpm.ProgettoOOP.Model.Weather;
import it.univpm.ProgettoOOP.Services.StartConnectionURL5Days;
import it.univpm.ProgettoOOP.Services.StartConnectionURLDaily;

import java.net.URL;
import org.json.simple.*;

@RestController
public class ApiCall {
	

 @Autowired
	
	
	@RequestMapping ( value = "/getAncona5Days" , method = RequestMethod.GET )
	public ResponseEntity <Object> getWeather5Days ( @RequestParam( defaultValue = "ancona" ) String city ){
	 	StartConnectionURL5Days start = new StartConnectionURL5Days(city);
		return new ResponseEntity <>( start.startConnection5Days() , HttpStatus.OK);
	}


}
