package cards;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class Solution { //https://leetcode.com/problems/reveal-cards-in-increasing-order/
	Deque<Integer> deque = new ArrayDeque<>();


	public static void main(String[] args) {
		int[] arr = { 17, 13, 11, 2, 3, 5, 7 };
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.deckRevealedIncreasing(arr)));

	}
	
	public int[] deckRevealedIncreasing(int[] deck) {
		Solution solution = new Solution();
		solution.fill(deck);
		Integer[] boxed = solution.deque.toArray(new Integer[solution.deque.size()]);
		return Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
	}

	public void fill(int[] deck) {
		int product = 1;
		int remainder = 0;
		while (product < deck.length) {
			product = product << 1;
		}
		remainder = deck.length - product;
		int[] twoPowerDeck = Arrays.copyOf(deck, product);
		for (int i = deck.length; i < twoPowerDeck.length; i++) {
			twoPowerDeck[i] = Integer.MIN_VALUE;
		}
		Arrays.sort(twoPowerDeck);

		this.fillWithPowerOfTwo(twoPowerDeck);
		while (remainder < 0) {
			this.revealTwoReturnFirst();
			remainder++;
		}
	}

	private void fillWithPowerOfTwo(int[] twoPowerDeck) { // at least 2; power of 2; sorted;
		if (twoPowerDeck.length < 3) {
			deque = Arrays.stream(twoPowerDeck).boxed().collect(Collectors.toCollection(ArrayDeque::new));
			return;
		}
		int[] cards = new int[twoPowerDeck.length];
		cards[cards.length - 1] = twoPowerDeck[twoPowerDeck.length - 1];
		cards[cards.length / 2 - 1] = twoPowerDeck[twoPowerDeck.length - 2];
	
		int cardsCountMutable = cards.length - 2;
		for (int x = 4; x < cards.length; x = x * 2) {
			for (int i = x - 1; i > 0; i = i - 2) {
				cards[i * (cards.length / x) - 1] = twoPowerDeck[cardsCountMutable - 1];
				cardsCountMutable--;
			}
		}
		for (int j = cards.length - 2; j >= 0; j = j - 2) {
			cards[j] = twoPowerDeck[cardsCountMutable - 1];
			cardsCountMutable--;
		}
		deque = Arrays.stream(cards).boxed().collect(Collectors.toCollection(ArrayDeque::new));
	}

	private Integer revealTwoReturnFirst() {
		Integer minCard = deque.pop();
		Integer maxCard = deque.pop();
		deque.addLast(maxCard);
		return minCard;
	}
}
