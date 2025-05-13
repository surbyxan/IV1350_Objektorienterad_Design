package com.app.util;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FileLogger implements Loggerlogger {
	private PrintWriter logStream;

	/**
	 * Constructs a FileLogger and initializes a PrintWriter
	 * to write log messages to a file named "log.txt".
	 * If the file cannot be created or opened, the stack trace 
	 * is printed and an error message is displayed.
	 */
	public FileLogger() {
		try {
			logStream = new PrintWriter(new FileWriter("log.txt"), true);
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
		logStream.println("[" + createTime() + "] " + message);
	}

	private String createTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.
		ofLocalizedDateTime(FormatStyle.MEDIUM);
		return now.format(formatter);
	}

}
