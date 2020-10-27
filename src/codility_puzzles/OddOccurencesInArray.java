package codility_puzzles;

import java.util.Arrays;

public class OddOccurencesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inp = { 9, 3, 9, 3, 9, 7, 9 };
		// System.out.println((double)(85-10)/30);
		System.out.println(Math.ceil((double) (85 - 10) / 30));
		OddOccurencesInArray demo = new OddOccurencesInArray();
		System.out.println(demo.solution(inp));
	}

	private int solution(int[] A) {
		Arrays.parallelSort(A);
		int i = 0;
		while (i < A.length - 1) {

			if (A[i] == A[i + 1]) {
				i += 2;
				continue;
			} else
				return A[i];
		}
		return 3;
	}

}
