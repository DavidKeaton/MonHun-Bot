package info.davek.mhbot.LexLudroth;

import java.util.function.Consumer;

/**
 * Creates named bot command, and respective function.
 */
public class Command
{
	// name of command
	private final String name;
	// description of command
	private final String desc;
	// function for command to execute
	private final Consumer<Object> func;

	/**
	 * Create named command `func', with command description.
	 * @param name      name of command
	 * @param desc      description of command
	 * @param func      the function to execute when executed
	 */
	public Command(String name, String desc, Consumer<Object> func)
	{
		this.name = name;
		this.desc = desc;
		this.func = func;
	}

	/**
	 * Returns the name of the command.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Returns the description of the command.
	 */
	public String getDesc()
	{
		return desc;
	}

	/**
	 * Returns the function of the command.
	 */
	public Consumer<?> getFunc()
	{
		return func;
	}

	public void accept(Object arg)
	{
		this.func.accept(arg);
	}
}
