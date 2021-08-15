package year_2021.month_08.day_15;

import java.util.*;

public class P134_방문_길이 {

	public static void main(String[] args) {
		System.out.println(solution("LULLLLLLU"));
	}

	public static int solution(String dirs) {
		HashSet<String> move = new HashSet<>();
		int x=0, y=0;

		for(Character c : dirs.toCharArray()) {
			int dx=x, dy=y;
			switch (c) {
				case 'U' : dy = y+1; break;
				case 'D' : dy = y-1; break;
				case 'R' : dx = x+1; break;
				case 'L' : dx = x-1; break;
			}
			if(Math.abs(dx)<=5 && Math.abs(dy)<=5) {
				move.add(""+x+y+dx+dy);
				move.add(""+dx+dy+x+y);
				System.out.println("("+x+", "+y+") -> ("+dx+", "+dy+")");
				System.out.println();
				x=dx;
				y=dy;
			}
		}
		return move.size()/2;
	}
}
