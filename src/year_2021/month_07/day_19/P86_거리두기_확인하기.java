package year_2021.month_07.day_19;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class P86_거리두기_확인하기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][]{
			{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, 
			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}
		)));
	}

	public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0; i<5; i++) answer[i] = isKeepDistance(places[i]);
        return answer;
    }
	
	private static int isKeepDistance(String[] room) {
		ArrayList<Point> personPoints = new ArrayList<>();
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(room[i].charAt(j)=='P') personPoints.add(new Point(i, j));
			}
		}
		
		for(int i=0; i<personPoints.size(); i++) {
			for(int j=i+1; j<personPoints.size(); j++) {
				Point p1 = personPoints.get(i), p2 = personPoints.get(j);
				int distance = Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
				if(distance==1) {
					return 0;
				} else if(distance==2) {
					if(p1.x!=p2.x && p1.y!=p2.y) {
						if(room[p1.x].charAt(p2.y)!='X' || room[p2.x].charAt(p1.y)!='X') return 0;
					}else {
						if (room[(p1.x + p2.x) / 2].charAt((p1.y + p2.y) / 2) != 'X') return 0;
					}
				}
			}
		}
		return 1;
	}

}
