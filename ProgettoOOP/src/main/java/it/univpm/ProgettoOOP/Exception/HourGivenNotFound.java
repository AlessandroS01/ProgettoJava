package it.univpm.ProgettoOOP.Exception;

public class HourGivenNotFound extends Throwable {
	
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
	
	
}
