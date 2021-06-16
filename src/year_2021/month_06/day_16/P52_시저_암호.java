package year_2021.month_06.day_16;

public class P52_시저_암호 {

	public static void main(String[] args) {
		System.out.println(solution("AB", 1));
		System.out.println(solution("z", 1));
		System.out.println(solution("a B z", 4));
	}

	public static String solution(String s, int n) {
        String answer = "";
        for(char c : s.toCharArray()) {
        	if(c==' ') answer+=c;
        	else if('A'<=c && c<='Z') answer+=(char)((c+n > 'Z')? c+n-'Z'+'A'-1 : c+n); 
        	else if('a'<=c && c<='z') answer+=(char)((c+n > 'z')? c+n-'z'+'a'-1 : c+n); 
        }
        return answer;
    }
}
