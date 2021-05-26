package year_2021.month_05.dya_26;

public class P29_약수의_개수와_덧셈 {

	/**
	 * 앱 UI 전부 하루만에 개발해야되! 그래도 문제는 풀어야지. 
	 */
	
	public static void main(String[] args) {
		System.out.println(solution(13, 17));
	}

	public static int solution(int left, int right) {
		int sum = 0;
		for(int i=left; i<right+1; i++) {
			int count = 0;
			for(int j=1; j<i+1; j++) {
				if(i%j==0) count++;
			}
			if(count%2==0) sum+=i;
			else sum-=i;
		}
		return sum;
	}
}
