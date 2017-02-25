package info.davek.mhbot.MonHun;

/**
 * Represents an item in Monster Hunter.
 */
public class Item extends Base
{
	// list of item types
	private enum TYPE {
		CONSUMABLE,
		TOOL,
		LOOT,
	}

	// type of item this represents
	private Item.TYPE type;
}
