package info.davek.mhbot.Database;

import info.davek.mhbot.MonHun.Base;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * TODO: return URL for given search - search()
 * TODO: grab page contents from URL and send to info decipher
 * TODO: base constructor capable of initializing itself based on simple query
 */

/**
 * Represents connection to URL for database querying.
 */
public abstract class SiteDatabase
	extends HttpURLConnection
	implements AutoCloseable
{
	// contains contents of last page scrape
	private String buffer;
	// MonHun.Base class, to store information subclasses
	private Base query;

	/**
	 * Constructor for the HttpURLConnection.
	 *
	 * @param u the URL
	 */
	SiteDatabase(URL u)
	{
		super(u);
	}

	SiteDatabase(String query)
	{
		super(null);
	}

	/**
	 * Craft URL for search query.
	 *
	 * @param query     what to search for
	 * @return          uri representation as URL
	 */
	abstract URL search(String query);

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
				setBuffer(getContent().toString());
			}
		}
		close();
	}

	protected void setBuffer(String buffer)
	{
		this.buffer = buffer;
	}

	protected String getBuffer()
	{
		return this.buffer;
	}

	public Base getQuery()
	{
		return query;
	}

	public void setQuery(Base query)
	{
		this.query = query;
	}

	@Override
	public void close()
	{
		disconnect();
	}

	@Override
	public String toString()
	{
		return super.toString() + "\n\n" + getBuffer();
	}
}
