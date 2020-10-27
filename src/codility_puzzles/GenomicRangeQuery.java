package codility_puzzles;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GenomicRangeQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "CAGCCTA";
		int[] P = { 2, 5, 0 };
		int[] Q = { 4, 5, 6 };
		GenomicRangeQuery demo = new GenomicRangeQuery();
		System.out.println(Arrays.toString(demo.solution(S, P, Q)));
	}

	private int[] solution(String S, int[] P, int[] Q) {
		List<Character> nuclTypes = Arrays.asList(new Character[] { 'A', 'C', 'G', 'T' });
		int[] res = new int[P.length];
		Character[] sChar = S.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
		Character[] pqChar;
		Set<Character> nuclTypesSet = new HashSet<Character>(nuclTypes);
		List<String> resList = new LinkedList<String>();
		// Set<Character> pqCharSet;
		// Set<char[]> pqCharSets = new HashSet<char[]>();

		// System.out.println(Arrays.toString(sChar));
		for (int i = 0; i < P.length; i++) {
			pqChar = Arrays.copyOfRange(sChar, P[i], Q[i] + 1);
			// pqChar = IntStream.range(P[i], Q[i]+1).mapToObj(k ->
			// (char)k).toArray(Character[]::new);

			Set<Character> pqCharSet = new HashSet<Character>(Arrays.asList(pqChar));
			// pqCharSet.addAll(pqChar);
			/*
			 * for (int j = 0; j < pqChar.length; j++) { pqCharSet.add(new
			 * Character(pqChar[j])); }
			 */

			pqCharSet.retainAll(nuclTypesSet);
			// pqCharSets.add(pqCharSet.toArray());
			resList.add(Arrays.stream(pqCharSet.toArray()).map(String::valueOf).collect(Collectors.joining()));
			// System.out.println(Arrays.stream(pqCharSet.toArray()).map(String::valueOf).collect(Collectors.joining()));
			// System.out.println(pqCharSet.toArray().getClass().getComponentType());
			// System.out.println(Arrays.toString(pqCharSet.toArray()));
		}
		// System.out.println(resList.get(0));
		// char resItem;
		int itemLen;
		int i = 0;

		for (String item : resList) {
			itemLen = item.length();
			int minCount = 0;
			switch (itemLen) {
			case 1:
				minCount = nuclTypes.indexOf(new Character(item.charAt(0))) + 1;
				break;
			case 2:
				minCount = nuclTypes.indexOf(new Character(item.charAt(0))) + 1;
				if (minCount > nuclTypes.indexOf(new Character(item.charAt(1))) + 1)
					minCount = nuclTypes.indexOf(new Character(item.charAt(1))) + 1;
				break;
			case 3:
				minCount = nuclTypes.indexOf(new Character(item.charAt(0))) + 1;
				if (minCount > nuclTypes.indexOf(new Character(item.charAt(1))) + 1)
					minCount = nuclTypes.indexOf(new Character(item.charAt(1))) + 1;
				if (minCount > nuclTypes.indexOf(new Character(item.charAt(2))) + 1)
					minCount = nuclTypes.indexOf(new Character(item.charAt(2))) + 1;
				break;
			case 4:
				minCount = nuclTypes.indexOf(new Character(item.charAt(0))) + 1;
				if (minCount > nuclTypes.indexOf(new Character(item.charAt(1))) + 1)
					minCount = nuclTypes.indexOf(new Character(item.charAt(1))) + 1;
				if (minCount > nuclTypes.indexOf(new Character(item.charAt(2))) + 1)
					minCount = nuclTypes.indexOf(new Character(item.charAt(2))) + 1;
				if (minCount > nuclTypes.indexOf(new Character(item.charAt(3))) + 1)
					minCount = nuclTypes.indexOf(new Character(item.charAt(3))) + 1;
				break;
			}
			res[i] = minCount;
			i++;
			// System.out.println(minCount);
		}
		// Integer[] result = s1.toArray(new Integer[s1.size()]);

		return res;
	}
}
