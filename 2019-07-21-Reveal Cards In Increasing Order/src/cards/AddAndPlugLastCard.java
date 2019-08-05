package cards;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/
 */
public class AddAndPlugLastCard { 
	
	/**
	 * Entry point that prints the array set as in the task description; 
	 */
	public static void main(String[] args) {
		int[] arr = { 17, 13, 11, 2, 3, 5, 7 };
		AddAndPlugLastCard solution = new AddAndPlugLastCard();
		System.out.println(Arrays.toString(solution.deckRevealedIncreasing(arr)));
	}
	
	/**
	 * 
	 * @param deck array of integers representing a deck of cards
	 * @return a deck that by taking 2 top cards, printing first and appending the second, you get a sorted appearence of cards on the screen. 
	 */
	public int[] deckRevealedIncreasing(int[] deck) {
		Arrays.sort(deck);
		List<Integer> list = new LinkedList<>();
		list.add(deck[deck.length - 1]); // corner case 1: one card; 
		for (int i = 1; i < deck.length; i++) {
			list = addSmallestAndPlugLast(list, deck[deck.length - 1 - i]);
		}
		for (int i = 0; i < deck.length; i++) {
			deck[i] = (int) list.get(i);
		}
		return deck;
	}

	/**
	 * @param list must be compliant to the program contract; ; pro
	 * @param nextCard <= min(list)
	 * @return list with new card, compliant to the program contract; 
	 */
	public List<Integer> addSmallestAndPlugLast(List<Integer> list, int nextCard) { 
		list.add(0, nextCard);
		int lastCard = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		list.add(1, lastCard); // action reverse to the targeted: you plug the last card into pos. 1 and add new card onto pos. 0; 
		return list;
	}
}
