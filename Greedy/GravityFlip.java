//Problem Description URL: http://codeforces.com/problemset/problem/405/A

import java.util.ArrayList;
import java.util.Scanner;


public class GravityFlip {
	
    public static ArrayList<Integer> blocks = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		prep(sc);
		sc.close();
		shift();
		print();
	}

	private static void print() {
		for(int i = 0; i < blocks.size(); i++){
			System.out.print(blocks.get(i) + " ");
		}
		
	}

	public static void prep(Scanner sc){
		int columns = sc.nextInt();
		for(int i = 0; i < columns; i++){
			int x = sc.nextInt();
			blocks.add(x);
		}
	}
	
	public static void shift(){
		int i = 0;
		while(i < blocks.size() - 1){
			int x1 = blocks.get(i);
			int x2 = blocks.get(i + 1);
			if(x1 > x2){
				int x3 = x1 - x2;
				blocks.set(i + 1, x2 + x3);
				blocks.set(i, x1 - x3);
			}
			i++;
		}
		
		for(int j = 0; j < blocks.size() - 1; j++){
			if(blocks.get(j) > blocks.get(j + 1))
				shift();
		}
	}
}
