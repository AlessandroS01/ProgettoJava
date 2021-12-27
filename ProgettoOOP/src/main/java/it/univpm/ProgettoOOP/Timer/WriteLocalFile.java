package it.univpm.ProgettoOOP.Timer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import it.univpm.ProgettoOOP.Exception.WrongFileException;
import it.univpm.ProgettoOOP.Services.StartConnectionURLCurrent;

public class WriteLocalFile {
	
	private String fileName = "ApiCallsByTime";
	private StartConnectionURLCurrent connection = new StartConnectionURLCurrent("ancona");
	private FileWriter writer;
	private BufferedWriter buffWriter;
	private String path = "C:\\Users\\Lenovo\\git\\repository4\\ProgettoOOP\\src\\main\\resources\\ApiCallsByTime";
	
	public void WriteOnLocalFile() throws WrongFileException {
		Timer timer = new Timer();	
		
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				File file = new File (path);
				if (file.exists()) {
					connection.startCurrentConnection();
					try {
						writer = new FileWriter(file);
						writer.write(connection.startCurrentConnection().toJSONString());
						writer.write('\n');
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				
			}
		
		};
		timer.scheduleAtFixedRate(task, 0, 3600000);
		
	}
}
