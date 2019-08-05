import java.util.Arrays;

public class Knapsack {

	private static final int[] weights = { 23, 31, 29, 44, 53, 38, 63, 85, 89, 82 };
	private static final int[] values = { 92, 57, 49, 68, 60, 43, 67, 84, 87, 72 };
	private static final int maxWeight = 165;
	// 309

	private static final int[] weightsBig = { 382745, 799601, 909247, 729069, 467902, 44328, 34610, 698150, 823460,
			903959, 853665, 551830, 610856, 670702, 488960, 951111, 323046, 446298, 931161, 31385, 496951, 264724,
			224916, 169684 };

	private static final int[] valuesBig = { 825594, 1677009, 1676628, 1523970, 943972, 97426, 69666, 1296457, 1679693,
			1902996, 1844992, 1049289, 1252836, 1319836, 953277, 2067538, 675367, 853655, 1826027, 65731, 901489,
			577243, 466257, 369261 };
	private static final int maxWeightBig = 6404180;
	//13549094
	
	public static void main(String[] args) {
		int solution = 0;
		System.out.println("Loading weights: " + Arrays.toString(weightsBig));
		System.out.println("Loading values: " + Arrays.toString(valuesBig));

		KnapsackSolver ksna = new KnapsackDynamicBackSolver();
		solution = ksna.solve(valuesBig, weightsBig, maxWeightBig);
		System.out.println(solution);
		

		KnapsackSolver ksnb = new KnapsackNaiveBackSolver();
		solution = ksnb.solve(valuesBig, weightsBig, maxWeightBig);
		System.out.println(solution);


	}
}
