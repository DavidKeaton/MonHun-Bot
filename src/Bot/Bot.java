package info.davek.mhbot.Bot;

import info.davek.mhbot.Database.Kiranico;
import info.davek.mhbot.Logger;

import java.net.MalformedURLException;
import java.net.URL;

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
 */
public class Bot
{
	// universal instance of the logger
	public static Logger log = new Logger();

	public static void main(String[] args)
	{
		// holds Kiranico connection
		Kiranico kira = null;
		// print Logger details
		System.out.println(log.toString());
		// quick test for SiteDatabase->Kiranico instantiation
		try {
			log.write("creating Kiranico class...");
			kira = new Kiranico("/monster/deviljho");
			// dump reference to Kiranico class
			System.out.println(kira.toString());
			log.write("created Kiranico class: %s", kira.toString());
			kira.disconnect();
			log.write("disconnected from: %s", kira.getURL());
		} catch(NullPointerException|MalformedURLException e) {
			System.err.println(e.toString());
		} finally {
			log.close();
		}
	}
}
