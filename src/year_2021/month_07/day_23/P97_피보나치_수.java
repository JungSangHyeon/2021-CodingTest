package year_2021.month_07.day_23;

import java.util.Arrays;

public class P97_피보나치_수 {

	public static void main(String[] args) {
		System.out.println(solution(100000));
	}

	static int[] memory;
	
	public static int solution(int n) {
		memory = new int[n];
		Arrays.fill(memory, -1);
		for(int i=0; i<n; i++) pibo(i);
        return pibo(n);
    }

	public static int pibo(int n) {
		if(n==0 || n==1) return n;
		else {
			int pibo1 = (memory[n-1]!=-1)? memory[n-1] : pibo(n-1);
			int pibo2 = (memory[n-2]!=-1)? memory[n-2] : pibo(n-2);
			memory[n-1] = pibo1;
			memory[n-2] = pibo2;
			return (pibo1 + pibo2)%1234567;
		}
	}
}
