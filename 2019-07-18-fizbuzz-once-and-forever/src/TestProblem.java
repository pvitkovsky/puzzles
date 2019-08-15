import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class TestProblem {

	private static final int[] A =  {1, 2, 3};
	private static final int[] B =  {-1, -3};
	
	public static void main(String[] args) {
		System.out.println(solution(A));
		System.out.println(solution(B));
	}

	public static int solution(int[] A) {
		
		Set<Integer> set = Arrays.stream(A).filter(el -> el > 0).boxed().collect(Collectors.toSet());
		
		for(Integer i = 1; i < Integer.MAX_VALUE; i++) {
			if(!set.contains(i)) return (int) i;
		}
		return 1000001;
		
	}
}

/*
//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");\
*/