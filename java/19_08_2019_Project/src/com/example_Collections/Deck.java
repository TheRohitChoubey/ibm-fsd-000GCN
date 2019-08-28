package com.example_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Deck {
	private static Suit suit;
	private static Rank rank;
	private static List<Card> protoDeck = new ArrayList<Card>();
	static Scanner sc = new Scanner(System.in);

	static {

	}

	public static void main(String[] args) {
		int number = sc.nextInt();
		int hands = sc.nextInt();
		int nc = 0;

		for (Suit s : suit.values()) {
			for (Rank r : rank.values()) {
				protoDeck.add(new Card(s, r));
			}
		}
		
		Collections.shuffle(protoDeck);
		
		for(int i=0; i<hands; i++) {
			System.out.println(dealHand(protoDeck,number));
		}
	}
	
	public static List<Card> dealHand(List<Card> deck, int n) {
		int deckSize = deck.size();
		List<Card> handView = deck.subList(deckSize - n, deckSize);
		List<Card> hand = new ArrayList<Card>(handView);
		handView.clear();
		return hand;
	}

}
