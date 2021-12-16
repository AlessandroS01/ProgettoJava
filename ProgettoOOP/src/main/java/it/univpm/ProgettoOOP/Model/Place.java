package it.univpm.ProgettoOOP.Model;


public class Place extends Weather {
	
	private String state;
	private String city;
	
	
	public Place(float speed, int speedDegree, float gust, String weather, String state, String city) {
		super(speed, speedDegree, gust, weather);
		this.state = state;
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
}
