public class TaskThreeBiggerSmaller {
	private static final int[] A = { 3, 4, 5, 3, 7 };
	private static final int[] B = { 1, 3, 1, 2 };
	
	public static void main(String[] args) {
		System.out.println(solution(A));
		System.out.println(solution(B));
	}

	/**
	 *  Print number of ways to make array numbers strictly bigger/smaller/bigger/smaller than previous; 
	 */
	public static int solution(int[] A) { 
		boolean isDone = true; 
		int improves = 0; 
		for (int i = 0; i < A.length - 2; i++) {
			GardenComparator comparator = new GardenComparator(A[i], A[i+1], A[i+2]);
			if(!comparator.isPleasant()) {
				isDone = false; 
			}
		}
		for(int i = 0; i< A.length - 3; i++) {
			GardenComparator comparator = new GardenComparator(A[i], A[i+1], A[i+2]);
			if(!comparator.isPleasant()) {
				GardenComparator comparatorCutFirst = new GardenComparator(A[i+1], A[i+2], A[i+3]);
				if(comparatorCutFirst.isPleasant()) {
					improves++;
				}
				GardenComparator comparatorCutSecond = new GardenComparator(A[i], A[i+2], A[i+3]);
				if(comparatorCutSecond.isPleasant()) {
					improves++;
				}
				GardenComparator comparatorCutThird = new GardenComparator(A[i], A[i+1], A[i+3]);
				if(comparatorCutThird.isPleasant()) {
					improves++;
				}
			}
		}	
		if(isDone) return 0;
		if(improves > 0) return improves;
		return - 1; 
	}

	private static class GardenComparator{
		int first;
		int second;
		int third;
		public GardenComparator(int first, int second, int third) {
			this.first = first;
			this.second = second;
			this.third = third;
		}
		public boolean isPleasant() {
			if(this.first < this.second && this.second > this.third) return true; 
			if(this.first > this.second && this.second < this.third) return true; 
			return false;
		}

	}

}
