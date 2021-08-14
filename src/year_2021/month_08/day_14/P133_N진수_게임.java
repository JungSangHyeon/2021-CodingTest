package year_2021.month_08.day_14;

public class P133_N진수_게임 {

	public static void main(String[] args) {
		System.out.println(solution(2,4,2,1));
		System.out.println(solution(16,16,2,1));
		System.out.println(solution(16,16,2,2));
	}

	public static String solution(int n, int t, int m, int p) {
		String speakList = "";
		int minLength = t*m, target = 0;
		while(speakList.length() < minLength) {
			speakList += Integer.toString(target, n);
			target++;
		}
		
		String answer = "";
		for(int i=0; i<t; i++) {
			answer += Character.toUpperCase(speakList.charAt(m*i+p-1));
		}
        return answer;
    }
	
}
