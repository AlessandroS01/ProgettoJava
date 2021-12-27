package it.univpm.ProgettoOOP.Exception;


public class WrongFileException extends Exception{
	
	private String error ="The file given doesn't exist";
	private static final long serialVersionUID = 1L;

	public WrongFileException( String error) {
		super(error);
	}
	
	public String sendMessage() {
		return error;
	}
	
}
