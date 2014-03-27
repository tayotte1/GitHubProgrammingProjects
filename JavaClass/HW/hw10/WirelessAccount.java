/** Class to represent and manipulate a cell phone account.
	@author Joanne Selinski
	@date 3/13/2012
*/

import java.text.DecimalFormat;

public class WirelessAccount implements Billable{

	// basic account information
	public String name;  // customer name
	private int area;     // area code
	private int exch;     // exchange part of phone number
	private int numb;     // last part of phone number

	// monthly billing data
	private int minutes;   // total calling minutes
	private int texts;     // total text messages
	private int data;      // total kilobytes transmitted
	private double owed = 0.00;
	
	//plan
	private Plan plan;

	// shared class data
	private DecimalFormat three0 = new DecimalFormat("000");
	private DecimalFormat four0 = new DecimalFormat("0000");

	public WirelessAccount(String name, int area, int number) {
		this.name = name;
		this.area = area;
		exch = (number / 10000);
		numb = (number % 10000);
	}

	public WirelessAccount(String who, String what) {
		name = who;
		area = Integer.parseInt(what.substring(1,4));
		exch = Integer.parseInt(what.substring(5,8));
		numb = Integer.parseInt(what.substring(9));
	}

	public String toString() {
		return name + " (" + three0.format(area) + ")" + 
			three0.format(exch) + "-" + four0.format(numb);
	}

	public int areaCode() {
		return area;
	}

	public int logCall(String starts, String ends) {
		int start = Integer.parseInt(starts);
		int end = Integer.parseInt(ends);

		// split each military time into hours and minutes
		int shour = start/100;
		int smin = start%100;
		int ehour = end/100;
		int emin = end%100;
		if (ehour < shour)  // rollover midnight
			ehour += 24;

		// calculate minutes since midnight for each time
		start = shour*60 + smin;
		end = ehour*60 + emin;

		// log the difference
		int diff = end - start;
		minutes += diff;
		return diff;
	}

	public void logText() {
		texts++;
	}

	public void logData(int size) {
		data += size;
	}

	public void displayBill() {
		System.out.println(toString());
		System.out.println("minutes: " + minutes + ", messages: " + texts +
						   ", data: " + data + " kb");
		minutes = 0;
		texts = 0;
		data = 0;
	}

	public boolean equals(WirelessAccount other) {
		return area == other.area && exch == other.exch && numb == other.numb;
	}

	public int compareTo(WirelessAccount other) {
		return name.compareToIgnoreCase(other.name);
	}
		
	/** Set the plan of this account
	  * @param p the plan that is to be assigned to this account
	*/
	public void setPlan(Plan p){
		plan = p;
	}
	
	/** Get the plan in String form
	  * @return the plan in String form
	*/
	public String getPlan(){
		return plan.toString();
	}
	
	//Billable stuff ========================================================

	/** Get the amount owed with the minutes, texts, and data of this account
	  * @param p the Plan that is used to get cost
	*/
	public double getCost(Plan p){
 		int m;
		int t;
			
		if(!(p instanceof TextPlan || p instanceof DataPlan)){
			m = minutes-p.getMins();
			if(m < 0)
				m = 0;
			return p.getPrice() + m*p.getMOverage();
		}
		
		else{
			m = minutes-p.getMins();
			t = texts-((TextPlan)p).getTexts();
			if(m < 0)
				m = 0;
			if(t < 0)
				t = 0;
			return p.getPrice() + m*p.getMOverage() + t*((TextPlan)p).getTOverage();
		}
	}
	
	/** Make a payment on the amount owed
	  * @param money amount to take off of the amount owed
	*/
	public void payment(double money){
		owed -= money;
	}
	
	/** Add interest to the amount owed
	  * @param percent the interest percent that is to be added
	*/
	public void interest(double percent){
		owed += (owed * percent);
	}
	
	/** Get the amount owed on bill
	  * @return the amount owed on the bill
	*/
	public double bill(){
		owed += this.getCost(plan);
		minutes = 0;
		texts = 0;
		return owed;
	}

}