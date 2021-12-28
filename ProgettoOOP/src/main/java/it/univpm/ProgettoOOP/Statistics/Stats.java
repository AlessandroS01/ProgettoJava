package it.univpm.ProgettoOOP.Statistics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;

import org.json.simple.JSONObject;

import it.univpm.ProgettoOOP.Model.Time;
import it.univpm.ProgettoOOP.Model.Wind;
import it.univpm.ProgettoOOP.Services.StartConnectionURL5Days;
import it.univpm.ProgettoOOP.Services.StartConnectionURLCurrent;

public class Stats {

private Vector<Wind> datoAttuale = new Vector<Wind>();
private Vector<Wind> datoForecast = new Vector<Wind>();



public void filterCurrent(Vector<Wind> datoAttuale) {
	
	StartConnectionURLCurrent now = new StartConnectionURLCurrent("ancona");
	JSONObject Obj = now.startCurrentConnection();
	JSONObject ObjWind = (JSONObject) Obj.get("wind");
	
	Long date = (Long) Obj.get("dt");
	java.util.Date time = new java.util.Date((long)date*1000);
	
	float speed = (float) ObjWind.get("wind");
	int deg = (int) ObjWind.get("deg");
	float gust = (float) ObjWind.get("gust");
	Wind n = new Wind(time,(float) ObjWind.get("wind"),(int) ObjWind.get("deg"),(float) ObjWind.get("gust"));
    
    datoAttuale.add(n);
}

public void filterForecast(Vector<Wind> datoForecast) {
	StartConnectionURL5Days after = new StartConnectionURL5Days("ancona");
	JSONObject Obj = after.startConnection5Days();
	JSONObject ObjWind = (JSONObject) Obj.get("wind");
	
	Long date = (Long) Obj.get("dt");
	java.util.Date time = new java.util.Date((long)date*1000);
	
	float speed = (float) ObjWind.get("wind");
	int deg = (int) ObjWind.get("deg");
	float gust = (float) ObjWind.get("gust");
	Wind n = new Wind(time,(float) ObjWind.get("wind"),(int) ObjWind.get("deg"),(float) ObjWind.get("gust"));
    
    datoForecast.add(n);
	
}

public void tempMin(Vector<Wind> dato) {
	
	
	
	
}

/*public void confrontoCurrentForecast(Vector<Wind> datoAttuale, Vector<Wind> datoForecast) {
	if(datoAttuale.getTime() == datoForecast.getTime()) {
	int n =	datoAttuale.getDeg() - datoForecast.getDeg();
		
	}
	*/
	
}
	
	
	
	

/*public void parse(JSONObject obj , String city) {
	StartConnectionURLCurrent daily = new StartConnectionURLCurrent( city);
    
	JSONObject Obj = daily.startCurrentConnection();
	JSONObject ObjWind = (JSONObject) Obj.get("wind");
	
	Long date = (Long) Obj.get("dt");
	java.util.Date time = new java.util.Date((long)date*1000);
	
	float speed = (float) ObjWind.get("wind");
	int deg = (int) ObjWind.get("deg");
	float gust = (float) ObjWind.get("gust");
	
Vector <JSONObject> wind = new Vector <JSONObject>();

    wind.add(ObjWind);	
	wind.add((JSONObject) obj.get("dt"));
}	
*/ 