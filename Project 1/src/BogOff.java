//Max Dyson
//Project 1
//25.10.16
import java.util.*;
public class BogOff
{
	public static void main(String[] args)
	{	
		TaxChart t = new TaxChart(inputArray());
		t.drawChart();
		t.drawTable();
	}
	
	public static double[] inputArray()
	{
		String input = "";
		String [] split = {"Test"};
		boolean [] taxBracket = new boolean [6];
		final int TAX_BRACKET0 = 100;
		final int TAX_BRACKET1 = 150;
		final int TAX_BRACKET2 = 200;
		final int TAX_BRACKET3 = 300;
		final int TAX_BRACKET4 = 400;
		
		for (int i = 0; i < taxBracket.length; i++) 
		{
		    taxBracket[i] = false;
		}
		
		Scanner keyboard = new Scanner (System.in);
		
		System.out.println("Please enter the incomes (double) seperated by a single space. Enter incomes that cover all tax brackets. Press ENTER when finished:");
		
		while(taxBracket[0] == false || taxBracket[1] == false || taxBracket[2] == false ||taxBracket[3] == false || taxBracket[4] == false || taxBracket[5] == false)
		{
			if (keyboard.hasNextLine())
			{
				input = keyboard.nextLine();
				split = input.split(" ");
			
			}
			else
			{
				System.out.println("It appears you did not enter anything");
			}
		
			double [] unsortedIncome = new double[split.length];
		
			for(int i = 0; i < split.length; i++)
			{
				unsortedIncome[i] = Double.parseDouble(split[i]);
			
				if(unsortedIncome[i] <= TAX_BRACKET0)
				{
					taxBracket[0] = true;
				}
				else if(unsortedIncome[i] > TAX_BRACKET0 && unsortedIncome[i] <= TAX_BRACKET1)
				{
					taxBracket[1] = true;
				}
				else if(unsortedIncome[i] > TAX_BRACKET1 && unsortedIncome[i] <= TAX_BRACKET2)
				{
					taxBracket[2] = true;
				}
				else if(unsortedIncome[i] > TAX_BRACKET2 && unsortedIncome[i] <= TAX_BRACKET3)
				{
					taxBracket[3] = true;
				}
				else if(unsortedIncome[i] > TAX_BRACKET3 && unsortedIncome[i] <= TAX_BRACKET4)
				{
					taxBracket[4] = true;
				}
				else if(unsortedIncome[i] > TAX_BRACKET4)
				{
					taxBracket[5] = true;
				}
			}
		
			if(taxBracket[0] == false || taxBracket[1] == false || taxBracket[2] == false ||taxBracket[3] == false || taxBracket[4] == false || taxBracket[5] == false)
			{
				System.out.println("You did not enter incomes that covered all tax brackets, please try again:");
			}
			else
			{
				double [] sortedIncome = sortArray(unsortedIncome);
				return sortedIncome;
			}
		
		}
		double [] test = new double[split.length];
		return test; //should never reach this point, but code not happy without return that is guaranteed, the return above is technically not guaranteed if the user cannot enter the correct values
	}
	
	public static double[] sortArray(double[] incomes)
	{
		for(int i = 0; i<incomes.length - 1; i++)
		{
			int smallIndex = i;
			
			for(int j = i+1; j<incomes.length; j++)
			{
				if(incomes[j] < incomes[smallIndex])
				{
					smallIndex = j;
				}
			}
			if (incomes[smallIndex] < incomes[i])
			{
				double temp = incomes[i];
				incomes[i] = incomes[smallIndex];
				incomes[smallIndex] = temp;
				
			}
		}
		return incomes;
	}
	

}
