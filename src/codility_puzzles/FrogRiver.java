package codility_puzzles;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrogRiver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 3, 1, 3, 2, 1, 3 };
		FrogRiver demo = new FrogRiver();
		System.out.println(demo.solution2(3, A));
	}

	private int solution2(int X, int[] A) {
		int steps = X;
		boolean[] bitmap = new boolean[steps + 1];
		for (int i = 0; i < A.length; i++) {
			if (!bitmap[A[i]]) {
				bitmap[A[i]] = true;
				steps--;
				if (steps == 0)
					return i;
			}
		}
		return -1;
	}

	private int solution(int X, int[] A) {
		List<Integer> aList = Arrays.stream(A).boxed().collect(Collectors.toList());
		int locateElement = aList.indexOf(Integer.valueOf(X));
		System.out.println(locateElement);
		if (locateElement != -1) {
			int[] sortedA = A;
			sortedA = Arrays.copyOfRange(sortedA, 0, locateElement + 1);
			Arrays.parallelSort(sortedA);
			System.out.println(Arrays.toString(sortedA));
			int j = 1;

			int lastElement;

			if (sortedA[0] == j) {
				lastElement = sortedA[0];
				j++;
			} else
				return -1;

			for (int i = 1; i < sortedA.length; i++) {
				if (sortedA[i] == lastElement)
					continue;
				else {
					if (sortedA[i] == j) {
						lastElement = sortedA[i];
						j++;
					} else
						return -1;
				}
			}
			return locateElement;
		} else
			return -1;

	}
}
