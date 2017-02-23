package info.davek.mhbot.MonHun;

/**
 * Represents an elemental type or status in Monster Hunter.
 */
public class Element
{
	public enum STATUS_TYPE {
		BLAST,
		POISON,
		SLEEP,
		PARALYSIS,
	}

	public enum ELEMENT_TYPE {
		FIRE,
		WATER,
		ICE,
		THUNDER,
		DRAGON,
	}

	// type of status, if present
	private STATUS_TYPE status;
	// type of element, if present
	private ELEMENT_TYPE element;
	// amount of element/status applied on hit
	private int amount;

	public Element(STATUS_TYPE type, int amount)
	{
		setStatus(type);
		setAmount(amount);
	}

	public Element(ELEMENT_TYPE type, int amount)
	{
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

	public STATUS_TYPE getStatus()
	{
		return status;
	}

	public void setStatus(STATUS_TYPE status)
	{
		this.status = status;
	}

	public ELEMENT_TYPE getElement()
	{
		return element;
	}

	public void setElement(ELEMENT_TYPE element)
	{
		this.element = element;
	}
}
