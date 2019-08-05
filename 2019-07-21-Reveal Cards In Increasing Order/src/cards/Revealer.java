package cards;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class Revealer { // TODO: now with custom array please;

	Deque<Integer> deque = new ArrayDeque<>(); // polyespression

	public static void main(String[] args) {
		int[] arr = { 17, 13, 11, 2, 3, 5, 7 };
		Revealer revealer = new Revealer();
//		revealer.fill(0);
//		revealer.fill(1);
//		revealer.fill(2);
//		revealer.fill(31);
//		revealer.test();
//		revealer.fill(5);
//		revealer.test();
//		revealer.fill(17);
//		revealer.test();
//		revealer.fill(999);
//		revealer.test();
//		revealer.fill(100);
//		revealer.test();

		revealer.fill(arr);

		Integer[] boxed = revealer.deque.toArray(new Integer[revealer.deque.size()]);
		arr = Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(arr));
		revealer.test();

	}

	public void test() {
		Integer biggestCard = deque.stream().max((a, b) -> a - b).get();
		while (deque.size() > 1) {
			revealTwoReturnFirst();
		}

		System.out.println("Biggest card " + biggestCard + " Is the only remaining: " + deque.contains(biggestCard));
	}

	public Integer revealTwoReturnFirst() {
		Integer minCard = deque.pop();
		Integer maxCard = deque.pop();
		deque.addLast(maxCard);
		return minCard;
	}

	public void fill(int cardsCount) {
		int product = 1;
		int remainder = 0;
		while (product < cardsCount) {
			product = product << 1;
		}
		remainder = cardsCount - product;
		this.fillWithPowerOfTwo(product); // System.out.println("Target cards " + cardsCount + " twos product " +
											// product + " remainder " + remainder);
		while (remainder < 0) {
			this.revealTwoReturnFirst();
			remainder++;
		}
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

		this.fillWithPowerOfTwo(twoPowerDeck); // System.out.println("Target cards " + cardsCount + " twos product " +
												// product + " remainder " + remainder);
		while (remainder < 0) {
			this.revealTwoReturnFirst();
			remainder++;
		}
	}

	private void fillWithPowerOfTwo(int cardsCount) { // at least 2; power of 2;
		int[] cards = new int[cardsCount];
		cards[cardsCount - 1] = cardsCount;
		cards[cardsCount / 2 - 1] = cardsCount - 1;
		int cardsCountMutable = cardsCount - 2;
		for (int x = 4; x < cardsCount; x = x * 2) {
			for (int i = x - 1; i > 0; i = i - 2) {
				cards[i * (cardsCount / x) - 1] = --cardsCountMutable; // System.out.println(" I " + i + " x = " + x + "
																		// CardsMutable " + cardsCountMutable);
			}
		}
		for (int j = cardsCount - 2; j >= 0; j = j - 2) {
			cards[j] = --cardsCountMutable;
		}
		deque = Arrays.stream(cards).boxed().collect(Collectors.toCollection(ArrayDeque::new));
	}

	private void fillWithPowerOfTwo(int[] twoPowerDeck) { // at least 2; power of 2; sorted
		
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
				cards[i * (cards.length / x) - 1] = twoPowerDeck[cardsCountMutable - 1]; // System.out.println(" I " + i
																							// + " x = " + x + "
																							// CardsMutable " +
																							// cardsCountMutable);
				cardsCountMutable--;
			}
		}
		for (int j = cards.length - 2; j >= 0; j = j - 2) {
			cards[j] = twoPowerDeck[cardsCountMutable - 1];
			cardsCountMutable--;
		}
		deque = Arrays.stream(cards).boxed().collect(Collectors.toCollection(ArrayDeque::new));
	}

}
