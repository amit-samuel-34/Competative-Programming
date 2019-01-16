//Problem Description URL: http://codeforces.com/problemset/problem/1102/D

import java.util.Scanner;

public class BalancedTernaryString {

	public static char a = '0';
	public static char b = '1';
	public static char c = '2';

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		String ter = sc.next();
		int corrCnt = len / 3;
		int[] charCounts = new int[3];
		if (!getCounts(charCounts, ter, corrCnt))
			System.out.println(ter);
		else {
			String balanced = balance(charCounts, corrCnt, ter, len);
			System.out.println(balanced);
		}
	}

	private static String balance(int[] charCounts, int corrCnt, String ter,
			int len) {

		int[] update = new int[3];
		StringBuilder sb = new StringBuilder(ter);

		int ind = 0;
		for (int i = 0; i < len; i++) {
			if (sb.charAt(i) == a)
				ind = 0;
			else if (sb.charAt(i) == b)
				ind = 1;
			else
				ind = 2;

			if (charCounts[ind] > corrCnt) {
				int numToSwitch = numSwitch(charCounts, corrCnt, update, ind);
				if (numToSwitch == -1) {
					update[ind]++;
					continue;
				}
				String val = String.valueOf(numToSwitch);
				char v = val.charAt(0);
				sb.setCharAt(i, v);
				charCounts[ind]--;
				charCounts[numToSwitch]++;
				update[numToSwitch]++;

			}

		}

		return sb.toString();
	}

	private static int numSwitch(int[] charCounts, int corrCnt, int[] update,
			int ind) {
		if (ind == 0 && update[ind] == corrCnt) {
			if (charCounts[1] < corrCnt)
				return 1;
			if (charCounts[2] < corrCnt)
				return 2;

		}
		if (ind == 1) {
			if (charCounts[0] < corrCnt)
				return 0;
			if (charCounts[2] < corrCnt && update[ind] == corrCnt)
				return 2;

		}
		if (ind == 2) {
			if (charCounts[0] < corrCnt)
				return 0;
			if (charCounts[1] < corrCnt)
				return 1;

		}
		return -1;
	}

	private static boolean getCounts(int[] charCounts, String ter, int corr) {
		boolean needToDo = false;
		for (int i = 0; i < ter.length(); i++) {
			int index = Integer.parseInt(ter.substring(i, i + 1));
			charCounts[index]++;
			if (charCounts[index] > corr)
				needToDo = true;
		}
		return needToDo;

	}

}
