import java.util.Arrays;

public class TaskOneMinThreeDigit {

	private static final int[] A = { -6, -91, 1011, -100, 84, -22, 0, 1, 473 };

	public static void main(String[] args) {
		System.out.println(solution(A));
	}

	public static int solution(int[] A) { //TODO: get rid of static; 
		
		return Arrays.stream(A).filter(el-> isThreeDigit(el)).min().getAsInt();

	}

	private static Boolean isThreeDigit(int el) {
		int abs = Math.abs(el);
		return  abs >= 100 && abs <= 999;
	}


}
