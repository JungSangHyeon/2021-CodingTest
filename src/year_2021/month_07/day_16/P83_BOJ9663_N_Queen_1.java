package year_2021.month_07.day_16;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class P83_BOJ9663_N_Queen_1 {

	static int N;
	static ArrayList<Point> QueenPlacedPoints;
	static int count;
	
	public static void main(String[] args) {
		initialize();
		getAnswer(0);
		System.out.println(count);
	}

	private static void initialize() {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		scanner.close();
		QueenPlacedPoints = new ArrayList<>();
		count = 0;
	}

	private static void getAnswer(int num) {
		if(QueenPlacedPoints.size() == N) { count++; return; }
			
		for(int i = num; i<N*N; i++) {
			int x = i%N, y = i/N;
			if(isQueenPlaceable(x, y)) {
				Point queenPlacePoint = new Point(x, y);
				QueenPlacedPoints.add(queenPlacePoint);
				getAnswer(i+1);
				QueenPlacedPoints.remove(queenPlacePoint);
			}
		}
	}

	private static boolean isQueenPlaceable(int x, int y) {
		for(Point point : QueenPlacedPoints) {
			boolean canKillHorizontally = point.x==x;
			boolean canKillVertically = point.y==y;
			boolean canKillDiagonally = Math.abs(point.x-x)==Math.abs(point.y-y);
			if(canKillHorizontally || canKillVertically || canKillDiagonally) return false;
		}
		return true;
	}
}
