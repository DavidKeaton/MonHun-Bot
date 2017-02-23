package info.davek.mhbot.Database;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Represents connection to URL for database querying.
 */
public abstract class SiteDatabase extends HttpURLConnection
{
	// contains contents of last page scrape
	private String screenBuffer;
	private String lastQuery;

	/**
	 * Constructor for the HttpURLConnection.
	 *
	 * @param u the URL
	 */
	protected SiteDatabase(URL u)
	{
		super(u);
	}

	// grab contents of page, and return it
	protected String scrape(String path)
	{
		return "";
	}

	/**
	 * Searches through screenBuffer to find search `query'.
	 *
	 * @param query     the query to search the page for
	 * @return          a link to the info on `query'
	 */
	public String search(String query)
	{
		// update to the most recent query
		this.lastQuery = query;

		// TODO: return the URL for the given search
		return "";
	}

	@Override
	public void disconnect()
	{
		this.connected = false;
	}

	@Override
	public boolean usingProxy()
	{
		return false;
	}

	/**
	 * Once connected, scrape contents of page for search, iff !connected
	 *
	 * @throws IOException      if some error occurs during connection
	 */
	@Override
	public void connect() throws IOException
	{
		// does the page exist, and is it text?
		if(getResponseCode() == 200 && getContentType().startsWith("text")) {
			this.connected = true;
			// is there anything on the page?
			if(getContentLength() > 0) {
				// get the contents of the screen stored in cache
				screenBuffer = (String)getContent();
			}
		}
		disconnect();
	}
}
