package it.univpm.ProgettoOOP.Model;

//import com.example.ProgrammaJavaEsame.Interfaccia_meteo;

public class Meteo implements MeteoInterface {
	protected double windSpeed;
	
	protected float windDegree;
	
	
	public Meteo( double windSpeed, float windDegree) {
		this.windSpeed = windSpeed;
		this.windDegree = windDegree;
	}



	


	public double getWindSpeed() {
		return windSpeed;
	}



	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}



	public float getWindDegree() {
		return windDegree;
	}



	public void setWindDegree(float windDegree) {
		this.windDegree = windDegree;
	}



	@Override
	public String toString() {
		return "Meteo [windSpeed=" + windSpeed + ", windDegree=" + windDegree + "]";
	}



	
	
	
	
	
	
	
	
	
}
