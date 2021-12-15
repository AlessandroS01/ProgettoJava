package it.univpm.ProgettoOOP.Model;

import java.util.ArrayList;

//import com.example.ProgrammaJavaEsame.Meteo;
//import com.example.ProgrammaJavaEsame.Time;

public class Localita extends Meteo {
	
	private double coordinate;
	
	 private String state;
	
	private String city;
	
	
	ArrayList <Time> day = new ArrayList<Time>();
	
	
	public Localita (double coordinate, String state, String city,ArrayList <Time> day ) {
		super();
		this.coordinate = coordinate;
		this.state = state;
		this.city = city;
		this.day = day;
	}
	
	public double get_Coordinate() {
		return coordinate;
	}
	
	public String get_State() {
		return state;
	}
	
	public String get_City() {
		return city;
	}

	
}
