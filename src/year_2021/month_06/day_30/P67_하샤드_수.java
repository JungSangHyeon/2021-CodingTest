package year_2021.month_06.day_30;

public class P67_�ϻ���_�� {

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
