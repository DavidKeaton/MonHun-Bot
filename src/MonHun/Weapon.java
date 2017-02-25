package info.davek.mhbot.MonHun;

/**
 * Represents a weapon in Monster Hunter.
 */
public class Weapon extends Base
{
	// list of weapon types
	public enum TYPE {
		GREAT_SWORD,
		LONG_SWORD,
		DUAL_BLADES,
		SWORD_AND_SHIELD,
		LANCE,
		GUNLANCE,
		SWITCH_AXE,
		CHARGE_BLADE,
		INSECT_GLAIVE,
		LIGHT_BOWGUN,
		HEAVY_BOWGUN,
		BOW,
	}

	// what type of weapon is represented
	private Weapon.TYPE type;

	// power of weapon
	private int power;
	// element of weapon
	private Element element;
	// sharpness of weapon
	private int sharpness;

	/**
	 * Create a blank weapon.
	 */
	public Weapon()
	{
		super(Base.TYPE.WEAPON);
	}

	/**
	 * Create a weapon of `type'.
	 *
	 * @param type      Weapon.TYPE to create
	 */
	public Weapon(Weapon.TYPE type)
	{
		super.setType(Base.TYPE.WEAPON);
		setWeaponType(type);
	}

	/**
	 * Builder for Weapon, requires all arguments.
	 *
	 * @param type      Weapon.TYPE of weapon
	 * @param element   @ref Element of weapon
	 * @param power     raw power of weapon
	 * @param sharpness sharpness of weapon, in numerical form
	 */
	public Weapon(Weapon.TYPE type, Element element, int power, int sharpness)
	{
		super.setType(Base.TYPE.WEAPON);
		setWeaponType(type);
		setElement(element);
		setPower(power);
		setSharpness(sharpness);
	}

	public Weapon.TYPE getWeaponType()
	{
		return type;
	}

	public void setWeaponType(Weapon.TYPE type)
	{
		this.type = type;
	}

	public int getPower()
	{
		return power;
	}

	public void setPower(int power)
	{
		this.power = power;
	}

	public Element getElement()
	{
		return element;
	}

	public void setElement(Element element)
	{
		this.element = element;
	}

	public int getSharpness()
	{
		return sharpness;
	}

	public void setSharpness(int sharpness)
	{
		this.sharpness = sharpness;
	}

	// TODO: convert sharpness meter image (pixel scan) into number values
	private int convertSharpnessMeter(Object meter)
	{
		return 0;
	}
}
