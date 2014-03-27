public class Card{

	//instance data members ===========================================
	private int face;
	private String suit; //Spades, Diamonds, Hearts, Clubs
	
	//class data members ==============================================
	private static int aceValue = 14;
	public static final String[] SUITS = {"Diamonds", "Clubs", "Hearts", "Spades"};
	
	
	//constructor - initialize a new Card object
	/** Set the face value and suit of a Cartd.
		 @param value the face value, should be 2-14
		 @param suit the suit name, should be as above.
	*/
	public Card(String value, String suit){
		setFace(value);
		setSuit(suit);
	}
	
	/** Set the face value and suit of a Cartd.
		 Disclaimer: no data validation is done.
		 @param value the face value, should be 2-14
		 @param suit the suit name, should be as above.
	*/
	public Card(int value, String suit){
		face = value;
		this.suit = suit;
	
	}
	
	/** Set the face value of a playing Card. Checking value for validity.
	 	 @param face the original value
		 @return true if valid (therefore set), false.
	*/
	private boolean setFace(String face){
		if(face.equalsIgnoreCase("jack"))
			this.face = 11;
		else if(face.equalsIgnoreCase("queen"))
			this.face = 12;
		else if(face.equalsIgnoreCase("king"))
			this.face = 13;
		else if(face.equalsIgnoreCase("ace"))
			this.face = aceValue;
		else
			return false;
			
		return true;
	} 
	
	/** Set the suit value of a playing Card. Checking value for validity.
	 	 @param suit the suit name
		 @return true if valid (therefore set), false.
	*/
	private boolean setSuit(String suit){
		if(suit.equalsIgnoreCase("spades"))
			this.suit = "Spades";
		else if(suit.equalsIgnoreCase("diamonds"))
			this.suit = "Diamonds";
		else if(suit.equalsIgnoreCase("clubs"))
			this.suit = "Clubs";
		else if(suit.equalsIgnoreCase("hearts"))
			this.suit = "Hearts";
		else
			return false;
			
		return true;
	}
	
	public String toString(){
		String fstring;
		
		switch(face){
		case 11: fstring = "Jack"; break;
		case 12: fstring = "Queen"; break;
		case 13: fstring = "King"; break;
		case 1: case 14: fstring = "Ace"; break;
		default: fstring = face + "";
		}
		return fstring + " of " + suit;
	}

/**Find the value of the card
	*/
	public int value(){
	if(face == 1 || face == 14)
		return aceValue;
	return face;
		
	}

/** See if this card has the same values as other
	 @param other the card we're comparing to this
	 @return true if same, false otherwise
	*/
	
	public boolean equals(Card other){
		return value() == other.value() && suit.equalsIgnoreCase(other.suit);
		}
		
	public int suitNum(){
		for(int i=0; i<SUITS.length; i++)
			if(SUITS[i].equalsIgnoreCase(suit))
				return i;
		return -1;
	}
	
/** See how this card compares to another, based on face value and suit
	 @param other the card we're comparing to this
	 @return negative if this face< other's face
	 	positive if this face > other's face
	*/	
	public int compareTo(Card other){
		int diff = suitNum() - other.suitNum();
		if(diff==0)
			return value() - other.value();
		return diff;
		}

/** Set the ace value to 1
*/		
	public static void aceLow(){
		aceValue = 1;
	}
/** Set the ace value to 14
*/		
	public static void aceHigh(){
		aceValue = 14;
	}
	
	


}