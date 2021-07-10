package year_2021.month_07.day_10;

public class P77_최대공약수와_최소공배수 {

	public static void main(String[] args) {

	}

	public int[] solution(int n, int m) {
		int small = Math.min(n, m), big = Math.max(n, m);
		int maxDivide=1, minMultiple;
		
		for(int i=small; i>0; i--) {
			if(small%i==0 && big%i==0) {
				maxDivide=i;
				break;
			}
		}
		
		minMultiple = maxDivide * small/maxDivide * big/maxDivide;
		
        return new int[] {maxDivide, minMultiple};
    }
}
