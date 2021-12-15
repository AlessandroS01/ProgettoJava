package it.univpm.ProgettoOOP.Model;

//import com.example.ProgrammaJavaEsame.Interfaccia_meteo;

public class Meteo implements MeteoInterface {
	
	double temp_min;
	
	double temp_max;
	
	double temp_now;
	
	double wind_speed;
	
	double wind_degree;
	
	@Override
	public double getTemperatureMin() {
		return temp_min;	
	};

	@Override
	public double getTemperatureMax() {
		return temp_max;
	};

	@Override
	public double getTemperatureNow() {
		return temp_now;
	};

	@Override
	public double getSpeedWind() {
		return wind_speed;
	};

	@Override
	public double getWindDegree() {
		return wind_degree;
	};
    
	public void setTemperatureMin(double tempMin) {
      this.temp_min = tempMin - 273.15;
	}
	
	public void setTemperatureMax(double tempMax) {
		this.temp_max = tempMax - 273.15;
	};
	
	public void setSpeedWind(double windSpeed) {
		this.wind_speed = windSpeed;
	}

	
	
	
	
	
}
