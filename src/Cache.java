package info.davek.mhbot;

import java.util.HashMap;
import info.davek.mhbot.MonHun.Base;

/**
 * Stores information to be readily available and cut down on requests/latency.
 */
public class Cache
{
	// HashMap<String, MonHun::Base>    (or just Objects, if necessary)
	private HashMap<Object, Object> cache = null;

	/**
	 * Create a new Cache by allocating its Map.
	 */
	public Cache()
	{
		if(cache == null) {
			cache = new HashMap<>();
		}
	}

	/**
	 * Clear the contents of the cache.
	 */
	public void clear()
	{
		if(cache != null) {
			cache.clear();
		}
	}

	/**
	 * Place elem into cache, iff not present.
	 *
	 * @param elem      the element to place in cache
	 */
	public void put(Object elem)
	{
		if(cache != null) {
			// is the object a base information class?
			if(elem instanceof Base) {
				// use the name of the element as its key
				String key = ((Base)elem).getName();
				// as long as it doesn't exist, place it in the cache
				if(!has(key)) {
					cache.put(key, elem);
				}
			// not base info class, search via `elem'
			} else {
				if(!has(elem)) {
					// use the object's hashcode for a key
					cache.put(elem.hashCode(), elem);
				}
			}
		}
	}

	/**
	 * Determines if the cache contains the given key.
	 *
	 * @param key       name of object
	 * @return          whether the object exists in cache
	 */
	public boolean has(String key)
	{
		return cache != null && cache.containsKey(key);
	}

	/**
	 * Determines if the cache contains the given object.
	 *
	 * @param elem      the object to search for
	 * @return          whether the object exists in the cache
	 */
	public boolean has(Object elem)
	{
		return cache != null && cache.containsValue(elem);
	}

	/**
	 * Returns the cached object specified by key, or null if not found.
	 * @param key       the name of the object
	 * @return          the object placed in the cache
	 */
	public Object get(String key)
	{
		if(cache == null) {
			return null;
		}
		return cache.get(key);
	}
}
