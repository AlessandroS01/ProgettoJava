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


/**
 * This @class is used to write automatically the informations written
 * inside both the API in two different local files that can be found in the @resource package.
 * The 2 files are :
 * @ApiCallsByTime
 * @ApiFOrecast
 */
public class WriteLocalFile {
	
	private StartConnectionURLCurrent connection = new StartConnectionURLCurrent("ancona");
	private StartConnectionURL5Days connectionForecast = new StartConnectionURL5Days("ancona");
	private FileWriter writer;
	private BufferedWriter buffWriter;
	
	private String path = "C:\\Users\\Lenovo\\git\\repository4\\ProgettoOOP\\src\\main\\resources\\ApiCallsByTime";
	private String pathForecast = "C:\\Users\\Lenovo\\git\\repository4\\ProgettoOOP\\src\\main\\resources\\ApiForecast";
	
	
	/**
	 * Write ,with a timer set to 3 hours, informations
	 * about the Current time on a local file called 
	 * @ApiCallsByTime
	 */
	public void WriteOnLocalFile3Hours() throws WrongFileException {
		Timer timer = new Timer();	
		
		TimerTask taskCurrent = new TimerTask() {

			public void run() {
				File file = new File (path);
				try {
					if (!file.exists()) {
						file.createNewFile();
					}
					connection.startCurrentConnection();
					
					writer = new FileWriter(file, true);
					writer.write( connection.startCurrentConnection().toJSONString());
					writer.write('\n');
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		};
		timer.scheduleAtFixedRate(taskCurrent, 8400000, 3600000*3);
	}
	
	
	/**
	 * Write on a local file the current informations
	 * about the Forecast
	 */
	public void WriteOnLocalFileForecast() throws WrongFileException{
		Timer timerForecast = new Timer();
		
		TimerTask taskCurrent = new TimerTask() {

			public void run() {
			
				File file = new File (pathForecast);
					try {
						if (!file.exists()) {
							file.createNewFile();
						}
					    connectionForecast.startConnection5Days();
					    writer = new FileWriter(file, true);
						writer.write(connectionForecast.startConnection5Days().toJSONString());
						writer.write('\n');
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		};
		timerForecast.schedule(taskCurrent, 10000);
	}
	
	
}
