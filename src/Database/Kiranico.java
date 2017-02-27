package info.davek.mhbot.Database;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Queries the online Monster Hunter database, `kiranico.com'
 */
public class Kiranico extends SiteDatabase
{
	private static final String BASE_URL = "http://mhgen.kiranico.com/";

	/**
	 * Connect to given path on Kiranico.
	 *
	 * @param u     URL to either use or append onto BASE_URL if relative path
	 * @throws MalformedURLException    when an illegal URL is given
	 */
	public Kiranico(URL u) throws MalformedURLException
	{
		super(u);
	}

	/**
	 * Connect to Kiranico site with `path' appended to URL.
	 *
	 * @param path      path to connect to
	 * @throws MalformedURLException    invalid URL given!
	 */
	public Kiranico(String path) throws MalformedURLException
	{
		// fix any leading slashes in path
		super(
			new URL(BASE_URL + (!path.startsWith("/") ? "/" : "") + path)
		);
	}
}
