package year_2021.month_07.day_22;

import java.util.Arrays;

public class P93_N개의_최소공배수 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2,6,8,14}));
		System.out.println(solution(new int[] {1,2,3}));

	}

	public static int solution(int[] arr) {
		int maxNumber = Arrays.stream(arr).max().getAsInt();
		int answer = 0;
		
		boolean complete = false;
		while(!complete) {
			answer+=maxNumber;
			complete = true;
			for(int i=0; i<arr.length; i++) {
				if(answer%arr[i]!=0) complete = false;
			}
		}
		
		return answer;
	}
}
