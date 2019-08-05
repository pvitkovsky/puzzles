import java.util.Arrays;

public class Urlifier {
	private static String testString = "Mr John Smith    ";
	private static int testStringLength = 13; 
	public static void main(String[] args) {
		Urlifier urlifier = new Urlifier();
		System.out.println(urlifier.urlify(testString, testStringLength));
	}
	
	private String urlify(String str, int trueLen) {
		return Arrays.toString(indexes(str.toCharArray(), trueLen));
	}
	
	private char[] indexes(char[] str, int trueLen) {
		char[] res = new char[str.length];
		int offset = 0; 
		for(int n = 0; n < trueLen; n ++) {
			if(str[n] == ' ') { 
				offset += 2; // lengths of '%20' and ' ' differ by 2; 
				res[n + offset - 2] = '%';
				res[n + offset - 1] = '2';
				res[n + offset] = '0';
			}  else {
				res[n + offset] = str[n];
			}
		}
		return res; 
	}
	
	
}
