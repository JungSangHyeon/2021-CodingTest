package year_2021.month_05.day_28;

public class P31_3����_������ {

	/**
	 * �����̶� �ٻ����� 2
	 */
	
	public static void main(String[] args) {
		System.out.println(solution(45));
		System.out.println(solution(125));
	}

	public static int solution(int n) {
		String temp = "";
		while(n/3>0) {
			temp+=n%3;
			n/=3;
		}
		temp+=n%3;
		
		int answer=0;
		for(int i=0; i<temp.length(); i++) {
			answer+= (temp.charAt(i)-'0')*Math.pow(3, temp.length()-i-1);
		}
		return answer;
	}
}
