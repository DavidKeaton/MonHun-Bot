package info.davek.mhbot;

import com.sun.istack.internal.Nullable;

import java.io.FileWriter;
import java.io.IOException;

// TODO: implement usage of Logger in other packages/classes

/**
 * Creates a logging instance for debugging/review purposes.
 */
public class Logger
{
	// the file descriptor of our log
	private static FileWriter fd = null;
	// default name for the log file
	private static String fname = "info.davek.mhbot.log";
	// contains error information
	private static String error = null;

	// LOG LEVELS
	private enum LEVEL {
		INFO,
		DEBUG,
		WARN,
		ERROR,
		FATAL,
	};

	// create default logging instance
	public Logger()
	{
		open(Logger.fname);
	}

	// create log `fname' for use
	public Logger(String fname)
	{
		open(fname);
	}

	public boolean open(String fname)
	{
		try {
			fd = new FileWriter(fname);
			return true;
		} catch(IOException e) {
			setError(e.toString());
		}
		return false;
	}

	public String getName()
	{
		return fname;
	}

	public boolean hasError()
	{
		return (error != null);
	}

	public static String getError()
	{
		return error;
	}

	public static void setError(String error)
	{
		Logger.error = error;
	}

	/**
	 * Format and write arguments to log.
	 *
	 * @param fmt       format string
	 * @param args      format arguments (optional)
	 */
	public void write(String fmt, @Nullable Object...args)
	{
		try {
			fd.append(String.format(fmt + "\n", args));
		} catch(IOException e) {
			setError(e.toString());
		}
	}

	/**
	 * Close the logging system, and release file handles.
	 */
	public void close()
	{
		try {
			fd.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Dumps information regarding the logging system.
	 *
	 * @return      info on the current logging system
	 */
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("Logger{");
		// current log file name
		str.append(fname);
		str.append("}");
		return str.toString();
	}
}
