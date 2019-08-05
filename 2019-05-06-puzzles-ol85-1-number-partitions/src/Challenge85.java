import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Challenge85 {
	static int N;
	static int[] M;
	static int i;
	static int k;
	static int s;
	static int t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String line = br.readLine();
			if (line.equalsIgnoreCase("exit"))
				break;
			M = new int[100];
			N = Integer.valueOf(line);
			i = 0; // how many non-ones were filled in last pass;
			k = 0; // the first non-one from the right; 
			M[0] = N;
			recursivePrint();
		}
	}

	private static void recursivePrint() {
		System.out.println("Start i= " + i + " k= " + k); // + " t= " + t + " sum= " + sum + " s= " + s);
		t = M[k] - 1;  //what are we chipping now; 
		s = t + i - k + 1; //sum of the unit-of-work;
		System.out.println("Start t= " + t + " s= " + s);
		for (i = k; i < N; i++) {
			if (s > t) {
				M[i] = t;
				s -= t;
			} else {
				M[i] = s;
				break;
			}
			System.out.println("incrI: t= " + t + " s= " + s + " i= " + i);
		}
		for (k = 0; k <= i; k++) {
			System.out.print(M[k]);
		}
		System.out.println();
		System.out.println();

		for (k = i; k >= 0; --k) {
			if (M[k] > 1) {
				recursivePrint();
			}
		}
	}

}
