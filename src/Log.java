package info.davek.mhbot;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: implement usage of Log in other packages/classes

/**
 * Creates a logging instance for debugging/review purposes.
 */
public class Log
{
	// SimpleDateFormat for logstamps
	private static final String LOGSTAMP = "yyyy.MM.dd' @ 'HH:mm:ss.SSS";
	// amount of entries need to be written before a file flush is forced
	private static final int FLUSH_COUNT = 5;

	// the file descriptor of our log
	private static Object fd = null;
	// default name for the log file
	private static String name = null;
	// contains error information
	private static String error = null;
	// amount of log entries written
	private int entriesWritten = 0;

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
		open(null);
	}

	// create log `fname' for use
	public Log(String fname)
	{
		open(fname);
	}

	public static boolean hasError()
	{
		return (error != null);
	}

	public static String getError()
	{
		return (hasError()) ? error : "No errors!";
	}

	public static void setError(String error)
	{
		Log.error = error;
	}

	/**
	 * Opens a connection to a file or stdout.
	 *
	 * @param fname     name of file (or stdout if null)
	 * @return          whether the operation was successful
	 */
	private boolean open(@Nullable String fname)
	{
		// if null, then print to stdout
		if(fname == null) {
			fd = System.out;
			name = "stdout";
			return true;
		}
		// try opening `fname' as file
		try {
			fd = new FileWriter(fname);
			return true;
		// some issue with the file?
		} catch(IOException e) {
			setError(e.toString());
		} finally {
			fd = null;
		}
		return false;
	}

	/**
	 * Abstracts whether the logging system is a device or file.
	 *
	 * @param str       the _actual_ string to write to the log file
	 */
	private void write(String str)
	{
		// if the log is a file, attempt to write (and possibly flush)
		if(fd instanceof FileWriter) {
			try {
				// append to the log file...
				((FileWriter)fd).append(str);
				// increment the amount of entries written
				++entriesWritten;
				// NOTE: I want sanity, but not sure if this is necessary...
				// every Log.FLUSH_COUNT, sync to disk
				if((entriesWritten % FLUSH_COUNT) == 0) {
					((FileWriter)fd).flush();
				}
			} catch(IOException e) {
				setError(e.toString());
			}
		// if the log is a stream of characters, push it through
		} else if(fd instanceof PrintStream) {
			((PrintStream)fd).print(str);
			++entriesWritten;
		}
	}

	/**
	 * Format and write arguments to log, using a logging level.
	 *
	 * @param level     logging level/severity
	 * @param fmt       format string
	 * @param args      format arguments (optional)
	 */
	public void print(Log.LEVEL level,
	                  @NotNull String fmt,
	                  @Nullable Object...args)
	{
		// position into PREFIX is incremented based on logging level
		final char[] PREFIX = {' ', 'D', 'W', 'E', 'F'};

		// print log timestamp
		write(new SimpleDateFormat(LOGSTAMP).format(new Date()));

		// position 0 will default to LEVEL.INFO
		int pos = 0;
		// print severity, or nothing if
		switch(level) {
			case FATAL:
				++pos;
			case ERROR:
				++pos;
			case WARN:
				++pos;
			case DEBUG:
				++pos;
		}

		// no prefix if pos is zero
		write((pos == 0) ? " :: " : " :[" + PREFIX[pos] + "]: ");
		// write supplied format string and args
		write(String.format(fmt, args));
		// add a newline on the end, and we are done!
		write("\n");
	}

	/**
	 * Format and write arguments to log.
	 *
	 * @param fmt       format string
	 * @param args      format arguments (optional)
	 */
	public void print(@NotNull String fmt,
	                  @Nullable Object...args)
	{
		print(LEVEL.INFO, fmt, args);
	}

	/**
	 * Close the logging system, and release file handles.
	 */
	public void close()
	{
		// copy reference of fd
		Object elem = fd;
		// release and clear values
		fd = null;
		entriesWritten = 0;

		// if we have a file open, close that bad boy
		if(elem instanceof FileWriter) {
			try {
				((FileWriter)elem).close();
			} catch(IOException e) {
				e.printStackTrace();
			}
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
		return "Log: " + name + " {" + entriesWritten + "}";
	}
}
