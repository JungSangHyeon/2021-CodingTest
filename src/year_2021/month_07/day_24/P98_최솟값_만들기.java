package year_2021.month_07.day_24;

import java.util.Arrays;

public class P98_최솟값_만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum = 0;
		for(int i=0; i<A.length; i++) {
			sum += A[i]*B[B.length-1-i];
		}
		
		return sum;
	}
}
