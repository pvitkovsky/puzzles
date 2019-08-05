public class KnapsackNaiveNoArrays implements KnapsackSolver {

	private int[] values;
	private int[] weights;
	private int maxWeight; 
	
	@Override
	public int solve(int[] values, int[] weights, int maxWeight) {
		this.values = values;
		this.weights = weights; 
		this.maxWeight = maxWeight;
		return Math.max(solveRec(0, 1, 0, 0), solveRec(0, 0, 0, 0));
	}
	
	/*
	 * O(2^n) time; has a state; 
	 */
	private int solveRec(int item, int take, int sum, int weight) {
		sum += take*values[item];
		weight += take*weights[item];
		if(weight > this.maxWeight) {
			return -1;
		}
		if(item == values.length - 1) {
			return sum;  ////System.out.println("Item "+item+ " Take? "+take+Arrays.toString(moves) + " Res "  + res + " Weight " + weight);			
		} else {
			return Math.max(solveRec(item + 1, 1, sum, weight), solveRec(item + 1, 0, sum, weight) );
		}
	}	
	
	
}
