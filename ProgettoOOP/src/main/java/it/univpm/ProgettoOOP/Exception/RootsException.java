package it.univpm.ProgettoOOP.Exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class RootsException {
	
	private final String message;
	private final HttpStatus httpStatus;
	
	public RootsException(String message,  HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}


	
	
}
