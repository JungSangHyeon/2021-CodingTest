package day_2021_05_09;

import java.util.Arrays;

public class P3_주식가격 {

	/**
	 * 이번에도 모범 답안과 똑같이 풀었다.
	 * 되게 비 효율적인 것 같은데 이게 모범이라고?
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
