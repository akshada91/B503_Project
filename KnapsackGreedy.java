/*The value/ weight ratio is calculated to determine the items which has the highest capacity. The item with highest importance is selected
 * This process is continued until the knapsack cannot be filled any further*/
import java.io.*;

public class KnapsackGreedy
{
	public void Knapsack(int weight[],int value[],int num,int kweight,float ratio[])
	{
		Double result[]= new Double[num];
		int x= kweight;
		int tp=0;
		int i;
		for (i=0;i<num;i++)
		{
			result[i]=0.0;
		}
		for (i = 0; i < num; i++) 
		{
		      if (weight[i] > x)
		         break;
		      else
		      {
		         result[i] = 1.0;
		         tp = tp + value[i];
		         x = x - weight[i];
		      }
		   }
		
		 if (i < num)
		      result[i] = (double) (x / weight[i]);
		 
		   tp = (int) (tp + (result[i] * value[i]));
		 
		   System.out.println("\nThe result vector is:- ");
		   for (i = 0; i < num; i++)
		      System.out.println(result[i]);
		  
		   System.out.println("\nMaximum profit is:"+ tp);
		  
		}
		
	
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of elements");
		int num = Integer.parseInt(br.readLine()); // Number of items
		int weight[] = new int[num]; //Array to store the weight of all the items
		int value[] = new int [num]; // Array to store the value of the items
		float ratio[] = new float[num]; // Array to store the ratio of profit and weight
		int kweight; //weight of the knapsack
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
		float temp;
		
		for (int i=0;i<num;i++)
		{
			ratio[i]=value[i]/weight[i];
		}
		for (int i=0;i<num;i++)
		{
			for (int j=i+1;j<num;j++)
			{
				if (ratio[i] < ratio[j])
				{
				 	temp = ratio[j];
		            ratio[j] = ratio[i];
		            ratio[i] = temp;
		 
		            temp = weight[j];
		            weight[j] = weight[i];
		            weight[i] = (int) temp;
		 
		            temp = value[j];
		            value[j] = value[i];
		            value[i] = (int) temp;
				}
			}
		}

		KnapsackGreedy k= new KnapsackGreedy();
		k.Knapsack(weight,value,num,kweight,ratio);
	}

}
