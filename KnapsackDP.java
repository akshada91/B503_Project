/*Dynamic programming is an approach to derive optimal solution for solving the 01-knapsack problem. 
In Dynamic Programming a complex problem is broken into collection of simpler sub problems. The sub problems are then solved. 
*/
import java.io.*;

class KnapsackDP
{
    public static void main(String[] args) throws Exception 
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("Enter the number of elements");
		int num = Integer.parseInt(br.readLine()); // Number of items
		int weight[] = new int[num]; //Array to store the weight of all the items
		int value[] = new int [num]; // Array to store the value of the items
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
		int kweight=Integer.parseInt(br.readLine());
        System.out.println(knapsackdp(value, weight, kweight));
    
    }
    public static int knapsackdp(int value[], int weight[], int kweight) 
    {
        int num = weight.length; // Get the total number of items. 
        int[][] dpvalue = new int[num + 1][kweight + 1]; //Create a matrix. Items are in rows and weight at in columns +1 on each side
        for (int i=0;i<=num;i++) //If the knapsack weight is 0 or there are no items initialize the dpvalue table to 0
        {
        	for (int j=0;j<=kweight;j++)
        	{
        		if(i==0 || j==0)
        		{
        			dpvalue[i][j]=0;
        		}
        	}
        		
        }
        for (int item=1;item<=num;item++)
        {
            //Let's fill the values row by row
            for (int wt=1;wt<=kweight;wt++){
                //Is the current items weight less than or equal to running weight
                if (weight[item-1]<=wt)
                {
                    //Given a weight, check if the value of the current item + value of the item that we could afford with the remaining weight
                    //is greater than the value without the current item itself
                    dpvalue[item][wt]=Math.max (value[item-1]+dpvalue[item-1][wt-weight[item-1]], dpvalue[item-1][wt]);
                }
                else {
                    //If the current item's weight is more than the running weight, just carry forward the value without the current item
                    dpvalue[item][wt]=dpvalue[item-1][wt];
                }
            }
        }
        for (int[] rows : dpvalue) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }
        return dpvalue[num][kweight];
    }
}