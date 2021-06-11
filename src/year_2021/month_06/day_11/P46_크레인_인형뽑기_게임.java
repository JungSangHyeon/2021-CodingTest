package year_2021.month_06.day_11;

import java.util.Stack;

public class P46_크레인_인형뽑기_게임 {

	public static void main(String[] args) {

		System.out.println(solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4}));
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		stack.add(-1);
		for(int move : moves) {
			for(int i=0; i<board.length; i++) {
				int doll = board[i][move-1];
				if(doll!=0) {
					if(stack.peek()==doll) {
						stack.pop();
						answer+=2;
					}else {
						stack.add(doll);
					}
					board[i][move-1]=0; 
					break;
				}
			}
		}
        return answer;
    }
	
}
