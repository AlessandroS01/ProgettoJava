package it.univpm.ProgettoOOP.Model;

//import com.example.ProgrammaJavaEsame.Interfaccia_meteo;

public class Weather extends Wind{

	protected String weather ;

	public Weather(float speed, int speedDegree, float gust, String weather) {
		super(speed, speedDegree, gust);
		this.weather = weather;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	
	
	

}
