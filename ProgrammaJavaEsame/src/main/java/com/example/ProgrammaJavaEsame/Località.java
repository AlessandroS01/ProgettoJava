package com.example.ProgrammaJavaEsame;

import java.util.ArrayList;

public class Località extends Meteo {
	
	private double coordinate;
	
	 private String state;
	
	private String city;
	
	
	ArrayList <Time> day = new ArrayList<Time>();
	
	
	public Località (double coordinate, String state, String city,ArrayList <Time> day ) {
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

	public double get_Giorno() {
		return day.get_Giorno();
	}
	
	public double get_Ora() {
		return day.get_ora();
	}
	
	public double get_Minuti() {
		return day.get_Minuti();
	}
	
	public double get_Secondi() {
		return day.get_Secondi();
	}
}
