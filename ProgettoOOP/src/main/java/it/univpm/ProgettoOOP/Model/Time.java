package it.univpm.ProgettoOOP.Model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Time {
	
	protected String time;
	private String date;
	private String hours;


	public Time(String time) {
		super();
		this.time = time;
		String[] splitted = time.split(" ");
		this.date = splitted[0]+ " " + splitted[1];
		this.hours = splitted[2];
	
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getHours() {
		return hours;
	}


	public void setHours(String hours) {
		this.hours = hours;
	}


	
	
}