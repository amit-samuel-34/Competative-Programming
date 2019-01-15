//Problem Description URL: http://codeforces.com/contest/514/problem/B

import java.util.ArrayList;
import java.util.Scanner;

public class HanSoloLaserGun {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int troopers = sc.nextInt();
		Coord gunCoord = new Coord(sc.nextInt(), sc.nextInt());
		ArrayList<Coord> data = new ArrayList<>();
		for (int i = 0; i < troopers; i++) {
			Coord cor = new Coord(sc.nextInt(), sc.nextInt());
			data.add(cor);
		}
		int min = findMinShots(data, troopers, gunCoord);
		System.out.println(min);

	}

	private static int findMinShots(ArrayList<Coord> data, int troopers,
			Coord gunCoord) {

		int shots = 0;
		while (!(data.isEmpty())) {
			Coord fir = data.get(0);
			data.remove(0);
			shots++;

			int i = 0;
			while (i < data.size()) {
				Coord sec = data.get(i);
				int left = (gunCoord.y - fir.y) * (gunCoord.x - sec.x);
				int right = (gunCoord.y - sec.y) * (gunCoord.x - fir.x);
				if (left == right)
					data.remove(i);
				else
					i++;
			}
		}

		return shots;
	}

	public static class Coord {

		public int x;
		public int y;

		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
