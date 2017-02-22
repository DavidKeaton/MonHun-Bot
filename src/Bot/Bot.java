package info.davek.mhbot.Bot;

import info.davek.mhbot.Logger;

/**
 * Bot class, used to interact with Discord channel.
 *
 * @author David Keaton
 *
 * @since 2.22.17
 *  - initial creation
 *  - basic logging support, to default or named file
 *  - package structure creation for command parser and site interfaces
 *  - created basic command stack and command builder class
 */
public class Bot
{
	public static void main(String[] args)
	{
		// start default log
		Logger log = new Logger();
		log.write("NOW I FINALLY FEEL %s!", "FREE!!");
		log.close();
	}
}
