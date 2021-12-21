package it.univpm.ProgettoOOP.Model;

import java.sql.Date;

public class Time {
	
	protected java.util.Date time;


	public Time(java.util.Date time) {
		super();
		this.time = time;
	}


	public java.util.Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}

	
	
}