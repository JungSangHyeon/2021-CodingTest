package year_2021.month_06.day_09;

import java.util.Arrays;

public class P44_나누어_떨어지는_숫자_배열 {

	public static void main(String[] args) {

	}

	public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(i->i%divisor==0).toArray();
        if(answer.length==0) {answer = new int[]{-1};}
        Arrays.sort(answer);
        return answer;
    }
	
}
