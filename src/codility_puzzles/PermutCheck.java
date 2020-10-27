package codility_puzzles;

import java.util.Arrays;

public class PermutCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutCheck demo = new PermutCheck();
		int[] A = { 4, 1, 3 };
		int n = (int) Math.floor(5 / 3);
		System.out.println(demo.solution(A));
	}

	private int solution(int[] A) {
		Arrays.parallelSort(A);
		for (int i = 0; i < A.length; i++) {
			if (A[i] == i + 1)
				continue;
			else
				return 0;
		}
		return 1;
	}
}
