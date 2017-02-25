package info.davek.mhbot.Database;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Queries the online Monster Hunter database, `kiranico.com'
 */
public class Kiranico extends SiteDatabase
{
	private static final String BASE_URL = "http://mhgen.kiranico.com";

	/**
	 * Connect to given path on Kiranico.
	 *
	 * @param u     URL to either use or append onto BASE_URL if relative path
	 * @throws MalformedURLException    when an illegal URL is given
	 */
	public Kiranico(URL u) throws MalformedURLException
	{
		super(!u.toString().startsWith("http")
			? new URL(BASE_URL
					+ ((u.toString().startsWith("/")) ? "" : "/") + u) : u);
	}

	@Override
	protected String scrape(String path)
	{
		return null;
	}

	@Override
	public String search(String query)
	{
		return null;
	}
}
