package it.univpm.ProgettoOOP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import it.univpm.ProgettoOOP.Services.StartConnectionURL;

import java.net.URL;

import org.json.simple.*;

@RestController
public class ApiCall {
	
	@Autowired
	private StartConnectionURL daily ;
	
	
	@RequestMapping ( value = "/getSeoul" , method = RequestMethod.GET)
	public void getWeatherDaily ( @PathVariable ("Seoul") String city ) {
		daily .StartConnectionDaily(city); 
	}

	
}
