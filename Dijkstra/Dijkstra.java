// Problem Description URL: http://codeforces.com/problemset/problem/20/C


import java.util.*;
import java.io.*;

public class Dijkstra {
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
			System.in)));

	public static void main(String[] args) {
		new Dijkstra().solve();
	}

	void solve() {
		int n = in.nextInt(), m = in.nextInt();
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++)
			g.add(new ArrayList<Integer>());
		ArrayList<ArrayList<Integer>> e = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++)
			e.add(new ArrayList<Integer>());

		while (m-- > 0) {
			int a = in.nextInt() - 1, b = in.nextInt() - 1, c = in.nextInt();
			g.get(a).add(b);
			e.get(a).add(c);
			g.get(b).add(a);
			e.get(b).add(c);
		}

		final long[] d = new long[n];
		int[] prev = new int[n];
		long INFINITY = (long)2.0e13;
		for (int i = 1; i < n; i++)
			d[i] = INFINITY;

		TreeSet<Integer> q = new TreeSet<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				if (d[a] < d[b]) return -1;
				if (d[a] > d[b]) return 1; 
				return a - b;
			}
		});

		// start dijkstra
		q.add(0);
		while (!q.isEmpty()) {
			int u = q.pollFirst();
			for (int i = 0; i < g.get(u).size(); i++) {
				int v = g.get(u).get(i);
				int duv = e.get(u).get(i);
				if (d[v] > d[u] + duv) {
					q.remove(v);
					d[v] = d[u] + duv;
					q.add(v);
					prev[v] = u;
				}
			}
		}
		// end dijkstra

		if (d[n-1] == INFINITY)
			System.out.println(-1);
		else {
			ArrayList<Integer> shortest = new ArrayList<Integer>();
			int ptr = n - 1;
			while (true) {
				shortest.add(ptr);
				if (ptr == 0)
					break;
				ptr = prev[ptr];
			}
			for (int i = shortest.size() - 1; i > 0; i--)
				System.out.print((shortest.get(i) + 1) + " ");
			System.out.println(shortest.get(0) + 1);

		}
	}
}

//import java.util.ArrayList;
//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//
//public class D2 {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int numTests = sc.nextInt();
//		ArrayList<Edge> grph = new ArrayList<>();
//		int i = 0;
//		while (i < numTests) {
//			int N = sc.nextInt();
//			int M = sc.nextInt();
//			for (int j = 0; j < M; j++) {
//				grph.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
//				// System.out.println(grph.get(j).src + " " + grph.get(j).dst +
//				// " " + grph.get(j).mph + " " + grph.get(j).length + " ");
//			}
//			System.out.println((int) dijkstra(grph, 1, N));
//			i++;
//		}
//		sc.close();
//	}
//
//	public static class Data implements Comparable<Data> {
//		int node;
//		int from;
//		double totalcost;
//
//		public Data(int node, int from, double totalcost) {
//			this.node = node;
//			this.from = from;
//			this.totalcost = totalcost;
//		}
//
//		public boolean check(Data other) {
//			return totalcost > other.totalcost;
//		}
//
//		public int compareTo(Data other) {
//			// TODO Auto-generated method stub
//			return Double.compare(this.totalcost, other.totalcost);
//		}
//	}
//
//	public static class Edge {
//
//		int src;
//		int dst;
//		double length;
//
//		public Edge(int src, int dst, double length) {
//			this.src = src;
//			this.dst = dst;
//			this.length = length;
//		}
//	}
//
//	static double dijkstra(ArrayList<Edge> graph, int start, int goal) {
//		int N = graph.size();
//		boolean[] visited = new boolean[N + 1];
//
//		int[] prev = new int[N + 1];
//
//		PriorityQueue<Data> q = new PriorityQueue<>();
//		q.add(new Data(start, -1, 0));
//
//		while (!q.isEmpty()) {
//			Data cur = q.peek();
//			q.remove();
//			if (visited[cur.node])
//				continue;
//
//			visited[cur.node] = true;
//			prev[cur.node] = cur.from;
//
//			if (cur.node == goal) {
//				ArrayList<Integer> path = new ArrayList<>();
//				int curnode = goal;
//
//				while (curnode != -1) {
//					path.add(curnode);
//					System.out.println(curnode);
//					curnode = prev[curnode];
//				}
//				return cur.totalcost;
//			}
//			for (Edge neighbor : graph) {
//				if (neighbor.src == cur.node) {
//					int nextnode = neighbor.dst;
//					if (!visited[nextnode]) {
//						q.add(new Data(nextnode, cur.node, cur.totalcost
//								+ neighbor.length));
//						System.out.print(nextnode + " ");
//
//					}
//				}
//			}
//			System.out.println();
//
//		}
//		return 0.0;
//	}
//}