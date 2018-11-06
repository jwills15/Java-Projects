
public class Calculations {

	//class variables
	private double dblBegin, dblEnd, dblDays, dblDayRate, dblMileRate, dblCost, dblAverageSale;
	//static variable that keeps track over time
	private static int intTotalCars = 0;
	private static double dblTotalSales = 0;
	
	//create class constructor
	Calculations(double theBegin, double theEnd, double theDays, double theDayRate, double theMileRate){
		
		dblBegin = theBegin;
		dblEnd = theEnd;
		dblDays = theDays;
		dblDayRate = theDayRate;
		dblMileRate = theMileRate;
		
	}
	
	private void CalculateCost(){
		
		dblCost = dblDays * dblDayRate + (dblEnd - dblBegin) * dblMileRate;
		intTotalCars++;
		dblTotalSales += dblCost;
		dblAverageSale = dblTotalSales / intTotalCars;
		
	}
	
	//allow user to get answers back
	public double getCost(){
		
		CalculateCost();
		return dblCost;
		
	}
	
	public int getTotalCars(){
		
		return intTotalCars;
		
	}
	
	public double getTotalSales(){
		
		return dblTotalSales;
		
	}
	
	public double getAverageSale(){
	
		return dblAverageSale;
		
	}
	
}
