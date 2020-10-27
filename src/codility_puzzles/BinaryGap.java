package codility_puzzles;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class BinaryGap {
	@Test
	public void testSolution() {
		assertEquals(3, new BinaryGap().solution(561892));
	}

	public int solution(int n) {

		int firstIndex = 0;

		for (int i = 0; i < 32; i++) {
			if (getNthBit(n, i) == 1) {
				firstIndex = i;
				break;
			}
		}

		int currentGap = 0;
		int biggestGap = 0;

		for (int i = firstIndex; i < 32; i++) {
			if (getNthBit(n, i) == 0) {
				currentGap++;
			} else {
				if (currentGap > biggestGap) {
					biggestGap = currentGap;
				}

				currentGap = 0;
			}
		}

		return biggestGap;
	}

	private int getNthBit(int theNumber, int bitPosition) {
		int mask = 1;
		final int theNumberShifted = theNumber >> bitPosition;
		return theNumberShifted & mask;
	}
}
