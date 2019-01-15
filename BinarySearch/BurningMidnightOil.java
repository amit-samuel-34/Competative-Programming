//Problem Description URL: http://codeforces.com/problemset/problem/165/B

import java.util.Scanner;


public class BurningMidnightOil {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = binarySearch(sc.nextInt(), sc.nextInt());
		System.out.println(min);
		sc.close();

	}

	private static int binarySearch(int n, int k) {
		int low = 0;
		int high = Integer.MAX_VALUE;
		int mid = -1;
		while(low + 1 < high){
			mid = (low + high)/2;
			long lines = findLines(mid, k);
			long minus = findLines(mid - 1, k);
			if(lines < n)
				low = mid;
			else if(lines >= n && minus >= n)
				high = mid;
			else
				return mid;
		}
		return mid;
	}

	private static long findLines(int v,int k) {
		long sum = 0;
        int x = v;
        int i = 1;
        while (x > 0) {
            sum += x;
            x = (int) (v / Math.pow(k, i++));
        }
        return sum;
	}

}
