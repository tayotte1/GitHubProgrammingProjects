/* 
Tom Ayotte
600.107
March 28, 2012
WirelessAccount
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

import java.text.DecimalFormat;

public class WirelessAccount{

	//instance data members ===========================================
		private String name, number;
		private int mins, texts, data;
	
	//class data members ==============================================
		private static DecimalFormat areaForm = new DecimalFormat("000");
	
	
	//constructor - initialize a new Card object
	/** Set name and number of the new WirelessAccount and initialize all variables to 0
		* @param name the name of the account
		* @param number the number of the account
		* @param mins initial number of minutes for the account
		* @param texts initial number of texts for the account
		* @param data initial data amount for the account
	*/
	public WirelessAccount(String inName, int inArea, int inNum){
		name = inName;
		number = "" + areaForm.format(inArea) + inNum;
		number = "(" + number.substring(0,3) + ")" + number.substring(3,6) + "-" + number.substring(6);
		mins = 0;
		texts = 0;
		data = 0;
	}
	
	//constructor - initialize a new Card object
	/** Set name and number of the new WirelessAccount and initialize all variables to 0
		* @param name the name of the account
		* @param number the number of the account
		* @param mins initial number of minutes for the account
		* @param texts initial number of texts for the account
		* @param data initial data amount for the account
	*/	
	public WirelessAccount(String inName,String inNumber){
		name = inName;
		number = inNumber;
		mins = 0;
		texts = 0;
		data = 0;
	}
	
	/** converts WirelessAccount name and number into one String
		* @return String in format "name (123)456-7890"
	*/
	public String toString() {
		return name + " " + number;
	}
	
	/** gets the area code of the account in integer format
		* @return integer form of area code
	*/
	public int areaCode(){
		return Integer.parseInt(number.substring(1,4));
	}
	
	/** logs a call with start and end times given.
		* @param start the start time of the call in a string in military time
		* @param end the end time of the call in a string in military time
		* @return how long the call was in minutes
	*/
	public int logCall(String start, String end){
		int callMins;
		if(Integer.parseInt(end) > Integer.parseInt(start))
			callMins = ((Integer.parseInt(end)/100 - Integer.parseInt(start)/100)*60)+(Integer.parseInt(end)%100 - Integer.parseInt(start)%100);
		else{
			callMins = (((Integer.parseInt(end)+2400)/100 - Integer.parseInt(start)/100)*60)+((Integer.parseInt(end)+2400)%100 - Integer.parseInt(start)%100);
		}
		mins = mins + callMins;
		return callMins;
	}
	
	/** logs a text message by increasing the total texts by one
	*/
	public void logText(){
		texts++;
	}
	
	/** logs a data transaction by increasing the total data by however much is input
		* @param inData the amount the data is increased by
	*/
	public void logData(int inData){
		data += inData;
	}
	
	/** displays the monthly bill with the user's name, number, number of minutes used
				number of texts used, and total data used. Also sets the minutes, texts,
				and data back to zero for the account
	*/
	public void displayBill(){
		System.out.println(toString());
		System.out.println("Minutes = " + mins + ", Messages = " + texts + ", Data = " + data + " kb");
		mins = 0;
		texts = 0;
		data = 0;
	}
	
	/** checks if two WirelessAccounts have the same number
		* @param other the other WirelessAcount to compare numbers to
		* @return true if the two numbers are the same, false if they aren't
	*/
	public boolean equals(WirelessAccount other){
		if(number.equals(other.number))
			return true;
		return false;
	}
	
	/** compares the first letter of the name of two WirelessAcounts and sees which
				letter comes first in the alphabet
		* @param other the other WirelessAcount to compare numbers to
		* @return an integer that is positive if this WirelessAcount name comes before
		 		other's in the alphabet, and negative if the other's comes first
	*/
	public int compareTo(WirelessAccount other){
		int compare = (int)name.toLowerCase().charAt(0)-(int)other.name.toLowerCase().charAt(0);
		int x = 1;
		while (compare == 0){
			compare = (int)name.toLowerCase().charAt(x)-(int)other.name.toLowerCase().charAt(x);
			x++;
		}
		return compare;
	}
}


/*
This assignment was of average difficulty it took about 2 hours to do. The best part
was figuring out how to write our own instance methods. I would change it so that
what you wanted each method to do was clearer because I was not sure exactly how you
wanted some of the things done.
*/