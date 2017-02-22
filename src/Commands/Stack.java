package info.davek.david.Commands;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Holds the stack of commands registered to the current bot.
 */
public class Stack
{
	private static HashMap<String, Command> stack = null;

	/**
	 * Create a new static command stack on creation, iff stack hasn't init
	 */
	public Stack()
	{
		if(stack == null) { // create a new command stack if there wasn't one
			stack = new HashMap<String, Command>();
		}
	}

	/**
	 * Return a list of registered commands by name.
	 */
	public ArrayList<String> getCommands()
	{
		ArrayList<String> list = new ArrayList<>();
		stack.forEach((k, v)->list.add(k));
		return list;
	}

	/**
	 * Adds a function to the command queue.
	 *
	 * @param cmd       the command to add
	 * @return          whether the command was successfully placed in stack
	 */
	public boolean push(Command cmd)
	{
		stack.put(cmd.getName(), cmd);
		return has(cmd.getName());
	}

	/**
	 * Remove a command from the stack, by name.
	 *
	 * @param name      name of the command to be removed
	 * @return          the command removed
	 */
	public Command pop(String name)
	{
		return stack.remove(name);
	}

	/**
	 * Returns the command associated with given name.
	 *
	 * @param name      name of command
	 * @return          Command object
	 */
	public Command get(String name)
	{
		return stack.get(name);
	}

	/**
	 * Determines whether a given command name exists in the stack.
	 *
	 * @param name      name of command
	 * @return          whether the command has been registered
	 */
	public boolean has(String name)
	{
		return stack.containsKey(name);
	}
}
