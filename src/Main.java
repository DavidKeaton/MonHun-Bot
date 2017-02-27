package info.davek.mhbot;

import info.davek.mhbot.Database.Kiranico;

import java.net.MalformedURLException;

/**
 * Discord bot for Monster Hunter resource querying via chat commands.
 *
 * @author David Keaton
 *
 * @since 2.22.17
 *  - initial creation
 *  - basic logging support, to default or named file
 *  - package structure creation for command parser and site interfaces
 *  - created basic command stack and command builder class
 *
 *  @since 2.25.17
 *  - added caching system
 *  - created templates for monhun info (Monster, Item, Weapon, etc)
 *  - abstracted class for site database searching
 *
 *  @since 2.26.17
 *  - better log support
 *  - improvements on SiteDatabase class
 *  - class renaming (Logger->Log, Bot.Bot->Main)
 */
public class Main
{
	// universal instance of the logger
	public static Log log = new Log();

	public static void main(String[] args)
	{
		// holds Kiranico connection
		// print Log details
		System.out.println(log.toString());
		// quick test for SiteDatabase->Kiranico instantiation
		try(Kiranico kira = new Kiranico("/monster/deviljho")) {
			log.print("created Kiranico class: %s", kira.toString());
			kira.disconnect();
		} catch(NullPointerException|MalformedURLException e) {
			log.print(Log.LEVEL.ERROR, e.toString());
		} finally {
			log.close();
		}
	}
}
