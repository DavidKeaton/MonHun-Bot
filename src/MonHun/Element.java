package info.davek.mhbot.MonHun;

/**
 * Represents an elemental type or status in Monster Hunter.
 */
public class Element extends Base
{
	// list of elements/statuses
	public enum TYPE {
		FIRE,
		WATER,
		ICE,
		THUNDER,
		DRAGON,
		BLAST,
		POISON,
		SLEEP,
		PARALYSIS,
	}

	// type of status/element, if present
	private Element.TYPE type;
	// amount of element/status applied on hit
	private int amount;

	public Element()
	{
		super(Base.TYPE.ELEMENT);
	}

	public Element(Element.TYPE element)
	{
		super(Base.TYPE.ELEMENT);
		setElement(element);
	}

	public Element(Element.TYPE type, int amount)
	{
		super(Base.TYPE.ELEMENT);
		setElement(type);
		setAmount(amount);
	}

	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public Element.TYPE getElement()
	{
		return type;
	}

	public void setElement(Element.TYPE element)
	{
		this.type = element;
	}
}
