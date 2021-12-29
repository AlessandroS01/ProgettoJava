package it.univpm.ProgettoOOP.Model;

import java.sql.Date;


public class Weather extends Wind{

	protected String weather ;

	public Weather(String time, double speed, long degree, double gust, String weather) {
		super(time, speed, degree, gust);
		this.weather = weather;
	}

	
	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	
	
	

}
