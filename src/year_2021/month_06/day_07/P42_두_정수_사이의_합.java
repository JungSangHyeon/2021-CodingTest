package year_2021.month_06.day_07;

public class P42_��_����_������_�� {

	public static void main(String[] args) {
		System.out.println(solution(1,13));
	}

	public static long solution(int a, int b) {
		long count = Math.abs(a-b)+1;
		long sum = a+b;
		return count*sum/2;
	}
}
