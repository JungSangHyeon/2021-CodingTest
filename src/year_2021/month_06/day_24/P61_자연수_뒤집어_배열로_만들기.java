package year_2021.month_06.day_24;

import java.util.Arrays;

public class P61_자연수_뒤집어_배열로_만들기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(1234567)));
	}

	public static int[] solution(long n) {
		String number = Long.toString(n);
        int[] answer = new int[number.length()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = number.charAt(answer.length-1-i)-'0';
        }
        return answer;
    }
}
