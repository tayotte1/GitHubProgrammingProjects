/* 
Tom Ayotte
600.107
April 18, 2012
Wireless Account
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

/** Class to represent and manipulate a cell phone account.
	@author Joanne Selinski
	@date 3/13/2012
*/

   import java.text.DecimalFormat;

   public class WirelessAccount {
   
   // basic account information
      private String name;  // customer name
      private int area;     // area code
      private int exch;     // exchange part of phone number
      private int numb;     // last part of phone number
   
   // monthly billing data
      private int minutes;   // total calling minutes
      private int texts;     // total text messages
      private int data;      // total kilobytes transmitted
   
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
   
      public String getNumber(){
         return "(" + three0.format(area) + ")" + three0.format(exch) + "-" + four0.format(numb);
      }
   
	/**	Get the exchange in integer format 
	@return integer form of the exchange 
   */ 
      public int exchange(){
         return exch;
      }
   
	/**	Get the last four numbers of the number in integer format 
	@return integer form of the number 
   */ 
      public int number(){
         return numb;
      }
   /**	Get the name of the account 
	@return string form of the name of the account 
   */ 
      public String name(){
         return name.toLowerCase();
      }
   
	/**	Compares this WirelessAccount's number to another's
	@param other WirelessAccount to compare this WirelessAccount's number
	@return 1 if this number is larger, -1 if it is smaller 
   */ 
      public int compareNum(WirelessAccount other){
         
         if(this.areaCode() == other.areaCode()){
            if(this.exchange() == other.exchange()){
               if(this.number() > other.number()){
                  return 1;
               }         
            }
                     
            else if(this.exchange() > other.exchange()){
               return 1;
            }
                  
         }     
         else if (this.areaCode() > other.areaCode()) {
            return 1;
         }
         
      	return -1;
      			
      }
   }