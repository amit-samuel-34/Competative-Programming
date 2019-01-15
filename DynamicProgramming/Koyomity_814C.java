//Problem Description URL: https://codeforces.com/problemset/problem/814/C

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Koyomity_814C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		String garland = sc.next();
		int tests = sc.nextInt();
		Map<Character, ArrayList<Integer>> chars = new HashMap<>();
		hash(garland, chars);
		int i = 0;
		while (i < tests) {
			int numFav = sc.nextInt();
			String fav = sc.next();
			int best = search(chars, numFav, fav.charAt(0), len);
			System.out.println(best);

			i++;
		}

	}

	private static int search(Map<Character, ArrayList<Integer>> chars,
			int numFav, char fav, int len) {

		if (!chars.containsKey(fav))
			return numFav;
		if (numFav >= len || numFav + chars.get(fav).size() >= len)
			return len;

		ArrayList<Integer> index = chars.get(fav);

		int res = 0;
		int next = 0;
		for (int i = 0; i < index.size(); i++) {
			while (next + 1 < index.size()
					&& index.get(next + 1) - (index.get(i) + 1) - (next - i) <= numFav) {
				next++;
			}
			res = Math.max(res, numFav + next - i + 1);
		}

		return res;
	}

	private static void hash(String garland,
			Map<Character, ArrayList<Integer>> chars) {
		for (int i = 0; i < garland.length(); i++) {
			char c = garland.charAt(i);
			if (!chars.containsKey(c)) {
				chars.put(c, new ArrayList<Integer>());
				chars.get(c).add(i);
			} else {
				chars.get(c).add(i);
			}
		}

	}

}
