/**
 * Class to hold a deck of cards
 */
 
import java.util.Random;

public class Deck{

	//hold a bunch of cards
	private Card[] deck;
	private int size; //how many actual cars are in the deck
	
	private static Random rand = new Random();
	
	/**
	 * Create a full deck
	 */
	public Deck(){
		//make memory for the array
		deck = new Card[52];
		size = 0;
		
		//fill the array
		for (int suit = 0; suit<4; suit++){
			for (int val = 2; val <=14; val++)
				deck[size++] = new Card(val, Card.SUITS[suit]);
		}
	}
	
	public String toString(){
		String myDeck = "";
		for (int i=0; i<size; i++)
			myDeck += deck[i] + "\n";
		return myDeck;
	}
	
	/**
	 *	Shuffle the cards, randomly pick 2 cards and swap over and over
	 */
	public void shuffle(){
		int one;
		int two;
		Card temp;
		for(int i=0; i<10*size; i++){
			one = rand.nextInt(size);
			two = rand.nextInt(size);
			temp = deck[one];
			deck[one] = deck[two];
			deck[two] = temp;
		}//end for
			
	}
	
	/**
	 * Deal one card from the top of the deck
	 * @return the card dealt
	 */
	public Card dealCard(){
		Card c = deck[--size];//subtract 1 from size first
		deck[size] = null;
		return c;
	}
	
	/**
	 *	Deal several catds form the top of the deck
	 * @param howmany is the number of cards to deal
	 * @return cards dealt
	 */
	public Card[] dealCards(int howmany){
		Card[] cards = new Card[howmany];
		for(int i=0; i<howmany; i++)
			cards[i] = dealCard();
		return cards;
	}
	
	/** Search for a card
		@param card
		@return
	*/
	public int find(Card card){
		for(int i=0; i<size; i++)
			if(deck[i].equals(card))
				return i;
			return -1;
	}
		
	
	/**
	 * Delete a specific card
	 * @param card the card to delete
	 * @return the care if found, null otherwise
	 */
	public Card delete(Card card){
		int where = find(card);
		if(where > -1){
			Card c = deck[where];
			deck[where] = deck[size-1];
			size--;
			deck[size] = null;
		return c;
		}
		return null;
		
	}//end delete
	
	public Card findValue(int val){
		for(int i=0; i<size; i++)
			if(deck[i].value() == val)
				return deck[i];
		return null;
	}
	
	/** Sort the deck: selection sort
	 */
	public void sort(){
		int min;
		Card temp;
		for(int position=0; position<size; position++){
			min = position;
			for(int i=position+1; i<size; i++){
				if(deck[i].compareTo(deck[min])<0)
					min = i;
			}
			temp = deck[min];
			deck[min] = deck[position];
			deck[position] = temp;
			
		}
	}//end sort

	public static void main(String[] args){
		Deck theDeck = new Deck();
		System.out.println(theDeck);
		Card c = theDeck.dealCard();
		System.out.println("card dealt: " + c);
		theDeck.shuffle();
		System.out.println("deck after shuffle:\n" + theDeck);
		System.out.println(theDeck.dealCards(5));//get the memory address
		System.out.println("next card dealt (6th): " + theDeck.dealCard());
		System.out.println(theDeck.delete(new Card(7, "Diamonds")) + " deleted");
		System.out.println(theDeck.delete(c) + " deleted");
		theDeck.sort();
		System.out.println("deck after sort: \n" + theDeck); 
	}
}//end class