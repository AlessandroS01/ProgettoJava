package it.univpm.ProgettoOOP.Statistics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;

import org.json.simple.JSONObject;

import it.univpm.ProgettoOOP.Model.Time;
import it.univpm.ProgettoOOP.Model.Weather;
import it.univpm.ProgettoOOP.Model.Wind;
import it.univpm.ProgettoOOP.Services.StartConnectionURL5Days;
import it.univpm.ProgettoOOP.Services.StartConnectionURLCurrent;

public class Stats {
		
	private Vector<Weather> current = new Vector<Weather>();
	private Vector<Weather> forecast = new Vector<Weather>();


	public Stats() {
		FillingModel c = new FillingModel();
		this.current = c.fillWeatXCurrentTime();
		this.forecast = c.fillWeatForecast();
	}

	public long getAverageDegree(String date ) {
	
		long somma = 0;
		int i = 0;
	
		for(i = 0; i<this.current.size() ; i++) {
			if ( this.current.get(i).getDate().equals(date) )
				somma += current.get(i).getDegree();
		}
	
		return somma/i ;
	}


	public double getMinSpeedXDay (String date) {
		
		double speedMin = 0;
		
		for(int i = 0; i<this.current.size();i++) {
			if ( this.current.get(i).getDate().equals(date) )
				if( i == 0 )
					speedMin = this.current.get(i).getSpeed();
				else if ( speedMin > this.current.get(i).getSpeed() )
					speedMin = this.current.get(i).getSpeed();
		}
		return speedMin;
	}


	public double getMaxSpeedXDay (String date) {
		double speedMax = 0;
	
		for(int i = 0; i<this.current.size();i++) {
		
			if ( this.current.get(i).getDate().equals(date) )
				if( i == 0 )
					speedMax = this.current.get(i).getSpeed();
				else if ( speedMax < this.current.get(i).getSpeed() )
					speedMax = this.current.get(i).getSpeed();

		}
		return speedMax;
	}

	
	
	
	public String differenceSpeedCurrentForecast() {
	
		String difference = "Here are the differences of the speed found between Current and Forecast API calls : \n";
		int index = 1;
	
		for(int i = 0; i<this.current.size(); i++) {
			for ( int y = 0 ; y < this.forecast.size() ; y++ ) {
				if( this.current.get(i).getDate() . equals ( this.forecast.get(y).getDate() )  
						&&	this.current.get(i).getHours() .equals ( this.forecast.get(y).getHours() ) ) {
						difference += index + "°) on the date " + this.current.get(i).getDate() 
								+ " at " + this.current.get(i).getHours() + " the difference between the 2 forecasts is :"
								+ Math.round( (this.current.get(i).getSpeed() - this.forecast.get(y).getSpeed() ) * 100000d ) / 100000d + "\n";	
						index++;
				}
			}
		}
		difference += "If the difference is negative , it means that the 5 days forecast overstimated the forecast of the speed. \n"
				+ "Instead if the difference is positive , it means that 5 days forecast understimated the forecast of the speed." ;
		return difference;
	}

}
