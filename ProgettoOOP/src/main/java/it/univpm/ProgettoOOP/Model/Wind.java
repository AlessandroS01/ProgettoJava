package it.univpm.ProgettoOOP.Model;

import java.sql.Date;

public class Wind extends Time{

	protected double speed;
	protected long degree;
	protected double gust;
	
	
	public Wind(String time, double speed, long speedDegree, double gust) {
		super(time);
		this.speed = speed;
		this.degree = speedDegree;
		this.gust = gust;
	}
	
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public long getDegree() {
		return degree;
	}
	
	public void setDegree(int speedDegree) {
		this.degree = speedDegree;
	}
	
	public double getGust() {
		return gust;
	}
	
	public void setGust(float gust) {
		this.gust = gust;
	}
	
	
}
