/* 
Tom Ayotte
600.107
April 18, 2012
pg8a
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

import java.util.*;
import java.io.*;

public class pg8a{
	public static void main(String[] args)throws IOException{
	
		AccountCollection accountColl = new AccountCollection();
		
		WirelessAccount temp;
		
		String transFile;
		Scanner keys = new Scanner(System.in);
		System.out.print("What is the name of your transaction file? ");
		transFile = keys.nextLine();
		System.out.println("Your transaction file is: " + transFile + "\n");
		
		Scanner inFile = new Scanner(new FileReader(transFile));
		char q;
		String name,num;
		String line;
		int paranth=0,area;
		
		do{
			line = inFile.nextLine();
			q = Character.toLowerCase(line.charAt(0));
			
			switch(q){
				case 'n':
					System.out.println("The number of accounts is: " + accountColl.numAccounts());
					break;
				case 'l':
					accountColl.sortName();
					break;
				case 'c':
					accountColl.sortNumber();
					break;
				case 'a':
					for(int i = 2; i<line.length();i++){
						if(line.charAt(i)=='(')
							paranth = i;
					}
					name = line.substring(2,paranth-1);
					num = line.substring(paranth);
					
					temp = new WirelessAccount(name,num);
					
					if(accountColl.checkAccount(temp)){
						System.out.println("You added account: " + name + " " + num);
						accountColl.addAccount(temp);
					}
					else
						System.out.println("There is already an account with number " + temp.getNumber());
					break;
					
				case 't':
					String y = line.substring(2);
					area = Integer.parseInt(y);
					if(accountColl.logText(area)>0)
						System.out.println("You logged a text for all accounts with area code " + y);
					else
						System.out.println("There are no accounts with area code " + y + " to log a text to");
					break;
				case 'k':
					if(accountColl.logData()>0){
						break;
					}
					else
						System.out.println("There are no accounts to log data to");
					break;
				case 'd':
					y = line.substring(2);
					if(accountColl.deleteNum(y)>0){
						System.out.println("You deleted account with number " + y);
					}
					else
						System.out.println("There is no account with the number " + y + " to delete");
					break;
				case 'b':
					accountColl.displayBill();
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
			System.out.println();
		}while(inFile.hasNextLine());
		
		System.out.println("End of Transaction List Thank You.");
	}
}

/*
The warmup was helpful in thinking about what methods were needed.
It took about 4 hours to do everything. The hardest part of this assignment was
adding each of the accounts but overall I didn't think the assignment was overly
difficult. I wouldn't change the assignment.
*/