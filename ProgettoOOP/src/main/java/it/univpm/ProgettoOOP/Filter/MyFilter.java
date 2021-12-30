package it.univpm.ProgettoOOP.Filter;

import java.io.IOException;
import java.util.Vector;

import it.univpm.ProgettoOOP.Model.Place;
import it.univpm.ProgettoOOP.Model.Weather;
import it.univpm.ProgettoOOP.Statistics.FillingModel;



public class MyFilter {

	/**
	 * Filter for Place.
	 * @param time is the param given by the used with RequestMapping
	 * @return Place which has a Vector of Weather as attribute only with
	 * 		the time given as input. 
	 */
	public Place filterPerHour(String time) {
		if ( time == null) time = "4:00,PM";
		FillingModel fill = new FillingModel();
		Place support = fill.fillPlaceCurrent();
		Vector <Weather> weatFiltered = new Vector <Weather>();
		
		for ( int i = 0 ; i < support.getWeatherXTime().size() ; i++) {
			if ( support.getWeatherXTime().get(i).getHours().equals(time) ) {
			 	weatFiltered.add( support.getWeatherXTime().get(i));
			}
		}
		String country = support.getState();
		String city = support.getCity();
		return new Place(country , city , weatFiltered);
	}
}
