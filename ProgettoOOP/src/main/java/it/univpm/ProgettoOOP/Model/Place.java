package it.univpm.ProgettoOOP.Model;

import java.util.Vector;

public class Place {
	
	private String state;
	private String city;
	private Weather weatherXTime;


	public Place(String state, String city, Weather weatherXTime) {
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
	
	public Weather getWeatherXTime() {
		return weatherXTime;
	}
	
	public void setWeatherXTime(Weather weatherXTime) {
		this.weatherXTime = weatherXTime;
	}


	
	
}
