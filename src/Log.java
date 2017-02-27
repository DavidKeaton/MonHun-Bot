package info.davek.mhbot;

import com.sun.istack.internal.Nullable;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: implement usage of Log in other packages/classes

/**
 * Creates a logging instance for debugging/review purposes.
 */
public class Log
{
	// SimpleDateFormat for logstamps
	private static final String LOGSTAMP = "yyyy.MM.dd'@'HH:mm:ss.SSS";

	// the file descriptor of our log
	private static FileWriter fd = null;
	// default name for the log file
	private static String fname = "hunters.log";
	// contains error information
	private static String error = null;

	// LOG LEVELS
	public enum LEVEL {
		INFO,
		DEBUG,
		WARN,
		ERROR,
		FATAL,
	}

	// create default logging instance
	public Log()
	{
		open(Log.fname);
	}

	// create log `fname' for use
	public Log(String fname)
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
		return (error != null) ? error : "No errors!";
	}

	public static void setError(String error)
	{
		Log.error = error;
	}

	/**
	 * Format and write arguments to log, using a logging level.
	 *
	 * @param level     logging level/severity
	 * @param fmt       format string
	 * @param args      format arguments (optional)
	 */
	public void print(Log.LEVEL level,
	                  String fmt,
	                  @Nullable Object...args)
	{
		try {
			// print log timestamp
			fd.append(new SimpleDateFormat(LOGSTAMP).format(new Date()));
			fd.append(" - ");
			// print severity, or nothing if
			switch(level) {
				case DEBUG:
					fd.append("D: ");
				case WARN:
					fd.append("W: ");
				case ERROR:
					fd.append("E: ");
				case FATAL:
					fd.append("F: ");
			}
			// write supplied format string and args
			fd.append(String.format(fmt, args));
			fd.append("\n");
		} catch(IOException|NullPointerException e) {
			setError(e.toString());
		}
	}

	/**
	 * Format and write arguments to log.
	 *
	 * @param fmt       format string
	 * @param args      format arguments (optional)
	 */
	public void print(String fmt, @Nullable Object...args)
	{
		print(LEVEL.INFO, fmt, args);
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
		return "Log: " + fname;
	}
}
