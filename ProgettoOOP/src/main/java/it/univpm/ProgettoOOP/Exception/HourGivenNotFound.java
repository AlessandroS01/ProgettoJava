package it.univpm.ProgettoOOP.Exception;

public class HourGivenNotFound extends Exception {
	
	private String error ;
	private static final long serialVersionUID = 1L;


	public HourGivenNotFound(String code) {
		super();
		this.setError(code);
	}
	
	
	public String sendMessage() {
		return error;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}
	
	
	
	
}
