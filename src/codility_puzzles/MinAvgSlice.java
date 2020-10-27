package codility_puzzles;

import java.util.Arrays;

public class MinAvgSlice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 4, 2, 2, 5, 1, 5, 8 };
		MinAvgSlice demo = new MinAvgSlice();
		System.out.println(demo.solution2(A));
	}

	public int solution(int[] A) {
		// write your code in Java SE 8
		double minAvg = 0;
		int leftIndex = 0;

		for (int i = 0; i < A.length; i++) {

			for (int j = i + 1; j < A.length; j++) {
				if ((i == 0 && j == 1) || minAvg > findAverageUsingStream(Arrays.copyOfRange(A, i, j + 1))) {
					minAvg = findAverageUsingStream(Arrays.copyOfRange(A, i, j + 1));
					leftIndex = i;
				}

			}

		}
		return leftIndex;
	}

	public int solution2(int[] A) {
		double avg2;
		double avg3;
		double minAvg = Integer.MAX_VALUE;
		int minStartPos = 0;

		for (int i = 0; i < A.length - 2; i++) {
			avg2 = (double) (A[i] + A[i + 1]) / 2;
			avg3 = (double) (A[i] + A[i + 1] + A[i + 2] / 3);
			System.out.println(avg2);
			System.out.println(avg3);
			double curMinAvg = Math.min(avg2, avg3);
			if (curMinAvg < minAvg) {
				minAvg = curMinAvg;
				minStartPos = i;
			}

		}

		avg2 = (A[A.length - 2] + A[A.length - 1]) / 2;
		if (avg2 < minAvg) {
			minAvg = avg2;
			minStartPos = A.length - 2;
		}

		return minStartPos;
	}

	public double findAverageUsingStream(int[] array) {
		return Arrays.stream(array).average().orElse(Double.NaN);
	}

}
