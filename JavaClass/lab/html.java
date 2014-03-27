import java.util.*;
import java.io.*;


public class html{

	public static Random rand = new Random();
	
	public static void main(String args[])throws IOException{
	
		String input, fileName = "", newName = "";
		Scanner keys = new Scanner(System.in);
		
		System.out.println("What is the name of the file? ");
		fileName = keys.next();
		newName = fileName + ".html";
		File newFile = new File(newName);
		
		Scanner inFile = new Scanner(new FileReader(fileName));
		PrintWriter outFile = new PrintWriter(new FileWriter(newName));
		
		do{
			input = inFile.nextLine();
			 
			outFile.println(font(heading(center(input))));
		
		}while(inFile.hasNextLine());
		
		outFile.close();
		
	}//end main
	
	
/** take a string and randomly choose a heading size
	@param text line of text to be formatted
	@return formatted line in html code
*/
	public static String heading(String text) {
		int size = 1 + rand.nextInt(6);
		text = "<h" + size + ">" + text + "</h" + size + ">";
		return text;
	} //end of heading method
	


/** take a string and randomly choose a font color
	@param text line of text to colorize
	@return line of formatted html code
	
*/
	public static String font(String text) {
		char x, y, z;
		String option = "0369CF";
		
		x = option.charAt(rand.nextInt(6));
		y = option.charAt(rand.nextInt(6));
		z = option.charAt(rand.nextInt(6));
		
		text = "<font color=\"#" + x + x + y + y + z + z + "\">" + text + "</font>";
		return text;

	}

/* take a string and randomly choose whether to center or not
	@param text line of text to center or not
	@return line of text that is centered or not
*/
	public static String center(String text){
		int chose = rand.nextInt(2);
		
		if(chose == 0){
			text = "<center>" + text + "</center>";
		}
		return text;
	}

}//end class