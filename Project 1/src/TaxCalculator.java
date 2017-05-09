//Max Dyson
//Project 1
//22.10.16
import java.util.*; //importing utilities, including Scanner
public class TaxCalculator
{
	
	public static void main(String[] args)
	{
		//declaring and initialising variables
		double grossIncome = 0.0;
		int tax = 0;
		double netIncome = 0.0;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter the Gross Income (double) and press enter:"); //prompt statement
		grossIncome = keyboard.nextDouble(); //grossIncome is equal to the next double the user inputs
		keyboard.close(); // close keyboard as it is no longer needed
		tax = payableTax(grossIncome); //tax is equal to the value returned by the payableTax method when grossIncome is passed through it
		netIncome = remainingIncome(grossIncome, tax); //netIncome is equal to value returned by remainingIncome with the listed variables passed
		System.out.println("The tax payable on this income is £" + tax);
		System.out.println("The income after tax is £" + netIncome);
		
	}
	
	public static int payableTax(double gI) //works out how much tax should be paid based on the income of the child
	{
		//declaring and initialising variables
		double rawTax = 0.0;
		int roundedTax = 0;
		final double TAX_RATE0 = 0.0;
		final double TAX_RATE1 = 0.1;
		final double TAX_RATE2 = 0.2;
		final double TAX_RATE3 = 0.4;
		final double TAX_RATE4 = 0.6;
		final double TAX_RATE5 = 1.2;
		double taxStep0 = 100*TAX_RATE0; //if the income > 100, this stores the value of the tax to pay on the first 100
		double taxStep1 = 50*TAX_RATE1; // if the income > 150, this stores the value of tax to be paid on the next 50
		double taxStep2 = 50*TAX_RATE2; // if the income > 200, this stores the value of tax to be paid on the next 50
		double taxStep3 = 100*TAX_RATE3; // if the income > 300, this stores the value of tax to be paid on the next 100
		double taxStep4 = 100*TAX_RATE4; // if the income > 400, this stores the value of tax to be paid on the next 100
		double taxStep5 = 0.0;
		final int TAX_BRACKET0 = 100; //limits for the different tax brackets
		final int TAX_BRACKET1 = 150;
		final int TAX_BRACKET2 = 200;
		final int TAX_BRACKET3 = 300;
		final int TAX_BRACKET4 = 400;
		
		if (gI<=TAX_BRACKET0) //if the income is less than or equal to 100, no tax is paid (0th tax bracket)
		{
			return roundedTax; //still 0 at this point
		}
		else if (gI>TAX_BRACKET0 && gI<=TAX_BRACKET1) //1st real tax bracket
		{
			gI = gI-TAX_BRACKET0; //works out how far in to the bracket the income is by taking away the value of the previous brackets' upper limit
			 //taxStep1's value is changed as the remaining income to be taxed may not be the full £50
			taxStep1 = gI*TAX_RATE1; //income in this bracket times by the tax rate to work out tax in this bracket
			rawTax = taxStep0 + taxStep1; //raw tax is previous full tax brackets plus the section of this tax bracket worked out above
			roundedTax = (int) (rawTax+0.5); //rounds rawTax to nearest whole number
			return roundedTax;
		}
		else if (gI>TAX_BRACKET1 && gI<=TAX_BRACKET2)//2nd tax bracket, same system as previous bracket
		{
			gI=gI-TAX_BRACKET1;
			taxStep2 = gI*TAX_RATE2; //new tax rate for this bracket
			rawTax = taxStep0 + taxStep1 + taxStep2; //previous full tax added to this bracket's tax as an income in this range would pay full tax for previous brackets
			roundedTax = (int) (rawTax+0.5);
			return roundedTax;
		}
		else if (gI>TAX_BRACKET2 && gI<=TAX_BRACKET3)//3rd bracket
		{
			gI=gI-TAX_BRACKET2;
			taxStep3 = gI*TAX_RATE3;
			rawTax = taxStep0 + taxStep1 + taxStep2 + taxStep3;
			roundedTax = (int) (rawTax+0.5);
			return roundedTax;
		}
		else if (gI>TAX_BRACKET3 && gI<=TAX_BRACKET4)//4th bracket
		{
			gI=gI-TAX_BRACKET3;
			taxStep4 = gI*TAX_RATE4;
			rawTax = taxStep0 + taxStep1 + taxStep2 + taxStep3 + taxStep4;
			roundedTax = (int) (rawTax+0.5);
			return roundedTax;
		}
		else //5th bracket
		{
			gI=gI-TAX_BRACKET4;
			taxStep5 = gI*TAX_RATE5;
			rawTax = taxStep0 + taxStep1 + taxStep2 + taxStep3 + taxStep4 + taxStep5; //all previous brackets added
			roundedTax = (int) (rawTax+0.5);
			return roundedTax;
		}
	}
	
	public static double remainingIncome(double gI, int deduction) //works out net income from tax paid and gross income
	{
		double result = gI - deduction;
		
		if (result<0)
		{
			return 0.0; //income cannot be below 0, so return 0 if result = negative value
		}
		else
		{
			return result; //otherwise return the result
		}
	}

}
