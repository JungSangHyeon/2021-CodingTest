package year_2021.month_08;

public class P112_숫자의_표현 {

	public static void main(String[] args) {

		System.out.println(solution(15));
	}

	public static int solution(int n) {
		int answer = 0;
		for(int i=1; i<n; i++) {
			int needVal = (1+i)*i/2-i;
			if((n-needVal)%i==0 && n > needVal) answer++;
		}
		return answer;
	}
}
