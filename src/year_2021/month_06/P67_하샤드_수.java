package year_2021.month_06;

public class P67_ÇÏ»þµå_¼ö {

	public static void main(String[] args) {

		System.out.println(solution(18));
	}

	public static boolean solution(int x) {
		int temp = x, sumOfNumber = 0;
		
		while(temp>10) {
			sumOfNumber+=temp%10;
			temp/=10;
		}
		sumOfNumber+=temp;
		
		return x%sumOfNumber==0;
	}
}
