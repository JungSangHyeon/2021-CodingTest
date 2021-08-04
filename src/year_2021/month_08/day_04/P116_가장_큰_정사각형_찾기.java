package year_2021.month_08.day_04;

public class P116_가장_큰_정사각형_찾기 {

	public static void main(String[] args) {

		solution(new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}});
		solution(new int[][]{{0,0,1,1},{1,1,1,1}});
	}

	public static int solution(int[][] board) {
		int[][] temp = board.clone();
		int biggest = 0;
		for(int i=0; i<temp.length; i++) {
			for(int j=0; j<temp[0].length; j++) {
				if(temp[i][j]==1) {
					if(i>0 && j>0) temp[i][j] = Math.min(temp[i][j-1], Math.min(temp[i-1][j], temp[i-1][j-1]))+1;
					else temp[i][j] = 1;
					if(temp[i][j] > biggest) biggest = temp[i][j];
				}
			}
		}
		return biggest*biggest;
	}

}
