import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Partition {

	public static void partition(int n) {
		partition(n, n, "");
	}

	public static void partition(int n, int max, String prefix) {
		
		if (n == 0) {
			System.out.println(prefix);
			return;
		}

		for (int i = Math.min(max, n); i >= 1; i--) {
			partition(n - i, i, prefix + " " + i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String line = br.readLine();
			if (line.equalsIgnoreCase("exit"))
				break;
			int N = Integer.valueOf(line);
			partition(N);
		}
	}

}

// 	
