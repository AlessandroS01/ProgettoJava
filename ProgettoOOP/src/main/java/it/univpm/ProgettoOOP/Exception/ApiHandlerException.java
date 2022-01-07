package it.univpm.ProgettoOOP.Exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiHandlerException {
	
	@ExceptionHandler ( value = {HourGivenNotFound.class})
	public ResponseEntity <Object> handleHourGiven( HourGivenNotFound e){
		
		HttpStatus badRequest = HttpStatus.BAD_REQUEST; 
		
		RootsException rootsException = new RootsException 
				(	e.getMessage() , 
					badRequest ) ;
		
		return new ResponseEntity<>( rootsException , badRequest);
	}
	
	@ExceptionHandler ( value = {DayGivenNotFound.class})
	public ResponseEntity <Object> handleDayGiven( DayGivenNotFound e){
		
		HttpStatus badRequest = HttpStatus.BAD_REQUEST; 
		
		RootsException rootsException = new RootsException 
				(	e.getMessage() , 
						badRequest ) ;
		
		return new ResponseEntity<>( rootsException , badRequest);
	}
	
	@ExceptionHandler ( value = {WrongFileException.class})
	public ResponseEntity <Object> handleDayGiven( WrongFileException e){
		
		HttpStatus badRequest = HttpStatus.BAD_REQUEST; 
		
		RootsException rootsException = new RootsException 
				(	e.getMessage() , 
						badRequest ) ;
		
		return new ResponseEntity<>( rootsException , badRequest);
	}
}
