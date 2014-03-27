/* 
Tom Ayotte
600.107
May 2, 2012
Plan
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

import java.text.DecimalFormat;

public class Plan{

	//variables
	private double cost;
	private int maxMins;
	private double minsOverage;
	private int id;
	private static int counter = 1;
	
	private DecimalFormat two0 = new DecimalFormat("#0.00");
	
	/** Plan constructor
	  * @param c monthly cost of the plan
	  * @param m number of maximum minutes
	*/
	public Plan(double c, int m){
		cost = c;
		maxMins = m;
		minsOverage = .30;
		id = counter;
		counter++;
		
	}//end plan
	
	/** Change the charge for the overage minutes
	  * @param o the charge for overage minutes
	*/
	public void minsOverage(double o){
		minsOverage = o;
	}
	
	/** Change the cost of the plan
	  * @return the monthly price
	*/
	public double getPrice(){
		return cost;
	}
	
	/** Get the number of maximum minutes the plan has
	  * @return the number of minutes for the plan
	*/
	public int getMins(){
		return maxMins;
	}
	
	/** String form of plan
	  * @return the plan in String form
	*/
	public String toString(){
		return "ID: " + id + "\nCost: $" + two0.format(cost) + ", Max Mins: " + maxMins + ", Mins Overage Charge: $" + two0.format(minsOverage);
	}
	
	/** Get the overage charge
	  * @return the price for overage minutes
	*/
	public double getMOverage(){
		return minsOverage;
	}
	
	
	
}//end class


/*
The warm up was slightly confusing but the solution helped.
This assignignment was average in difficulty. It took about 3 hours to complete.
The most difficult part of the assignment was making sure everything interacted
correctly.
*/