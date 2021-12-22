package it.univpm.ProgettoOOP.Model;

import java.util.Vector;

public class Place {
	
	private String state;
	private String city;
	private Vector <Weather> weatherXTime;


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
