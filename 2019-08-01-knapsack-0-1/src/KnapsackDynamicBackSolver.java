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

	//TODO: draw a diagram please
	private int solveDP(int weight, int n) {
		memo = new int[n + 1][weight + 1];
		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= weight; w++) {
				if (i == 0 || w == 0) {
					memo[i][w] = 0;
				} else if (this.weights[i - 1] <= w) {
					int take = values[i - 1] + memo[i - 1][w - weights[i - 1]];
					int skip = memo[i - 1][w];
					memo[i][w] = Math.max(take, skip);
				} else {
					memo[i][w] = memo[i - 1][w];
				}

			}
		}
		return memo[n][weight];
	}
}