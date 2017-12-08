package algo.greedy;

public class Farmer implements Comparable<Farmer>
{
	private int milkQuantity;
	private int costPerGallon;
	
	public  Farmer (int milkQuantity , int costPerGallon)
	{
		setMilkQuantity(milkQuantity);
		setCostPerGallon(costPerGallon);
	}
	public int getMilkQuantity()
	{
		return milkQuantity;
	}
	public void setMilkQuantity(int milkQuantity)
	{
		this.milkQuantity = milkQuantity;
	}
	public int getCostPerGallon()
	{
		return costPerGallon;
	}
	public void setCostPerGallon(int costPerGallon)
	{
		this.costPerGallon = costPerGallon;
	}
	
	@Override
	public int compareTo(Farmer o)
	{		
		if( this.costPerGallon > o.costPerGallon) 
			return 1;
		
		return -1;
	}
	public String toString()
	{
		return "Farmer object with milkQuantity: " + milkQuantity + " and costPerGallon : " + costPerGallon;
	}
	
	
}
