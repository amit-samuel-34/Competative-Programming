//Problem Description URL: http://codeforces.com/contest/777/problem/D

import java.util.Arrays;
import java.util.Scanner;


public class CloudOfHashtags {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numHash = sc.nextInt();
		String[] words = new String[numHash];
		for(int i = 0; i < numHash; i++){
			words[i] = sc.next();
		}
		
		for(int j = numHash - 2; j >= 0; j--){
			//System.out.println(words[j].compareTo(words[j+1]));
			if(words[j].compareTo(words[j+1]) < 0) continue;
			
			words[j] = lex(words[j], words[j+1]);
			//System.out.println(Arrays.toString(words));
		}
		
		for(int i = 0; i < words.length; i++){
			System.out.println(words[i]);
		}

	}

	private static String lex(String string, String string2) {
		StringBuilder x = new StringBuilder();
		int len = Math.min(string.length(), string2.length());
		for(int i = 0; i < len; i++){
			if(string.substring(0,len).equals(string2.substring(0,len))){
				x.append(string.substring(0,len));
				break;
			}
			if(string.substring(0,i+1).compareTo(string2.substring(0,i+1)) > 0){
				x.append(string.substring(0, i));
				break;
			}
		}
		//System.out.println(x);
		return x.toString();
	}

}
