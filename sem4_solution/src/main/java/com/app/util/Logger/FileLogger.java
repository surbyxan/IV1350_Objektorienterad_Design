package com.app.util.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements Logger {
	private PrintWriter logStream;

	public FileLogger() {
		try {
			logStream = new PrintWriter(new Filewriter("log.txt"), true);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Logging is not possible");
		}
	}

	/**
	* Prints the specified string to the log file.
	*
	* @param message The string that will be printed to the
	* log file.
	*/
	public void log(String message) {
		logStream.println(message);
	}

}
