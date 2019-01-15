//Problem Description URL: http://codeforces.com/problemset/problem/475/B

import java.util.Arrays;
import java.util.Scanner;

public class StronglyConnectedGraph {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		String rowDir = sc.next();
		String colDir = sc.next();
		boolean[][] visited = new boolean[rows][cols];

		String ans = "";
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				dfs(row, col, rowDir, colDir, visited);
				boolean check = checker(rows, cols, visited);
				if (!check) {
					ans = "NO";
					break;
				}
			}
			if (ans.equals("NO"))
				break;
			visited = new boolean[rows][cols];
		}
		if (!ans.equals("NO"))
			System.out.println("YES");

		System.out.println(ans);

		sc.close();
	}

	private static boolean checker(int rows, int cols, boolean[][] visited) {
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (!visited[row][col])
					return false;
			}
		}
		return true;
	}

	private static void dfs(int row, int col, String rowDir, String colDir,
			boolean[][] visited) {
		visited[row][col] = true;

		if (rowDir.charAt(row) == '>' && col < colDir.length() - 1
				&& !visited[row][col + 1])
			dfs(row, col + 1, rowDir, colDir, visited);
		if (rowDir.charAt(row) == '<' && col > 0 && !visited[row][col - 1])
			dfs(row, col - 1, rowDir, colDir, visited);
		if (colDir.charAt(col) == '^' && row > 0 && !visited[row - 1][col])
			dfs(row - 1, col, rowDir, colDir, visited);
		if (colDir.charAt(col) == 'v' && row < rowDir.length() - 1
				&& !visited[row + 1][col])
			dfs(row + 1, col, rowDir, colDir, visited);

	}
}
