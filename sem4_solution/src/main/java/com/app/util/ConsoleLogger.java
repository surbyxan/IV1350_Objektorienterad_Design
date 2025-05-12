package com.app.util;
import java.time.LocalDateTime;
import java.time.format.FormatStyle;
import java.time.format.DateTimeFormatter;
/**
 * Prints log messages to the terminal using <code>System.out<code/>
 */
public class ConsoleLogger implements Loggerlogger{
	/**
	 * Prints the specificed string message to <code>System.out<code/>
	 * @param  The message string that will be printed.
	 */
	@Override
	public void log(String message){
		System.out.println("[" + createTime() + "] " + message);
	}

	private String createTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.
		ofLocalizedDateTime(FormatStyle.MEDIUM);
		return now.format(formatter);
	}
}
