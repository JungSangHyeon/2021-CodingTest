package year_2021.month_07.day_26;

public class P100_점프와_순간이동 {

	public static void main(String[] args) {
		System.out.println(solution(5000));
	}

	public static int solution(int n) {
		return getMinUseBattery(n);
	}

	private static int getMinUseBattery(int n) {
		if(n==1) return 1;
		else if(n%2==0) return getMinUseBattery(n/2); 
		else return getMinUseBattery(n/2) + 1; 
	}
}
