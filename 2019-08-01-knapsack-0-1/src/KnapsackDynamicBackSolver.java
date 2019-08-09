import java.util.Arrays;

public class KnapsackDynamicBackSolver implements KnapsackSolver {

	private int[] values;
	private int[] weights;
	private int[][] memo;

	@Override
	public int solve(int[] values, int[] weights, int maxWeight) {
		this.values = values;
		this.weights = weights;
		return solveDP(maxWeight, values.length);
	}

	// TODO: better illustrate how it works : checks if both current slot score and best score on remaining weight is bigger than best score on current weight
	private int solveDP(int weight, int n) {
		memo = new int[n + 1][weight + 1];
		for (int i = 0; i <= n; i++) {
			for (int testWeight = 0; testWeight <= weight; testWeight++) {
				if (i == 0 || testWeight == 0) {
					memo[i][testWeight] = 0;
				} else if (this.weights[i - 1] <= testWeight) {
					int remainingWeight = testWeight - weights[i - 1];
					int take = values[i - 1] + memo[i - 1][remainingWeight];
					int skip = memo[i - 1][testWeight];
					memo[i][testWeight] = Math.max(take, skip);
					System.out.print(take > skip ? remainingWeight + " take " + take + " ": testWeight + " skip " + skip + " ");
				} else {
					memo[i][testWeight] = memo[i - 1][testWeight];
					System.out.print(testWeight + " over " + memo[i][testWeight] + "  ");
				}
			}
			System.out.println();
		}
		return memo[n][weight];
	}

}