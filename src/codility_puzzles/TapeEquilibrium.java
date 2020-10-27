package codility_puzzles;

public class TapeEquilibrium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TapeEquilibrium demo = new TapeEquilibrium();
		int[] A = { 3, 1, 2, 4, 3 };
		System.out.println(demo.solution2(A));
	}

	private int solution(int[] A) {
		int absDiff = 0;
		int minAbsDiff = 0;

		for (int j = 1; j < A.length; j++) {
			absDiff = Math.abs(arraySum(A, 0, j) - arraySum(A, j, A.length));

			if (absDiff < minAbsDiff || j == 1) {
				minAbsDiff = absDiff;
			}
		}
		return minAbsDiff;
	}

	private int solution2(int[] A) {
		int[] sumArray = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			if (i > 0) {
				sumArray[i] = sumArray[i - 1] + A[i];
			} else
				sumArray[i] = A[i];
			System.out.println(sumArray[i]);

		}

		int absDiff = 0;
		int minAbsDiff = 0;
		for (int j = 0; j < sumArray.length - 1; j++) {
			absDiff = Math.abs(sumArray[j] - (sumArray[sumArray.length - 1] - sumArray[j]));
			if (j == 0 || absDiff < minAbsDiff) {
				minAbsDiff = absDiff;
			}
			System.out.println(absDiff);
		}

		return minAbsDiff;
	}

	private int arraySum(int[] A, int start, int end) {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum = sum + A[i];
		}
		return sum;
	}
}
