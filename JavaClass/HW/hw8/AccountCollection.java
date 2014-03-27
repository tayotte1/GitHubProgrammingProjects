/* 
Tom Ayotte
600.107
April 18, 2012
Account Collection
781-771-7151
tayotte1
tayotte1@jhu.edu
*/
 
 import java.util.*;  
	
	public class AccountCollection{
   
   //instance class members
      private int num;
      private WirelessAccount[] accounts;
   
   /**	Create an AccountCollection 
   */ 
      public AccountCollection(){
         num = 0;
         accounts = new WirelessAccount[10];
      }
   
   /**	Add a WirelessAccount object to the collection 
   @param a WirelessAccount to be added to the collection 
   */ 
      public void addAccount(WirelessAccount a) 
      { 
         if(num == accounts.length)  
            resize(); 
      	 
         accounts[num] = a; 
         num++; 
      } 
   
   /**	Double the size of the collection 
   */ 
      private void resize() 
      { 
         WirelessAccount[] temp = new WirelessAccount[2*accounts.length]; 
         for( int i = 0; i < accounts.length; i++) 
            temp[i] = accounts[i]; 
         accounts = temp; 
      }
   /**	Check if the Wireless Account already exists in the collection 
   @param a WirelessAccount to check
   @return boolean of true if it doesn't exist, false if it already exists 
   */ 
      public boolean checkAccount(WirelessAccount a){
         boolean t = true;
         for(int i=0; i<num-1; i++){
            if(a.getNumber().equals(accounts[i].getNumber())){
               t = false;
            }
            else
               t = true;
         }
         return t;
      }
   
   /**	Return the number of accounts in the collection 
   @return int of how many accounts are int the collection
   */ 
      public int numAccounts(){
         return num;
      }
   	
   /**	Prints the accounts in string form from WirelessAccount 
   */ 
      public void print(){
         String acc = "";
         for(int i=0; i<num; i++){
            acc = acc + accounts[i].toString() + "\n";
         }
         System.out.print(acc);
      }
   
   /**	Sorts the WirelessAccounts by ascending number 
   */ 
      public void sortNumber() {
         if(num>0){
            System.out.println("List of Accounts Sorted by Ascending Number:");      
            WirelessAccount temp;
            for (int last = num-1; last > 0; last--){
               for (int curr = 0; curr < last; curr++){
                  if (accounts[curr].compareNum(accounts[curr+1]) > 0) {
                     temp = accounts[curr];
                     accounts[curr] = accounts[curr+1];
                     accounts[curr+1] = temp;
                  }               
               }	
            }	
            this.print();
         }
         else
            System.out.println("There are no accounts to display");
      }
   
   /**	Sorts the WirelessAccounts by ascending name 
   */ 
      public void sortName() {
         if(num>0){
            System.out.println("List of Accounts Sorted by Ascending Name:");
            WirelessAccount temp;
            for (int last = num-1; last > 0; last--){
               for (int curr = 0; curr < last; curr++){
                  if (accounts[curr].compareTo(accounts[curr+1]) > 0) {
                     temp = accounts[curr];
                     accounts[curr] = accounts[curr+1];
                     accounts[curr+1] = temp;
                  }
               }
            }
         
            this.print();
         }
         else
            System.out.println("There are no accounts to display");
      }
   
   /**	Logs a text to all accounts with a specific area code 
   @param a integer form of the area code
   @return integer of -1 if there are no accounts with the area code, 1 if there are 
   */ 
      public int logText(int a){
         int x = -1;
         for(int i=0; i<num; i++){
            if(accounts[i].areaCode()==a){
               accounts[i].logText();
               x = 1;
            }
         }
         return x;
      }
   
   /**	Logs a data transmission to all accounts
   @param data integer amount of data to add to accounts
   @return integer of -1 if there are no accounts, else number of accounts 
   */ 
      public int logData(){
			Random rand = new Random();
			int randNum;
		
         if(num>0){
            for(int i=0; i<num; i++){
					randNum = rand.nextInt(19)+2;
               accounts[i].logData(randNum);
					System.out.println("You logged " + randNum + " kilobytes to " + accounts[i].toString());
            }
         }
         return num;
      }
   
   /**	Deletes an account from the collection 
   @param number string form of the number
   @return integer of -1 if it didn't deleted an account, 1 if did
   */ 
      public int deleteNum(String number){
         int x = -1;
         for(int i=0; i<num; i++){
            if(number.equals(accounts[i].getNumber())){
               accounts[i] = accounts[num-1];
               num--;
               accounts[num] = null;
               x = 1;
            }
         }
         return x;
      }
   
   /**	Displays the bills of all the accounts in the collection
   */ 
      public void displayBill(){
         if(num>0){
            for(int i=0; i<num; i++){
               accounts[i].displayBill();
            }
         }
         else
            System.out.println("There are no accounts to display");
      }
   	
   }//end class