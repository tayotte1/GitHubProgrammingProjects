public class war_HUH{
	public static void main(String[] args){
/*	
		Deck theDeck = new Deck();
		Player tom = new Player("Tom");
		Player kielan = new Player("Kielan");
		Player lindsay = new Player("Lindsay");
		
		theDeck.shuffle();
		
		theDeck.dealCard(tom);
		theDeck.dealCard(kielan);
		theDeck.dealCard(lindsay);
		
		Card c1 = tom.playCard();
		Card c2 = kielan.playCard();
		Card c3 = lindsay.playCard();
*/		
		Card c1 = new Card("Ace", "Spades");
		Card c2 = new Card("King", "Diamonds");
		Card c3 = new Card(7, "Clubs");
		Card c4 = new Card(7, "Clubs");
		
		System.out.println("c1 is " + c1);
		System.out.println("c2 is " + c2);
		System.out.println("c3 is " + c3);

		Card best;
		if(c1.compareTo(c2) >= 0)
			best = c1;
		else
			best = c2;
		if(c3.compareTo(best) >= 0)
			best = c3;
		System.out.println("The best mutha fuckin' card is the " + best);
		
		if(c1.equals(c2))
			System.out.println("c1 same as c2");
		if(c3.equals(c4))
			System.out.println("c1 same as c4");
			
		Card.aceLow();
		
		if(c1.compareTo(c2) >= 0)
			best = c1;
		else
			best = c2;
		if(c3.compareTo(best) >= 0)
			best = c3;
		System.out.println("The best mutha fuckin' card is the " + best);

	}
}