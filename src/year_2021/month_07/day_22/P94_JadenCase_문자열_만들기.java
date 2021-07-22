package year_2021.month_07.day_22;

public class P94_JadenCase_문자열_만들기 {

	public static void main(String[] args) {
		System.out.println(solution("3people unFollowed me"));
		System.out.println(solution("for the last week"));
	}

	public static String solution(String s) {
		StringBuilder builder = new StringBuilder(s.toLowerCase());

		for(int i=0; i<builder.length(); i++) {
			boolean beforeCharIsSpace = i>0? builder.charAt(i-1)==' ':true;
			boolean thisCharIsEnglish = 'a'<=builder.charAt(i) && builder.charAt(i)<='z';
			if(beforeCharIsSpace && thisCharIsEnglish) builder.setCharAt(i, (char)(builder.charAt(i)-'a'+'A'));
		}
		
        return builder.toString();
    }
	
}
