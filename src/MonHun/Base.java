package info.davek.mhbot.MonHun;

import com.sun.istack.internal.Nullable;

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

	Base(String name)
	{
		setName(name);
		setType(lookup(null));
	}

	/**
	 * Basic initialization, only passing _type of class.
	 *
	 * @param type      type of object to be stored
	 */
	Base(Base.TYPE type)
	{
		setType(type);
	}

	/**
	 * Initialize based on _type and _name.
	 *
	 * @param type      type of object
	 * @param name      name of object
	 */
	Base(Base.TYPE type, String name)
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
	Base(Base.TYPE type, int id)
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

	/**
	 * Look up and return new MonHun.Base class representing `name'.
	 *
	 * @param name      name of weapon/item/monster/etc (optional, uses getName() otherwise)
	 * @return          MonHun.Base class representing `name'
	 */
	protected Base.TYPE lookup(@Nullable String name)
	{
		// hardcoded lookup switch, based on either given name or assigned name
		switch(((name == null) ? getName() : name).toLowerCase()) {
		// TODO: fill this sumbitch out
			case "deviljho":
				return Base.TYPE.MONSTER;
		}
		// unable to find
		return null;
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
