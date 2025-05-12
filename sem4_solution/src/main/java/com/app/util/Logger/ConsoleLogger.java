package com.app.util.Logger;
/**
 * Prints log messages to the terminal using <code>System.out<code/>
 */
public class ConsoleLogger implements Logger{
	/**
	 * Prints the specificed string message to <code>System.out<code/>
	 * @param  The message string that will be printed.
	 */
	@Override
	public void log(String message){
		System.out.println(message);
	}
}
