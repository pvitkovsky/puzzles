package ol88t1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class TopNumberZeroFiller { // TODO: test, explain, refactor;
	static int arr[] = { 2, 9, 8, 5, 9, 7, 6, 5, 4, 3, 3, 2, 4, 5, 6, 2 };
	private Set<Integer> declensions = new TreeSet<Integer>();

	public static void main(String[] args) {
		TopNumberZeroFiller filler = new TopNumberZeroFiller();
		int[][] maximums = filler.getLocalMaximums(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(maximums[0]));
		System.out.println(Arrays.toString(maximums[1]));
		System.out.println(filler.declensions.toString());
		arr = filler.flipSpread(arr, maximums);
		System.out.println(Arrays.toString(arr));
	}

	int[][] getLocalMaximums(int[] arr) {
		int[][] res = new int[3][arr.length];
		int max = arr[arr.length - 1];
		int curr = max;
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] >= max) {
				res[0][i] = 1;
				max = arr[i];
			}
			if (arr[i - 1] < arr[i]) {
				res[1][i - 1] = arr[i];
				curr = arr[i];
				declensions.add(curr);
			}
			if (arr[i - 1] == arr[i]) {
				res[1][i - 1] = curr;
			}
			if (arr[i - 1] > arr[i]) {
				for (Integer dec : declensions) {
					if (dec > arr[i - 1]) {
						curr = dec;
					}
					break;
				}
				res[1][i - 1] = curr;

			}
		}
		return res;
	}

	int[] flipSpread(int[] arr, int[][] maximums) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < maximums[1][i]) {
				arr[i] = maximums[1][i];
			}
			if (maximums[0][i] == 1) {
				arr[i] = 0;
			}
		}
		return arr;
	}

	boolean isMax(int[] arr, int index) {
		return Arrays.stream(arr).skip(index).filter(e -> e > arr[index]).count() > 0;
	}

}
