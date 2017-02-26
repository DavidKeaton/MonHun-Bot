package info.davek.mhbot.LexLudroth;

/**
 * Core commands used by our Discord bot.
 */
public class Core
{
	private static final Command[] commands = {
		new Command("help",
		            "Display help text",
		            null),

		new Command("version",
		            "Display version information",
		            null),

		new Command("",
		            "",
		            null),

		new Command("",
		            "",
		            null),

		new Command("",
		            "",
		            null),

		new Command("",
		            "",
		            null),
	};

	// usage information
	private final String USAGE = "INSERT USAGE INFO HERE";

	// version information
	private final String VERSION = "0.1a";

	/**
	 * Return static array ref to core commands.
	 *
	 * @return      static instance of the commands above
	 */
	public static Command[] getCommands()
	{
		return commands;
	}

	// Command: `!help'
	public void help()
	{
	}

	// Command: `!version'
	public void version()
	{
	}
}
