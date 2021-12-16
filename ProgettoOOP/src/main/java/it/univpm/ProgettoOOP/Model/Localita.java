package it.univpm.ProgettoOOP.Model;


public class Localita extends Meteo {
	
	private String state;
	private String city;
	
	public Localita(double windSpeed, float windDegree, String state, String city) {
		super(windSpeed, windDegree);
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
