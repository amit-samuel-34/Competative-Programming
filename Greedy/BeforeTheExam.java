//Problem Description URL: http://codeforces.com/contest/4/problem/B

import java.util.Arrays;
import java.util.Scanner;


public class BeforeTheExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int days = sc.nextInt();
		int totalhours = sc.nextInt();
		int[] vals = new int[days];
		int[] min = new int[days];
		int[] max = new int[days];
		int minsum = 0;
		int maxsum = 0;
		
		for(int i = 0; i < days; i++){
			min[i] = sc.nextInt();
			minsum += min[i];
			max[i] = sc.nextInt();
			maxsum += max[i];
		}
		
		int total = totalhours;
		for(int i = 0; i < days; i++){
			int temp = Math.min(min[i] + total - minsum, max[i]);
			vals[i] = temp;
			total -= (temp - min[i]);
		}
		
			
			if(!(minsum <= totalhours && totalhours <= maxsum)){
				System.out.println("NO");
			}
			else{
				System.out.println("YES");
				String fin = Arrays.toString(vals);
				fin = fin.replace("[", "");
				fin = fin.replace("]", "");
				fin = fin.replace(",", "");
				System.out.println(fin);
			}
			

	}
}
