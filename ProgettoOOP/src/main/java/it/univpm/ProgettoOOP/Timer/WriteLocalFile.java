package it.univpm.ProgettoOOP.Timer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import it.univpm.ProgettoOOP.Exception.WrongFileException;
import it.univpm.ProgettoOOP.Services.StartConnectionURL5Days;
import it.univpm.ProgettoOOP.Services.StartConnectionURLCurrent;

public class WriteLocalFile {
	
	private String fileName = "ApiCallsByTime";
	private StartConnectionURLCurrent connection = new StartConnectionURLCurrent("ancona");
	private StartConnectionURL5Days connectionForecast = new StartConnectionURL5Days("ancona");
	private FileWriter writer;
	private BufferedWriter buffWriter;
	private String path = "C:\\Users\\Lenovo\\git\\repository4\\ProgettoOOP\\src\\main\\resources\\ApiCallsByTime";
	private String pathForecast = "C:\\Users\\Lenovo\\git\\repository4\\ProgettoOOP\\src\\main\\resources\\ApiForecast";
	
	
	/**
	 * Write on a local file the current informations
	 * about the Current time
	 */
	public void WriteOnLocalFileHour() throws WrongFileException {
		Timer timer = new Timer();	
		
		TimerTask taskCurrent = new TimerTask() {
			@Override
			public void run() {
				File file = new File( path);
				if (file.exists()) {
					connection.startCurrentConnection();
					try {
						writer = new FileWriter(file);
						writer.write(connection.startCurrentConnection().toJSONString());
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		timer.scheduleAtFixedRate(taskCurrent, 0, 10000);
	}
	
	
	/**
	 * Write on a local file the current informations
	 * about the Forecast
	 */
	public void WriteOnLocalFileForecast() throws WrongFileException{
		Timer timerForecast = new Timer();
		
		TimerTask taskCurrent = new TimerTask() {

			@Override
			public void run() {
				File file = new File (pathForecast);
				if (file.exists()) {
					connectionForecast.startConnection5Days();
					try {
						writer = new FileWriter(file);
						writer.write(connectionForecast.startConnection5Days().toJSONString());
						writer.write('\n');
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		timerForecast.schedule(taskCurrent, 0);	
	}
	
	
}
