

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

FillingModel c = new FillingModel();

public void fill(Vector<Weather> current,Vector<Weather> forecast) {
	current = c.fillWeatXCurrentTime();
	forecast = c.fillWeatForecast();
	

}

public long mediaTemp(Vector<Weather> current) {
	long [] minDegree = null;
	long somma = 0;
	long media = 0;
	for(int i = 0; i<current.size(); i++) {
     minDegree[i] = current.get(i).getDegree();
	}
	
	for(int i =  0; i<minDegree.length; i++) {
		somma += minDegree[i];
		media = somma/i;
	}
	
	return media;
}
	
public void tempMinXDay (Vector<Weather> current) {
    long tempMin = 1000;
	
	for(int i = 0; i<current.size();i++) {
//	if(current.get(i).getTime().contains("December 29") ==  current.get(i+1).getTime().contains("December 29")) {
		 if (current.get(i).getDegree()< tempMin)
	     {
	      tempMin = current.get(i).getDegree();
	     }
	
	}
}
public void tempMaxXDay (Vector<Weather> current) {
    long tempMax = -1000;
	
	for(int i = 0; i<current.size();i++) {
//	if(current.get(i).getTime().contains("December 29") ==  current.get(i+1).getTime().contains("December 29")) {
		 if (current.get(i).getDegree()< tempMax)
	     {
			 tempMax = current.get(i).getDegree();
	     }
	
	}
}

	
	
	
public long comparison(Vector<Weather> current,Vector<Weather> forecast) {
	long differences = 0;
	for(int i = 0; i<current.size(); i++) {
	if(current.get(i).getDate()== forecast.get(0).getDate()) {
	differences = current.get(i).getDegree()- forecast.get(0).getDegree();		
		}
	}
	
	return differences;
}
	
	
}
