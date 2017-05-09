//Max Dyson
//Project 1
//25.10.16
public class TaxChart
{
	private double [] grossIncome;
	
	public TaxChart (double [] gI )//(gI = gross income)
	{
		grossIncome = gI; //when grossIncome is accessed, it supplies a reference to gI
	}
	
	public void drawChart()
	{
		//used to store values produced from calling methods from TaxCalculator
		double [] nI = new double [grossIncome.length]; //(nI = net income)
		int [] tax = new int [grossIncome.length];
		Bar [] nIBar = new Bar [grossIncome.length];
		Bar [] taxBar = new Bar[grossIncome.length];
		Bar xAxis = new Bar();
		Bar yAxis = new Bar();
		final int SCALE_FACTOR = 3;
		
		for (int i = 0; i < grossIncome.length; i++) 
		{
		    nIBar[i] = new Bar();
		}
		
		for (int i = 0; i < grossIncome.length; i++) 
		{
		    taxBar[i] = new Bar();
		}
		
		xAxis.changeColour(Colour.BLACK);
		xAxis.changeSize(220, 1);
		xAxis.moveVertical(220);
		xAxis.makeVisible();
		yAxis.changeColour(Colour.BLACK);
		yAxis.changeSize(1, 220);
		yAxis.makeVisible();
		
		for (int i=0; i<grossIncome.length; i++) //populate the arrays with relevant values
		{
			tax[i] = TaxCalculator.payableTax(grossIncome[i]);
			nI[i] = TaxCalculator.remainingIncome(grossIncome[i], tax[i]);
			nIBar[i].changeColour(Colour.YELLOW);
			nIBar[i].moveVertical((int) (220 - (nI[i]/SCALE_FACTOR)));
			nIBar[i].moveHorizontal((int) ((grossIncome[i]/SCALE_FACTOR) + 0.5));
			nIBar[i].changeSize(4, (int) ((nI[i]/SCALE_FACTOR)+0.5));
			nIBar[i].makeVisible();
			taxBar[i].changeColour(Colour.RED);
			taxBar[i].moveVertical((int) (220 - (nI[i]/SCALE_FACTOR) - (tax[i]/SCALE_FACTOR)));
			taxBar[i].moveHorizontal((int) ((grossIncome[i]/SCALE_FACTOR) + 0.5));
			taxBar[i].changeSize(4, (int) ((tax[i]/SCALE_FACTOR)+0.5));
			taxBar[i].makeVisible();
		}
	}
	
	public void drawTable()
	{
		//used to store values produced from calling methods from TaxCalculator
		double [] nI = new double [grossIncome.length]; //(nI = net income)
		int [] tax = new int [grossIncome.length];
		
		System.out.println("The following is a table of gross income, tax and net income for different incomes. All values are in GBP (£)");
		System.out.println();
		System.out.println("Gross Income   Tax   Net Income");
		for (int i=0; i<grossIncome.length; i++) //populate the arrays with relevant values
		{
			tax[i] = TaxCalculator.payableTax(grossIncome[i]);
			nI[i] = TaxCalculator.remainingIncome(grossIncome[i], tax[i]);
			System.out.printf("%6.2f         %3d   %6.2f%n", grossIncome[i], tax[i], nI[i]);
			//System.out.println(grossIncome[i] + "  " + tax[i] + "  " + nI[i]);
		}
	}

}
