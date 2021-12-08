package com.example.ProgrammaJavaEsame;

public class Meteo implements Interfaccia_meteo {
	
	double temp_min;
	
	double temp_max;
	
	double temp_now;
	
	double wind_speed;
	
	double wind_degree;
	
	public Meteo() {};
    
	public double get_TemperatureMin() {
		return temp_min;	
	};

	public double get_TemperatureMax() {
		return temp_max;
	};

	public double get_TemperatureNow() {
		return temp_now;
	};

	public double get_SpeedWind() {
		return wind_speed;
	};

	public double get_WindDegree() {
		return wind_degree;
	};

	
}
