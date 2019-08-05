package cards;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class IndexInformsTheCards {

	public static void main(String[] args) {
		int[] arr = { 17, 13, 11, 2, 7 };
		IndexInformsTheCards solution = new IndexInformsTheCards();
		System.out.println(Arrays.toString(solution.deckRevealedIncreasing(arr)));

	}

	/**
	 * This works by mapping the indices from draw-put-in-the end process to the original cards. 
	 * @param deck
	 * @return
	 */
	public int[] deckRevealedIncreasing(int[] deck) {
		int length = deck.length;
		
		Arrays.sort(deck);
		System.out.println(Arrays.toString(deck));
		Deque<Integer> index = new LinkedList<>();
		
		for (int i : deck) {
			index.offer(i);
		}
		System.out.println(index);
		int[] ans = new int[length];
		for(int i = 0; i < length; i++) {
			ans[i] = revealTwoReturnFirst(index);
		}
		return ans;

	}
	
	private Integer revealTwoReturnFirst(Deque<Integer> deque) {
		if(deque.size() == 1) return deque.pop();
		Integer minCard = deque.pop();
		Integer maxCard = deque.pop();
		deque.addLast(maxCard);
		System.out.println(deque);
		return minCard;
	}
	
	/**
	 * This works by mapping the indices from draw-put-in-the end process to the original cards. 
	 * @param deck
	 * @return
	 */
//	public int[] deckRevealedIncreasing(int[] deck) {
//		int length = deck.length;
//		Deque<Integer> index = new LinkedList<>();
//
//		for (int i = 0; i < length; i++) {
//			index.offer(i);
//		}
//
//		int[] ans = new int[length];
//		Arrays.sort(deck);
//
//		for (int i : deck) {
//			//System.out.println(index.toString());
//			ans[index.pollFirst()] = i;
//			if (!index.isEmpty()) {
//				index.add(index.pollFirst());
//			}
//		}
//
//		return ans;
//
//	}

}
