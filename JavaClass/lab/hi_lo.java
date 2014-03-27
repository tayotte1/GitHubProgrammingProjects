import java.util.Scanner;
import java.util.Random;


public class hi_lo
{
public static void main (String[] args)
{
	// create variables to hold data and help with processing
	
	int number, guess, countguesses;
	int games = 0, wins = 0;
	boolean done;
	char answer;
	
	//create objects for random number generation and input
	
	Random rand = new Random();
	Scanner keyboard = new Scanner(System.in);
	
	//for as long as the user wants to play
	do {
			System.out.println("try to guess a number between 1 and 100");
			number = rand.nextInt(100);
			number=number+1;
			games = games+1;
			countguesses = 1;
			done = false;
			
			while(countguesses < 7&&!done)
			{
					System.out.print("guess "+ countguesses+":");
					guess=keyboard.nextInt();
					
					if(guess<number)
							System.out.println("too low");
					else if(guess>number)
							System.out.println("too high");
					else /* guess==number*/
					{
						wins=wins+1;
						System.out.println("you guessed it in " +countguesses + " tries!");
						done = true;
					}
					countguesses +=1;
			}
			System.out.println("play again?");
			answer=keyboard.next().charAt(0);
		} while (answer=='y' || answer=='Y');
		System.out.println("Thanks for playing-you won " +wins*100/games+" percent of games.");
}
}										
