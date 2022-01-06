package it.univpm.ProgettoOOP.Exception;

public class HourGivenNotFound extends Throwable {
	
	private String error ;
	private static final long serialVersionUID = 1L;

	public HourGivenNotFound() {
		super();
		}
	 public HourGivenNotFound(String message) {
		 super(message); 
		 }
	 public HourGivenNotFound(String message, Throwable cause) { 
		 super(message, cause);
		 }
	 public HourGivenNotFound(Throwable cause) { 
		 super(cause); 
		 }
/*
	public HourGivenNotFound(String code) {
		super("The time given has no matches");
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
	
	*/
	
	
}
