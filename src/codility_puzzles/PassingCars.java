package codility_puzzles;

import java.util.ArrayList;
import java.util.List;

public class PassingCars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 0, 0, 1, 0, 1, 0, 1, 1, 0 };
		PassingCars demo = new PassingCars();
		demo.solution(A);
	}

	public int solution(int[] A) {
		List<Integer> zeroIndexes = new ArrayList<Integer>();

		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0)
				zeroIndexes.add(i);
		}
		int sum = 0;
		for (int j = zeroIndexes.size() - 1; j >= 0; j--) {
			int diff = A.length - zeroIndexes.get(j);
			sum = sum + diff;
			System.out.println(zeroIndexes.get(j));

		}
		return 0;

	}

}
