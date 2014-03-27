import java.util.Scanner;

public class math {
	public static void main(String args[]){
	
	char choice;
	int left = 1,right = 1,g=1;
	int guess,answer;
		
	do{
	
		Scanner key = new Scanner(System.in);
		
		
		System.out.println("(a)ddition");
		System.out.println("(s)ubtraction");
		System.out.println("(m)ultiplecation");
		System.out.println("(d)ivision");
		System.out.println("(q)uit");
		
		choice = key.next().charAt(0);
		choice = Character.toLowerCase(choice);
		
		left*=2;
		right++;
		
		switch(choice){
			case 'a':
				System.out.println("add: what is " + left + "+" + right + "? ");
				guess = key.nextInt();
				answer = left+right;
				if(guess == answer)
					System.out.println("Correct");
				else
					System.out.println("Wrong, correct answer is " + answer);
				break;
				
			case 's':
				System.out.println("subtract: what is " + left + "-" + right + "? ");
				guess = key.nextInt();
				answer = left-right;
				if(guess == answer)
					System.out.println("Correct");
				else
					System.out.println("Wrong, correct answer is " + answer);
				break;
				
			case 'm':
				System.out.println("multiply: what is " + left + "x" + right + "? ");
				answer = left*right;
				while(g<=3){
				guess = key.nextInt();
				if(guess == answer){
					System.out.println("Correct");
					break;
					}
				else if(g<3)
					System.out.println("Wrong, guess again:");
				else{
					System.out.println("Wrong, correct answer is " + answer);
					g = 1;
					break;
					}
				g = g+1;
				}
				break;
				
			case 'd':
				System.out.println("divide: what is " + left + "/" + right + "? ");
				answer = left/right;
				while(g<=3){
				guess = key.nextInt();
				if(guess == answer){
					System.out.println("Correct");
					break;
					}
				else if(g<3)
					System.out.println("Wrong, guess again:");
				else{
					System.out.println("Wrong, correct answer is " + answer);
					g = 1;
					break;
					}
				g = g+1;
				}
				break;
				
			case 'q':
				System.out.println("quit");
				break;
			default:
				System.out.println("you're a dumbass");
		};
	
	
	}while(choice != 'q');
	
	System.out.print("Thanks for being a nerd");

	}//end main
}//end class