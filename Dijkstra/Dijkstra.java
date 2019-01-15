// Problem Description URL: http://codeforces.com/problemset/problem/20/C

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Dijkstra {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTests = sc.nextInt();
		ArrayList<Edge> grph = new ArrayList<>();
		int i = 0;
		while (i < numTests) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			for (int j = 0; j < M; j++) {
				grph.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			}
			System.out.println((int) dijkstra(grph, 1, N));
			i++;
		}
		sc.close();
	}

	public static class Data implements Comparable<Data> {
		int node;
		int from;
		double totalcost;

		public Data(int node, int from, double totalcost) {
			this.node = node;
			this.from = from;
			this.totalcost = totalcost;
		}

		public boolean check(Data other) {
			return totalcost > other.totalcost;
		}

		public int compareTo(Data other) {
			// TODO Auto-generated method stub
			return Double.compare(this.totalcost, other.totalcost);
		}
	}

	public static class Edge {

		int src;
		int dst;
		double length;

		public Edge(int src, int dst, double length) {
			this.src = src;
			this.dst = dst;
			this.length = length;
		}
	}

	static double dijkstra(ArrayList<Edge> graph, int start, int goal) {
		int N = graph.size();
		boolean[] visited = new boolean[N + 1];

		int[] prev = new int[N + 1];

		PriorityQueue<Data> q = new PriorityQueue<>();
		q.add(new Data(start, -1, 0));

		while (!q.isEmpty()) {
			Data cur = q.peek();
			q.remove();
			if (visited[cur.node])
				continue;

			visited[cur.node] = true;
			prev[cur.node] = cur.from;

			if (cur.node == goal) {
				ArrayList<Integer> path = new ArrayList<>();
				int curnode = goal;

				while (curnode != -1) {
					path.add(curnode);
					System.out.println(curnode);
					curnode = prev[curnode];
				}
				return cur.totalcost;
			}
			for (Edge neighbor : graph) {
				if (neighbor.src == cur.node) {
					int nextnode = neighbor.dst;
					if (!visited[nextnode]) {
						q.add(new Data(nextnode, cur.node, cur.totalcost
								+ neighbor.length));
						System.out.print(nextnode + " ");

					}
				}
			}
			System.out.println();

		}
		return 0.0;
	}
}
