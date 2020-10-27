package codility_puzzles;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class BasicPractice {

	public static void main(String[] args) {
		BasicPractice demo = new BasicPractice();

		// Check if wrapper class Integer compares to primitive data type int
		// After JDK>5, Java introduced auto-boxing/auto-unboxing feature. Therefore it
		// gets compared easily.
		Integer a = new Integer(5);
		int b = 5;
		System.out.println(b == a);

		// StringBuilder functions
		// CharSequence is the interface, whereas string, stringbuilder and stringbuffer
		// are implementations.
		StringBuilder example = new StringBuilder("Hello World");
		CharSequence newstr = example.subSequence(0, 5);
		String newstr2 = example.substring(0, 5);
		// example.setCharAt(0, 'y');
		// example.reverse();
		example.insert(7, newstr);
		// example.replace(0, 5, "hi");
		System.out.println(example);

		// Practice for collections
		Queue exQueue = new PriorityQueue<Integer>();
		List exStack = new Stack<Integer>();
		exQueue.add(1);
		exQueue.add(2);
		exQueue.add(8);
		exQueue.add(3);
		exQueue.add(7);
		exQueue.add(4);
		exQueue.add(9);
		exQueue.add(5);
		System.out.println(exQueue);
		exQueue.remove(2);
		System.out.println(exQueue);
		exStack.add(1);
		exStack.add(2);
		exStack.add(8);
		exStack.add(3);
		exStack.add(7);
		exStack.add(4);
		exStack.add(9);
		exStack.add(5);
		System.out.println(exStack);
		exStack.remove(2);
		System.out.println(exStack);
		String[] A = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		System.out.println(Integer.MAX_VALUE);
		System.out.println(demo.getParsedEvenNumStrings(A));
	}

	public List<Integer> getParsedEvenNumStrings(String[] A) {
		Arrays.stream(A).map(i -> Integer.valueOf(i)).filter(i -> i % 2 == 0).forEach(System.out::println);
		return Arrays.asList(A).parallelStream().map(i -> Integer.valueOf(i)).filter(i -> i % 2 == 0)
				.collect(Collectors.toList());
	}

}
