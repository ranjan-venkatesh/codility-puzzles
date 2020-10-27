package codility_puzzles;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SmallestPositive {

	public int solution(int[] A) {
		// write your code in Java SE 8
		Arrays.parallelSort(A);
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < A.length - 1; i++) {
			set.add(A[i]);
		}

		for (int i = 1; i < A[A.length - 1]; i++) {
			if (set.contains(i)) {
				continue;
			} else {
				return i;
			}
		}
		if (A[A.length - 1] > 0)
			return A[A.length - 1] + 1;
		else
			return 1;
	}

	public static void main(String[] args) {
		SmallestPositive demo = new SmallestPositive();
		int[] A = { 1, 3, 6, 4, 1, 2 };
		System.out.println(demo.solution(A));
	}

	/*
	 * @Test public void testSolution() { int[] test = new int[]{1, 2, 3, 4,5};
	 * assertEquals(6, new SmallestPositive().solution(test)); }
	 */
}
