package year_2021.month_05.day_27;

import java.util.Arrays;

public class P30_예산 {

	/**
	 * 기말고사 시-즌 이라...
	 */
	public static void main(String[] args) {
		System.out.println("Result : "+solution(new int[] {1,3,2,5,4}, 9));
		System.out.println("Result : "+solution(new int[] {2,2,3,3}, 10));
	}

	public static int solution(int[] d, int budget) {
		Arrays.sort(d);
		for(int i=0; i<d.length; i++) {
			budget-=d[i];
			if(budget<0) return i;
			else if(budget==0) return i+1;
		}
        return d.length;
    }
}
