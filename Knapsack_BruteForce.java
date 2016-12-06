/*Brute force approach is a straightforward approach to solve a problem. If there are N items, there are 2N possible combinations for the items to be selected. An item can either be selected or not selected.
In Brute force approach all 2n subsets are generated. The subsets whose sum exceed the knapsack weight are discarded. The subset whose total profit value is the maximum is selected from the remaining subsets.
We iterate through all the subsets of N items and pick up the subset with allowed weight that maximizes the value of the knapsack.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knapsack_BruteForce {
	
	public int BruteForce(int kweight, int[] weight, int[] value,int num_of_items)
	{
		if (num_of_items==0 || kweight==0)
			return 0;
		if (weight[num_of_items-1] > kweight)
		       return BruteForce(kweight, weight, value, num_of_items-1);
		else return max( value[num_of_items-1] + BruteForce(kweight-weight[num_of_items-1], weight, value, num_of_items-1),
				BruteForce(kweight, weight, value, num_of_items-1)
                 );
	}

	private int max(int x, int y) 
	{
		// TODO Auto-generated method stub
		if (x>y)
			return x;
		else
			return y;
	}

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of elements");
		int num = Integer.parseInt(br.readLine()); // Number of items
		int weight[] = new int[num]; //Array to store the weight of all the items
		int value[] = new int [num]; // Array to store the value of the items
		float ratio[] = new float[num]; // Array to store the ratio of profit and weight
		int kweight; //weight of the knapsack
		int capacity;
		for (int i=0;i<num;i++)
		{
		System .out.println("Enter the weight of the"+" "+(i+1)+" "+"item");
		weight[i]=Integer.parseInt(br.readLine());
		}
		for (int i=0;i<num;i++)
		{
		System.out.println("Enter the value of the"+" "+(i+1)+" "+"item");
		value[i] = Integer.parseInt(br.readLine());
		}
		System.out.println("Enter the knapsack weight");
		kweight=Integer.parseInt(br.readLine());
		Knapsack_BruteForce k= new Knapsack_BruteForce();
		int num_of_items=value.length;
		capacity=k.BruteForce(kweight,weight,value,num_of_items);
		System.out.println("The maximum value is"+capacity);
	}

}
