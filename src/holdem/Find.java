package holdem;

import java.util.ArrayList;
import java.util.Random;

public class Find {

	private static Random rngeezus = new Random();

	public static void main(String[] args) {

		Card[] cards = new Card[52];
		for (int a = 0 ; a < 4 ; a++){
			for (int b = 0 ; b < 13 ; b++){
				cards[(a*13)+(b+1)-1] = new Card(b+1,a);
			}
		}

		for (int c = 0; c < 52 ; c++){
			for(int d = c+1 ; d < 52 ; d++){
				simulate(c,d,cards);
			}
		}
	}

	private static void simulate(int c, int d, Card[] cards) {
		int[] wins = {0,0,0,0,0,0,0,0,0,0};
		Card[] deck = new Card[50];
		for (int a = 0 ; a < c ; a++){
			deck[a] = cards[a+1];
		}
		for (int a = c+1 ; a < d-1 ; a++){
			deck[a] = cards[a+1];
		}
		for (int a = d+1 ; a < 50-2 ; a++){
			deck[a] = cards[a+1];
		}

		Card card1 = cards[c];
		Card card2 = cards[d];

		for (int x = 0 ; x < 1000 ; x++){

			int n1 = rngeezus.nextInt(50);
			int n2 = rngeezus.nextInt(50);
			while (n2 == n1){
				n2 = rngeezus.nextInt(50);
			}
			int n3 = rngeezus.nextInt(50);
			while (n3 == n1 || n3 == n2){
				n3 = rngeezus.nextInt(50);
			}
			int n4 = rngeezus.nextInt(50);
			while (n4 == n1 || n4 == n2 || n4 == n3){
				n4 = rngeezus.nextInt(50);
			}
			int n5 = rngeezus.nextInt(50);
			while (n5 == n1 || n5 == n2 || n5 == n3 || n5 == n4){
				n5 = rngeezus.nextInt(50);
			}

			Card card3 = cards[n1];
			Card card4 = cards[n2];
			Card card5 = cards[n3];
			Card card6 = cards[n4];
			Card card7 = cards[n5];

			Card[] hand = {card1,card2,card3,card4,card5,card6,card7};

			if (isRoyalFlush(hand)){
				wins[9] += 1;
			}else if (isSFlush(hand)){
				wins[8] += 1;
			}else if (fourOfAKind(hand)){
				wins[7] += 1;
			}else if (isFlush(hand)){
				wins[5] += 1;
			}else if (isStraight(hand)){
				wins[4] += 1;
			}else if (threeOfAKind(hand)){
				wins[3] += 1;
			}else if (twoOfAKind(hand)){
				wins[1] += 1;
			}else{
				wins[0] += 1;
			}

		}System.out.print(Integer.toString(card1.getIndex()) + card1.getSuit() + " " + Integer.toString(card2.getIndex()) + card2.getSuit() + "		");
		for (int p = 0 ; p < 10 ; p++){

			System.out.print(p + " : " + wins[p] + " |");

		}System.out.println();
	}

	private static boolean isStraight(Card[] hand) {
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (Card c : hand){
			al.add(c.getIndex());
		}

		ArrayList<Integer> rf = new ArrayList<Integer>();
		for (int x = 1 ; x < 10 ; x++){
			rf.clear();rf.add(x);rf.add(x+1);rf.add(x+2);rf.add(x+3);rf.add(x+4);
			if (al.containsAll(rf))
				return true;
		}rf.clear();rf.add(1);rf.add(10);rf.add(11);rf.add(12);rf.add(13);
		if (al.containsAll(rf))
			return true;
		return false;
	}

	private static boolean isFlush(Card[] hand) {
		Suit s = mostSuit(hand);

		ArrayList<Integer> al = new ArrayList<Integer>();

		for (Card c : hand){
			if (c.getSuit().equals(s))
				al.add(c.getIndex());
		}

		if (al.size()>=5)
			return true;
		return false;
	}

	private static boolean threeOfAKind(Card[] hand) {
		if (ofAKind(hand) >= 3)
			return true;
		return false;
	}

	private static boolean isSFlush(Card[] hand) {
		Suit s = mostSuit(hand);

		ArrayList<Integer> al = new ArrayList<Integer>();

		for (Card c : hand){
			if (c.getSuit().equals(s))
				al.add(c.getIndex());
		}

		ArrayList<Integer> rf = new ArrayList<Integer>();
		for (int x = 1 ; x < 10 ; x++){
			rf.clear();rf.add(x);rf.add(x+1);rf.add(x+2);rf.add(x+3);rf.add(x+4);
			if (al.containsAll(rf))
				return true;
		}

		return false;
	}

	private static boolean isRoyalFlush(Card[] hand) {
		Suit s = mostSuit(hand);

		ArrayList<Integer> al = new ArrayList<Integer>();

		for (Card c : hand){
			if (c.getSuit().equals(s))
				al.add(c.getIndex());
		}

		ArrayList<Integer> rf = new ArrayList<Integer>();
		rf.add(1);rf.add(10);rf.add(11);rf.add(12);rf.add(13);

		if (al.containsAll(rf))
			return true;
		return false;
	}

	private static Suit mostSuit(Card[] hand) {
		int[] a = {0,0,0,0};
		for (Card c : hand){
			a[c.getSuit().getA()] += 1;
		}
		int max = 0;
		int pos = -1;
		for (int i = 0 ; i < a.length ; i++){
			if (a[i] > max){
				max = a[i];
				pos = i;
			}
		}
		return toSuit(pos);
	}

	private static Suit toSuit(int pos) {
		if (pos == 0)
			return Suit.CLUBS;
		else if (pos == 1)
			return Suit.SPADES;
		else if (pos == 2)
			return Suit.HEARTS;
		else if (pos == 3)
			return Suit.DIAMONDS;
		else
			return null;
	}

	private static boolean fourOfAKind(Card[] hand) {
		if (ofAKind(hand) >= 4)
			return true;
		return false;
	}

	private static int ofAKind(Card[] hand) {
		int[] arr = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		for (Card c : hand){
			arr[c.getIndex()-1] += 1;
		}
		int max = 0;
		for (int i : arr){
			if (i > max)
				max = i;
		}
		return max;
	}

	private static boolean twoOfAKind(Card[] hand) {
		if (ofAKind(hand) >= 2){
			return true;
		}
		return false;
	}

	private static boolean isSameSuit(Card[] hand) {
		int a = 0;
		for (int x = 1 ; x < hand.length ; x++){
			if (hand[0].getSuit().equals(hand[x].getSuit()))
				a++;
		}
		if (a > 2)
			return false;
		return true;
	}

	private static int isSubsequent(Card[] hand, int i) {
		int[] arr = new int[7];
		for (int x = 0 ; x < 7 ; x++){
			arr[x] = hand[x].getIndex();
		}
		java.util.Arrays.sort(arr);
		int[] arr1 = new int[5];
		int[] arr2 = new int[5];
		int[] arr3 = new int[5];
		for (int a = 0 ; a < 5 ; a++){
			arr1[a] = arr[a];
			arr2[a] = arr[a+1];
			arr3[a] = arr[a+2];
		}
		int[] arr4 = new int[5];
		for (int b = 0; b < 5 ; b++){
			arr4[b] = b+i;
		}
		if(arr1.equals(arr4))
			return 0;
		if(arr2.equals(arr4))
			return 1;
		if(arr3.equals(arr4))
			return 2;
		return -1;
	}
}
