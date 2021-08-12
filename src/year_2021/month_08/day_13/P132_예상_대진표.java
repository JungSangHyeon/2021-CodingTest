package year_2021.month_08.day_13;

public class P132_예상_대진표 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int n, int a, int b) {
		int matchCount = 0;
		while(a!=b) {
			matchCount++;
			if(a%2==1) {a+=1;}
			if(b%2==1) {b+=1;}
			a/=2;
			b/=2;
		}
		return matchCount;
	}
}
