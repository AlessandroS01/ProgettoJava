package it.univpm.ProgettoOOP.Model;

import java.sql.Date;

//import com.example.ProgrammaJavaEsame.Interfaccia_meteo;

public class Weather extends Wind{

	protected String weather ;

	
	public Weather(java.util.Date time, float speed, int degree, float gust, String weather) {
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
