package info.davek.mhbot.MonHun;

/**
 * Represents a weapon in Monster Hunter.
 */
public class Weapon
{
	// all types of weapons
	public enum WEAPON_TYPE {
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
	private WEAPON_TYPE type;

	// power of weapon
	private int power;
	// element of weapon
	private Element element;
	// sharpness of weapon
	private int sharpness;

	/**
	 * Only constructor for Weapon, requires all arguments.
	 *
	 * @param type      WEAPON_TYPE of weapon
	 * @param element   @ref Element of weapon
	 * @param power     raw power of weapon
	 * @param sharpness sharpness of weapon, in numerical form
	 */
	public Weapon(WEAPON_TYPE type, Element element, int power, int sharpness)
	{
		setWeaponType(type);
		setElement(element);
		setPower(power);
		setSharpness(sharpness);
	}

	public WEAPON_TYPE getWeaponType()
	{
		return type;
	}

	public void setWeaponType(WEAPON_TYPE type)
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

	/**
	 * Convert an image representation of the sharpness bar into numbers
	 *
	 * @return      the numerical representation of the sharpness meter
	 */
	// TODO: convert sharpness meter image (pixel scan) into number values
	private int convertSharpnessMeter(Object meter)
	{
		return 0;
	}
}
