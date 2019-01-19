//Problem Description URL: http://codeforces.com/contest/514/problem/C

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class WattoAndMechanism {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mechSize = sc.nextInt();
		int queries = sc.nextInt();
		String[] word = new String[mechSize];
		int[] count = new int[mechSize];
		//Map<String, Integer> words = new HashMap<>();
		for(int i = 0; i < mechSize; i++){
			String x = sc.next();
			int y = x.length();
			//words.put(x, y);
			word[i] = x;
			count[i] = y;
			
		}
		//System.out.println(words.values());
		Arrays.sort(word, new java.util.Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        return s1.length() - s2.length();
		    }
		});
		Arrays.sort(count);
		
		checkQueries(word, count, queries, sc);

	}

	private static void checkQueries(String[] word, int[] count, int queries,
			Scanner sc) {
		for(int i = 0; i < queries; i++){
			String in = sc.next();
			ArrayList<String> poss = binarySearch(word, count, in.length());
			if(poss.size() == 0)
				System.out.println("NO");
			else
				System.out.println(oneLett(poss, in));
		}
		
	}

	private static String oneLett(ArrayList<String> poss, String in) {
		
		for(String comp: poss){
			boolean found = false;
			int y = 0;
			for(int i = 0; i < in.length(); i++){
				if(comp.charAt(i) != in.charAt(i)){
					if(found) {
						y = 1;
						break;
					}
					found = true;
				}
			}
			if(y != 1 && !comp.equals(in)) return "YES";
		}
		return "NO";
	}

	private static ArrayList<String> binarySearch(String[] words, int[] count,
			int len) {
		
		ArrayList<String> poss = new ArrayList<>();
		int high = count.length;
		int low = 0;
		int mid = 0;
		
		while(low + 1 < high){
			mid = (low + high)/2;
			
			if(count[mid] < len)
				low = mid;
			else if(count[mid] > len)
				high = mid;
			else break;	
		}
		
		if(len == count[mid])
			poss.add(words[mid]);
		
		int i = mid - 1;
		while(i >= 0 && count[i] == len){
			poss.add(words[i]);
			i--;
		}
		
		int j = mid + 1;
		while(j < count.length && count[j] == len){
			poss.add(words[j]);
			j++;
		}
		
		return poss;
	}

}
