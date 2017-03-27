package holdem;

public enum Suit {
	CLUBS(0), SPADES(1),HEARTS(2),DIAMONDS(3);
	
	private int a;
	
	Suit(int a){
		this.setA(a);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	
}
