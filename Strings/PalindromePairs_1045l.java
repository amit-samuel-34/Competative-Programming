//Problem Description URL: https://codeforces.com/problemset/problem/1045/I

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class PalindromePairs_1045l {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numWords = sc.nextInt();
		String[] words = new String[numWords];
		for(int i = 0; i < words.length; i++){
			words[i] = sc.next();
		}
		
		int numPal = 0;
		for(int lead = 0; lead < words.length; lead++){
			for(int trail = lead + 1; trail < words.length; trail++){
				
				//System.out.println(words[lead] + words[trail]);
				
				if(PalindromePerm(words[lead] + words[trail]))
					numPal++;
			}
		}
		
		System.out.println(numPal);
		

	}

	private static boolean PalindromePerm(String string) {
		Map<Character, Integer> counts = new HashMap<>();
		int oddCount = 0;
		
		for(int i = 0; i < string.length(); i++){
			char c = string.charAt(i);
			
			if(!counts.containsKey(c)){
				counts.put(c,1);
				oddCount++;
			}
			else{
				int mapVal = counts.get(c);
				counts.put(c, mapVal + 1);
				if((mapVal + 1) % 2 == 0) oddCount--;
				else oddCount++;
			}
			
		}
		
		return oddCount <= 1;
	}

}
