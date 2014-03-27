import java.util.Scanner;

public class gpa{

	public static void main(String[] args){
	
		Scanner keyboard = new Scanner(System.in);
		int numCourse;
		int courseNum = 1;
		double credits = 0;
		double totalCredits = 0;
		double pnts;
		double totalPoints = 0;
		double GPA = 0;
		String grade;
		
		System.out.print("How many courses? ");
		numCourse = keyboard.nextInt();
		System.out.println("Input grades and credits ex. 1)A 3.5");
		
		while (courseNum <= numCourse){
		

		System.out.print(courseNum + ")");
		grade = keyboard.next();
		credits = keyboard.nextDouble();
		totalCredits = totalCredits + credits;
		courseNum = courseNum + 1;
		pnts = convertGrade(grade);
		totalPoints = (totalPoints + pnts*credits);
				
		}//end while
	
	GPA = totalPoints/totalCredits;
	
	System.out.printf("GPA = %.2f\n", GPA);// 
	
	if(GPA >= 3.5 && totalCredits >= 14.5)
		System.out.println("Dean's list!");
	else if (GPA < 2.0)
		System.out.println("Academic Probation Bitch");	
		
	}//end main
	
public static double convertGrade(String grade) {
	double points;
	char letter = grade.charAt(0);
	
	if(letter == 'a' || letter == 'A')
		points = 4;
	else if(letter == 'b' || letter == 'B')
		points = 3;
	else if(letter == 'c' || letter == 'C')
		points = 2;
	else if(letter == 'd' || letter == 'D')
		points = 1;
	else
		points = 0;
	
	if (grade.length() > 1){
		if(grade.charAt(1) == '+' && letter != 'A' || letter != 'a'){
			points = points + .3;
			}
		else if(grade.charAt(1) == '-' && letter != 'd' || letter != 'D'){
			points = points - .3;
			}
		}
return points;
}//end subroutine
}//end class