/* 
Tom Ayotte
600.107
April 25, 2012
9a
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

import java.util.*;

public class pg9a{
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		String line = "";
		String orig = "";
		
		for(int i = 1; i <= 5; i++){
		System.out.println("Enter line " + i + " of text to check:");
		orig = keyboard.nextLine();
		line = orig.toLowerCase().replaceAll(" ", "");
		//System.out.println(line);
		
		if(checkLine(line))
			System.out.println("The line '" + orig + "' is:\nValid\n");
		else
			System.out.println("The line '" + orig + "' is:\nInvalid\n");
		}
		
		System.out.println("Thanks for playing!");
	
	}//end main
	
	/** Check to see if the line is valid
	 * Áhola amigo!
	 * Àcomo estas bueno?
	 * ÁNACHOS GRANDE!
	 * @param line line that gets checked
	 * @return boolean true if the line is valid, false if it isn't
	 */
	public static boolean checkLine(String line){
		int comma = line.indexOf("now,");
		int comma1 = line.indexOf("well,");
		int semi = line.indexOf(";then");
		int umm = line.indexOf("umm");
		
		if(line.equals(""))
			return false;
		if(line.equals("ok"))
			return true;
		if(line.equals("so"))
			return true;
		if(comma == 0)
			return checkLine(line.substring(4));
		if(comma1 == 0)
			return checkLine(line.substring(5));
		if(semi >=2){
			return checkLine(line.substring(0,semi)) && checkLine(line.substring(semi+5));
		}
		if(umm == 0){
			return umm(line.substring(umm+3),1);
		}
			
		return false;
	}//end checkLine
	
	/** checks if the number of umms is valid
	 *	@param u string to be checked for number of umms
	 * @param i number of umms thus far
	 * @return boolean true if valid, false else
	 */
	public static boolean umm(String u, int i){
		int indx = u.indexOf("umm");
		
		if(indx == 0)
			return umm(u.substring(indx+3),2);
		if(u.equals("") && i > 1)
			return true;
		
		return false;
	}//end umm
}//end class

/*
No warmup.
This assignment wasn't overly difficult it took about 2 hours to complete. The
hardest part was the umms and figuring out what exactly the assignment was looking
for. I would make the assignment explaination more detailed because it is very
confulsing what is actually valid and what is not.
*/