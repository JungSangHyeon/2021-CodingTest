package day_2021_05_08;

import java.util.Arrays;

public class K번째수 {

	/**
	 * 와! 모범 답안하고 완전 똑같이 풀었어!
	 * 1레벨이긴 해도 기분 좋네.
	 * 
	 *  배운점
	 *  1. Arrays.copyOfRange에서 마지막 파라메터는 엄청커도 상관 없당. 빈자리를 0으로 채워준다.
	 *  2. 문제에 따라 +-1 해주는거 잘 보자.
	 */
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for(int i=0; i<commands.length; i++) {
			int[] seperatedArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(seperatedArray);
			answer[i]=seperatedArray[commands[i][2]-1];
		}
        return answer;
    }
	
}
