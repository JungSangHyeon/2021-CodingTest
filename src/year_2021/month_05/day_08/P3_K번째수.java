package year_2021.month_05.day_08;

import java.util.Arrays;

public class P3_K��°�� {

	/**
	 * ��! ��� ����ϰ� ���� �Ȱ��� Ǯ����!
	 * 1�����̱� �ص� ��� ����.
	 * 
	 *  �����
	 *  1. Arrays.copyOfRange���� ������ �Ķ���ʹ� ��ûĿ�� ��� ����. ���ڸ��� 0���� ä���ش�.
	 *  2. ������ ���� +-1 ���ִ°� �� ����.
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
