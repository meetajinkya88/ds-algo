package tree.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.lang.Integer;

public class RandomTreeCreation
{
	private int noOfNodes;
	private int minRange;
	private int maxRange;
	private Random rand;

	public RandomTreeCreation(int noOfNodes, int minRange, int maxRange)
	{
		setMaxRange(maxRange);
		setMinRange(minRange);
		setNoOfNodes(noOfNodes);
		rand = new Random();
	}


	public   Integer randomInteger()
	{
		Set<Integer> randomIntSet = new HashSet<Integer>();
		int randomNum= 0;
		while(true)
		{
			// nextInt excludes the top value so we have to add 1 to include the top value
			randomNum = rand.nextInt((getMaxRange() - getMinRange()) + 1) + getMinRange();
			
			if(!randomIntSet.contains(randomNum))
				break;
		}
		return new Integer(randomNum);
	}
	public Random getRand()
	{
		return rand;
	}



	public void setRand(Random rand)
	{
		this.rand = rand;
	}



	public int getNoOfNodes()
	{
		return noOfNodes;
	}

	public void setNoOfNodes(int noOfNodes)
	{
		this.noOfNodes = noOfNodes;
	}

	public int getMinRange()
	{
		return minRange;
	}

	public void setMinRange(int minRange)
	{
		this.minRange = minRange;
	}

	public int getMaxRange()
	{
		return maxRange;
	}

	public void setMaxRange(int maxRange)
	{
		this.maxRange = maxRange;
	}

}
