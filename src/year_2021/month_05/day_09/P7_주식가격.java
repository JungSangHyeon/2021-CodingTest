package year_2021.month_05.day_09;

import java.util.Arrays;

public class P7_�ֽİ��� {

	/**
	 * �̹����� ��� ��Ȱ� �Ȱ��� Ǯ����.
	 * �ǰ� �� ȿ������ �� ������ �̰� ����̶��?
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 2, 3})));
	}

	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++) {
        	int count = 0;
        	for(int j=i; j<prices.length; j++) {
        		if(prices[i]<=prices[j] && j!=(prices.length-1)) {count++;} else {break;}
        	}
        	answer[i] = count;
        }
        return answer;
    }
}
