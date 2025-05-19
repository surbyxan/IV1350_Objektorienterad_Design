package com.app.view;
import java.time.LocalDateTime;
import java.time.format.FormatStyle;
import java.time.format.DateTimeFormatter;
/**
 * Prints error messages to the terminal using <code>System.out<code/>
 */
public class ErrorMessageHandler {

	/**
	 * Prints the specificed error string message to <code>System.out<code/>
	 * @param  The message string that will be printed.
	 */
	public void showMessage(String message){
		System.out.println("[" + createTime() + "] ERROR: " + message);
	}

	private String createTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.
		ofLocalizedDateTime(FormatStyle.MEDIUM);
		return now.format(formatter);
	}
}
