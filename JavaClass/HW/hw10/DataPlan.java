/* 
Tom Ayotte
600.107
May 2, 2012
DataPlan
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

public class DataPlan extends TextPlan{
	
	// members
	private int maxData;
	
	/** DataPlan Constructor
	  * @param c monthly cost of the plan
	  * @param m max mins of plan
	  * @param t max texts of the plan
	  * @param d max data of the plan
	*/
	public DataPlan(double c, int m, int t, int d){
		super(c,m,t);
		maxData = d;
	
	}//end DataPlan

	/** String form of plan
	  * @return plan in String form
	*/
	public String toString(){
		return super.toString() + ", Max Data: " + maxData + " kb";
	}

}//end class