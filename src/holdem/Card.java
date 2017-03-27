package holdem;

public class Card {
	private int index;
	private Suit suit;
	
	Card(int x, Suit s){
		setIndex(x);
		setSuit(s);
	}
	Card(int x, int s){
		setIndex(x);
		setSuit(s);
	}

	private void setSuit(int s) {
		if (s == 0){
			setSuit(Suit.CLUBS);
		}else if (s == 1){
			setSuit(Suit.SPADES);
		}else if (s == 2){
			setSuit(Suit.HEARTS);
		}else if (s == 3){
			setSuit(Suit.DIAMONDS);
		}else{
			throw new java.lang.Error(Integer.toString(s));
		}
			
	}
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}
}
