package codility_puzzles;

public class ShiftTask {
	public static void main(String[] args) {
		ShiftTask demo = new ShiftTask();
		int firstIndex = 0;
		for (int i = 0; i < 32; i++) {
			System.out.println(String.valueOf(demo.getNthBit(12, i)));
		}
		for (int i = 0; i < 32; i++) {
			if (demo.getNthBit(14, i) == 1) {
				firstIndex = i;
				break;
			}
		}
		System.out.println(firstIndex);
	}

	private int getNthBit(int theNumber, int bitPosition) {
		int mask = 1;
		final int theNumberShifted = theNumber >> bitPosition;
		return theNumberShifted & mask;
	}
}