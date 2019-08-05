public class KnapsackNaiveBackSolver implements KnapsackSolver {

	private int[] values;
	private int[] weights;
	
	@Override
	public int solve(int[] values, int[] weights, int maxWeight) {
		this.values = values;
		this.weights = weights; 
		return solveRec(maxWeight, values.length);
	}
	
	/*
	 * O(2^n) time; stateless compared to NaiveNoArrays;
	 */
	private int solveRec(int weight, int n) {
		if(n == 0 | weight == 0) {
				return 0;
		}
		if(this.weights[n-1] > weight) {
			return solveRec(weight, n - 1);
		}
		return Math.max(
				this.values[n-1] + solveRec(weight - this.weights[n-1], n-1),
				solveRec(weight , n-1)
				);
	}	
	
	
}
