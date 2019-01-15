//Problem Description URL: http://codeforces.com/contest/189/problem/A

import java.util.Scanner;
import java.lang.Math; 


public class CuttingRibbon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int[] numWaysForEachSize = new int[size + 1];
		numWaysForEachSize[0] = 0;
		
		for(int i = 1; i <= size; i++){
			int x = -1;
			int y = -1;
			int z = -1;
			
			if(i >= a)
				x = numWaysForEachSize[i - a];
			if(i >= b)
				y = numWaysForEachSize[i - b];
			if(i >= c)
				z = numWaysForEachSize[i - c];
			
			if(x==-1 && y==-1 && z==-1)
				numWaysForEachSize[i]=-1;
			
			else{
				numWaysForEachSize[i] = Math.max(Math.max(x,y),z) + 1;
			}
		}
		System.out.println(numWaysForEachSize[size]);

	}

}
