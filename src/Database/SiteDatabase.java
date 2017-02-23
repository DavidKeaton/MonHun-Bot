package info.davek.mhbot.Database;

/**
 * Template of internet database querying.
 */
public abstract class SiteDatabase
{
	// URL of site
	private String URL;

	// contains contents of last page scrape
	private String screenBuffer;

	// grab contents of page, and return it
	protected String scrape(String path)
	{
		return "";
	}

	// search query on given SiteDatabase
	abstract public String search(String query);

	public String getURL()
	{
		return URL;
	}

	public void setURL(String URL)
	{
		this.URL = URL;
	}
}
