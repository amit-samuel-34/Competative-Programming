//Problem Description Page: http://codeforces.com/problemset/problem/320/B

import java.util.ArrayList;
import java.util.Scanner;


public class PingPong {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		ArrayList<Tuple> graph = new ArrayList<>();
		for(int i = 0; i < num; i++){
			int func = sc.nextInt();
			int lo = sc.nextInt();
			int hi = sc.nextInt();
			
			if(func == 1){
				graph.add(new Tuple(lo, hi, 0));
			}
			else if(func == 2){
				dfs(lo - 1, graph);
				
				if(graph.get(hi - 1).vis == 1)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			for(Tuple x: graph){
				x.vis = 0;
			}
			
		}

	}
	
	private static void dfs(int n, ArrayList<Tuple> graph) {
		graph.get(n).vis = 1;
		for(int i = 0; i < graph.size(); i++){
			if(graph.get(i).vis == 0){
				int nLow = graph.get(n).low;
				int nHigh = graph.get(n).high;
				int iLow = graph.get(i).low;
				int iHigh = graph.get(i).high;
				if(nLow > iLow && nLow < iHigh || nHigh > iLow && nHigh < iHigh)
					dfs(i, graph);
			}
		}
		
	}

	public static class Tuple {

		int low;
		int high;
		int vis;

		public Tuple(int low, int high, int vis) {

			this.low = low;
			this.high = high;
			this.vis = vis;
		}
	}

}
