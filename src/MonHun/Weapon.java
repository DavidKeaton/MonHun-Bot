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

	/**
	 * Create default weapon if none assigned, default = GREAT_SWORD
	 */
	public Weapon()
	{
		setWeaponType(WEAPON_TYPE.GREAT_SWORD);
	}

	/**
	 * Create weapon based on `type'.
	 *
	 * @param type      WEAPON_TYPE of weapon
	 */
	public Weapon(WEAPON_TYPE type)
	{
		setWeaponType(type);
	}

	public WEAPON_TYPE getWeaponType()
	{
		return type;
	}

	public void setWeaponType(WEAPON_TYPE type)
	{
		this.type = type;
	}
}
