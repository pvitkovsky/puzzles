public class TaskTwoTripleFizzBuzz {

	private final static String two = "Codility";
	private final static String three = "Test";
	private final static String five = "Coders";

	public static void main(String[] args) {
		solution(60);
	}

	private static class DivCode {
		int code = 0;

		public void setCode(int code) {
			if (this.code != 0)
				return;
			this.code = code;
			
		}

		public DivCode() {
		}


		public String createAnswer(int n) {
			switch (this.code) {
			
			case 235:
				return two + three + five;
			case 23:
				return two + three;
			case 25:
				return two + five;
			case 35:
				return three + five;
			case 2:
				return two;
			case 3:
				return three;
			case 5:
				return five;
			case 0:
				return "" + n;
			default:
				return "" + n;
			}
		}
	}

	public static void solution(int A) { // TODO: get rid of static;

		for (int n = 1; n <= A; n++) {
			boolean divTwo = n % 2 == 0;
			boolean divThree = n % 3 == 0;
			boolean divFive = n % 5 == 0;
			DivCode divCode = new DivCode();

			if (divTwo && divThree && divFive)
				divCode.setCode(235);
			if (divTwo && divThree)
				divCode.setCode(23);
			if (divTwo && divFive)
				divCode.setCode(25);
			if (divThree && divFive)
				divCode.setCode(35);
			if (divTwo)
				divCode.setCode(2);
			if (divThree)
				divCode.setCode(3);
			if (divFive)
				divCode.setCode(5);
			
			System.out.println(divCode.createAnswer(n));

		}
	}

}
