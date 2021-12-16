package it.univpm.ProgettoOOP.Model;

public class Wind {

	protected float speed;
	protected int speedDegree;
	protected float gust;
	
	
	public Wind(float speed, int speedDegree, float gust) {
		this.speed = speed;
		this.speedDegree = speedDegree;
		this.gust = gust;
	}
	
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public int getSpeedDegree() {
		return speedDegree;
	}
	public void setSpeedDegree(int speedDegree) {
		this.speedDegree = speedDegree;
	}
	public float getGust() {
		return gust;
	}
	public void setGust(float gust) {
		this.gust = gust;
	}
	
	
}
