package it.univpm.ProgettoOOP.Model;

import java.sql.Date;

public class Wind extends Time{

	protected double speed;
	protected long degree;
	protected double gust;
	
	
	public Wind(String time, double speed, long degree, double gust) {
		super(time);
		this.speed = speed;
		this.degree = degree;
		this.gust = gust;
	}
	
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public long getDegree() {
		return degree;
	}
	
	public void setDegree(int degree) {
		this.degree = degree;
	}
	
	public double getGust() {
		return gust;
	}
	
	public void setGust(double gust) {
		this.gust = gust;
	}
	
	
}
