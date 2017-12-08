package algo.greedy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * The Merry Milk Makers company has several farmers from which they may buy
 * milk, and each one has a (potentially) different price at which they sell to
 * the milk packing plant. Moreover, as a cow can only produce so much milk a
 * day, the farmers only have so much milk to sell per day. Each day, Merry Milk
 * Makers can purchase an integral amount of milk from each farmer, less than or
 * equal to the farmer's limit. Given the Merry Milk Makers' daily requirement
 * of milk(totalneed), along with the cost per gallon(p[i]) and amount of
 * available milk for each farmer(a[i]), write an efficient function to
 * calculate the minimum amount of money that it takes to fulfill the Merry Milk
 * Makers' requirements. Assume that the total milk produced per day by the
 * farmers will be sufficient to meet the demands of the Merry Milk Makers and
 * p[i] value will be between 0 and 1000. What are the time and space
 * complexities of your solution?
 * 
 * Function Prototype: int FindMinCost(int * totalneed, int nfarmers, int *a,
 * int *p)
 * 
 * Example: Input: totalneed=100 nfarmers=5
 * 
 * a[] = 20 40 10 80 30 p[] = 5 9 3 8 6
 * 
 * Output: 630
 * 
 * @author ajinkyab
 * 
 */
public class MinimizeAmountSpentToBuyMilk
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter total no of farmers available : ");
		int nFarmers = scan.nextInt();

		System.out.println("Enter total milk required in Gallon : ");
		int totalNeed = scan.nextInt();

		List<Farmer> farmerList = populateFarmerData(nFarmers);

		System.out.println("Min Cost required is : " + findMinCost(totalNeed, farmerList));

	}

	private static int findMinCost(int totalNeed, List<Farmer> farmerList)
	{
		int totalCost = 0;
		int sum = 0;

		System.out.println("Before sorting");
		printList(farmerList);

		Collections.sort(farmerList);

		System.out.println("After sorting");
		printList(farmerList);

		for (int i = 0; i < farmerList.size(); ++i)
		{
			if (sum >= totalNeed)
				break;

			if (totalNeed - sum > 0)
			{
				if (sum + farmerList.get(i).getMilkQuantity() > totalNeed)
				{
					int diff = farmerList.get(i).getMilkQuantity() - (totalNeed - sum);
					if (diff > 0)
					{
						sum += diff;
						totalCost += diff * farmerList.get(i).getCostPerGallon();

					}
				} else
				{
					sum += farmerList.get(i).getMilkQuantity();
					totalCost += farmerList.get(i).getCostPerGallon() * farmerList.get(i).getMilkQuantity();
				}
				System.out.println("Sum is : " + sum);
				System.out.println("totalCost is : " + totalCost);

			}
		}

		return totalCost;
	}

	private static void printList(List<Farmer> farmerList)
	{
		for (Farmer farmer : farmerList)
		{
			System.out.println(farmer);
		}

	}

	private static List<Farmer> populateFarmerData(int nFarmers)
	{
		List<Farmer> farmerList = new ArrayList<Farmer>();
		for (int i = 0; i < nFarmers; ++i)
		{
			Scanner scan = new Scanner(System.in);

			System.out.println("Enter the details of farmer :" + (i + 1));
			System.out.println("Enter milk quantity: ");
			int milkQuantity = scan.nextInt();

			System.out.println("Enter milk cost per Gallon : ");
			int costPerGallon = scan.nextInt();

			Farmer farmer = new Farmer(milkQuantity, costPerGallon);

			farmerList.add(farmer);

		}
		return farmerList;
	}

}
