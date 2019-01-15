import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TwoButton {

	public static boolean[] vis = new boolean[10000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();

		int count = findLeast(start, end);
		System.out.println(count);
		sc.close();

	}

	private static int findLeast(int start, int end) {

		Queue<Tuple> tup = new LinkedList<Tuple>();
		Tuple startTuple = new Tuple(start, 0);
		tup.offer(startTuple);

		while (!(tup.isEmpty())) {
			Tuple temp = tup.peek();
			int number = temp.n;
			int count = temp.c;
			tup.poll();
			vis[number] = true;
			
			
			if (number == end)
				return count;
			else {
				if (number - 1 == end)
					return count + 1;
				else if (number - 1 > 0 && vis[number - 1] == false) {
					tup.offer(new Tuple(number - 1, count + 1));
				}

				if (number * 2 == end)
					return count + 1;
				else if (number * 2 < end + 1000 && vis[number * 2] == false) {
					tup.offer(new Tuple(number * 2, count + 1));
				}
			}

		}

		return 0;
	}

	public static class Tuple {

		int n;
		int c;

		public Tuple(int x, int y) {

			this.n = x;
			this.c = y;
		}
	}

}
