package it.univpm.ProgettoOOP.Model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Time {
	
	protected String time;


	public Time(String time) {
		super();
		this.time = time;
	}


	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time=time;
	}

	
	
}