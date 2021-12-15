package it.univpm.ProgettoOOP.Model;

//import com.example.ProgrammaJavaEsame.Interfaccia_meteo;

public class Meteo implements MeteoInterface {
	
	double tempMin;
	
	double tempMax;
	
	double tempNow;
	
	double windSpeed;
	
	float windDegree;
	
	@Override
	public double getTemperatureMin() {
		return tempMin;	
	};

	@Override
	public double getTemperatureMax() {
		return tempMax;
	};

	@Override
	public double getTemperatureNow() {
		return tempNow;
	};

	@Override
	public double getSpeedWind() {
		return windSpeed;
	};

	@Override
	public float getWindDegree() {
		return windDegree;
	};
    
	public void setTemperatureMin(double tempMin) {
      this.tempMin = tempMin - 273.15;
	}
	
	public void setTemperatureMax(double tempMax) {
		this.tempMax = tempMax - 273.15;
	};
	
	public void setTemperatureNow(double tempNow) {
		this.tempNow = tempNow - 273.15;
	}
	
	public void setSpeedWind(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	
	public void setWindDegree(float windDegree) {
		this.windDegree = windDegree;
	}
	

	
	
	
	
	
}
