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
//import java.io.OutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.io.PrintStream;
//import java.util.HashMap;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//import java.util.Map;
//import java.io.BufferedReader;
//import java.io.InputStream;
//
//public class Koyomity_814C {
//    public static void main(String[] args) {
//        InputStream inputStream = System.in;
//        OutputStream outputStream = System.out;
//        InputReader in = new InputReader(inputStream);
//        PrintWriter out = new PrintWriter(outputStream);
//        TaskC solver = new TaskC();
//        solver.solve(1, in, out);
//        out.close();
//    }
//
//    static class TaskC {
//        int n;
//        Map<Character, List<Integer>> cols;
//
//        public void solve(int testNumber, InputReader in, PrintWriter out) {
//            n = in.nextInt();
//            String s = in.next();
//            cols = new HashMap<>();
//            for (int i = 0; i < n; i++) {
//                char c = s.charAt(i);
//                if (cols.containsKey(c)) {
//                    cols.get(c).add(i);
//                } else {
//                    ArrayList<Integer> clist = new ArrayList<>();
//                    clist.add(i);
//                    cols.put(c, clist);
//                }
//            }
//
//            int q = in.nextInt();
//            for (int i = 0; i < q; i++) {
//                int m = in.nextInt();
//                String c = in.next();
//                out.println(query(m, c.charAt(0)));
//            }
//        }
//
//        int query(int m, char c) {
//            if (m >= n) return n;
//            if (!cols.containsKey(c)) return m;
//            if (m + cols.get(c).size() >= n) return n;
//
//            List<Integer> pos = cols.get(c);
//            int last = 0;
//            int result = 0;
//            for (int first = 0; first <= pos.size(); first++) {
//                while ((last < pos.size() - 1) && (pos.get(last + 1) - pos.get(first) + 1 - (last - first + 2) <= m)) {
//                    last++;
//                }
//                result = Math.max(result, m + last - first + 1);
//            }
//            return result;
//        }
//
//    }
//
//    static class InputReader {
//        private static BufferedReader in;
//        private static StringTokenizer tok;
//
//        public InputReader(InputStream in) {
//            this.in = new BufferedReader(new InputStreamReader(in));
//        }
//
//        public int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        public String next() {
//            try {
//                while (tok == null || !tok.hasMoreTokens()) {
//                    tok = new StringTokenizer(in.readLine());
//                    //tok = new StringTokenizer(in.readLine(), ", \t\n\r\f"); //adds commas as delimeter
//                }
//            } catch (IOException ex) {
//                System.err.println("An IOException was caught :" + ex.getMessage());
//            }
//            return tok.nextToken();
//        }
//
//    }
//}