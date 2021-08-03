package year_2021.month_08.day_03;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class P114_°ÔÀÓ_¸Ê_ÃÖ´Ü°Å¸® {

	// BFS ¾²´Â ¹ý Àß ¹è¿ü¶¥
	
	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
	}

	public static int solution(int[][] maps) {
		int m = maps.length, n = maps[0].length;
		int[][] visited = new int[m][n];
		visited[0][0] = 1;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		
		while(!queue.isEmpty()) {
			Point nowPoint = queue.poll();
			int x = nowPoint.x, y = nowPoint.y;
			
			if(x==m-1 && y==n-1) return visited[x][y];
			
			boolean moveDownPossible = y+1<n && maps[x][y+1]==1 && visited[x][y+1]==0; 
			if(moveDownPossible) {
				queue.add(new Point(x, y+1));
				visited[x][y+1] = visited[x][y]+1;
			}
			
			boolean moveRightPossible = x+1<m && maps[x+1][y]==1 && visited[x+1][y]==0;
			if(moveRightPossible) {
				queue.add(new Point(x+1, y));
				visited[x+1][y] = visited[x][y]+1;
			}
			
			boolean moveUpPossible = y-1>=0 && maps[x][y-1]==1 && visited[x][y-1]==0;
			if(moveUpPossible) {
				queue.add(new Point(x, y-1));
				visited[x][y-1] = visited[x][y]+1;
			}
			
			boolean moveLeftPossible = x-1>=0 && maps[x-1][y]==1 && visited[x-1][y]==0;
			if(moveLeftPossible) {
				queue.add(new Point(x-1, y));
				visited[x-1][y] = visited[x][y]+1;
			}
		}
		return -1;
	}

}


//for(boolean[] bool : passed) {
//	for(boolean b : bool) {
//		if(b)System.out.print("[O] ");
//		else System.out.print("[  ] ");
//	}
//	System.out.println();
//}
//System.out.println();
