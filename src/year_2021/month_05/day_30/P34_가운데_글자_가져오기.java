package year_2021.month_05.day_30;

public class P34_���_����_�������� {

	public static void main(String[] args) {

		System.out.println(solution("abcde"));
		System.out.println(solution("abcade"));
	}

	public static String solution(String s) {
		String answer = "";
		if(s.length()%2==0) answer+=s.charAt(s.length()/2-1);
		answer+=s.charAt(s.length()/2);
		return answer;
	}
}
