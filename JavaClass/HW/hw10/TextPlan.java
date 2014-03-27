/* 
Tom Ayotte
600.107
May 2, 2012
TextPlan
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

import java.text.DecimalFormat;

public class TextPlan extends Plan{
	
	//members
	private int maxTexts;
	private double textOverage;
	
	private DecimalFormat two0 = new DecimalFormat("#0.00");
	
	/** TextPlan constructor
	  * @param c monthly cost of the plan
	  * @param m max mins of the plan
	  * @param t max texts of the plan
	*/
	public TextPlan(double c, int m, int t){
		super(c,m);
		maxTexts = t;
		textOverage = .04;
		
	}//end TextPlan
	
	/** Change the charge for the overage texts
	  * @param o overage charge for texts
	*/
	public void textOverage(double o){
		textOverage = o;
	}
	
	/** Get the number of maximum texts the plan has
	  * @return number of max texts of the plan
	*/
	public int getTexts(){
		return maxTexts;
	}
	
	/** String form of plan
	  * @return the plan in String form
	*/
	public String toString(){
		return super.toString() + ", Max Texts: " + maxTexts + ", Texts Overage Charge: $" + two0.format(textOverage);
	}
	
	/** Get the texts overage charge
	  * @return the overage charge for texts
	*/
	public double getTOverage(){
		return textOverage;
	}
	
}//end class