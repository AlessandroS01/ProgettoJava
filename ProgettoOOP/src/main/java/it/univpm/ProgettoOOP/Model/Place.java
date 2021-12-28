package it.univpm.ProgettoOOP.Model;

import java.util.Vector;

public class Place {
	
	private String state;
	private String city;
	private Vector<Weather> weatherXTime;
	
	/**
	 * Constructor of @Place class.
	 * @param state is a string that contains the state of the city that we want to study
	 * @param city is a string that contains the city that we want to study
	 * @param weatherXTime is a vector because for every city we want to schedule it's weather referred to a specific time 
	 */
	public Place(String state, String city, Vector<Weather> weatherXTime) {
		super();
		this.state = state;
		this.city = city;
		this.weatherXTime = weatherXTime;
	}

	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Vector<Weather> getWeatherXTime() {
		return weatherXTime;
	}

	public void setWeatherXTime(Vector<Weather> weatherXTime) {
		this.weatherXTime = weatherXTime;
	}


	
	
	
}
