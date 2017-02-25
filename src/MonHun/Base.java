package info.davek.mhbot.MonHun;

/**
 * Base attributes for Monster Hunter information classes.
 */
public abstract class Base
{
	public enum TYPE {
		ITEM,
		WEAPON,
		ELEMENT,
		MONSTER
	}

	// _name of the item/weapon/monster
	private String _name;
	// id of the object
	private int _id;
	// _type of object stored in this class
	private TYPE _type;

	/**
	 * Create empty instantiation of this class, setting type to null.
	 */
	Base()
	{
		setType(null);
	}

	/**
	 * Basic initialization, only passing _type of class.
	 *
	 * @param type      type of object to be stored
	 */
	Base(TYPE type)
	{
		setType(type);
	}

	/**
	 * Initialize based on _type and _name.
	 *
	 * @param type      type of object
	 * @param name      name of object
	 */
	Base(TYPE type, String name)
	{
		setType(type);
		setName(name);
		setId(getIdByName(name));
	}

	/**
	 * Initialize based on _type and ID.
	 *
	 * @param type      type of object
	 * @param id        ID of object
	 */
	Base(TYPE type, int id)
	{
		setType(type);
		setId(id);
		setName(getNameById(id));
	}

	// TODO: finish ID->Name & Name->ID xlat.
	/**
	 * Get name by ID, if possible.
	 *
	 * @param id        id of object
	 * @return          name of object
	 */
	protected String getNameById(int id)
	{
		return "";
	}

	/**
	 * Get an ID by its name, if possible.
	 *
	 * @param name      name of object
	 * @return          id of object
	 */
	protected int getIdByName(String name)
	{
		return 0;
	}

	public String getName()
	{
		return _name;
	}

	protected void setName(String name)
	{
		this._name = name;
	}

	public int getId()
	{
		return _id;
	}

	protected void setId(int id)
	{
		this._id = id;
	}

	public TYPE getType()
	{
		return _type;
	}

	protected void setType(TYPE type)
	{
		this._type = type;
	}
}
