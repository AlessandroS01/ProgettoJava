package it.univpm.ProgettoOOP.Model;

import java.sql.Date;

public class Wind extends Time{

	protected float speed;
	protected int degree;
	protected float gust;
	
	
	public Wind(java.util.Date time, float speed, int speedDegree, float gust) {
		super(time);
		this.speed = speed;
		this.degree = speedDegree;
		this.gust = gust;
	}
	
	
	public float getSpeed() {
		return speed;
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public int getDegree() {
		return degree;
	}
	
	public void setDegree(int speedDegree) {
		this.degree = speedDegree;
	}
	
	public float getGust() {
		return gust;
	}
	
	public void setGust(float gust) {
		this.gust = gust;
	}
	
	
}
