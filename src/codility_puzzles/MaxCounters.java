package codility_puzzles;

import java.util.Arrays;

public class MaxCounters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 3, 4, 4, 6, 1, 4, 4 };
		int N = 5;
		MaxCounters demo = new MaxCounters();
		System.out.println(Arrays.toString(demo.solution(N, A)));
	}

	private int[] solution(int N, int[] A) {
		int[] counter = new int[N];
		Arrays.fill(counter, 0);
		int maxCount = 0;
		int currentCount = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0 && A[i] <= N + 1) {
				if (A[i] < N + 1) {
					counter[A[i] - 1]++;
					currentCount = counter[A[i] - 1];
					if (currentCount > maxCount) {
						maxCount = currentCount;
					}
				} else if (A[i] == N + 1)
					Arrays.fill(counter, maxCount);
			}

		}
		return counter;
	}
}
