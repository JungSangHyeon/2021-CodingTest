package year_2021.month_06.day_19;

public class P55_이상한_문자_만들기 {

	public static void main(String[] args) {
		System.out.println(solution("try hello world"));
	}

	public static String solution(String s) {
		s = s.toLowerCase();
		String answer = "";
		int index = 0;
		for(char c : s.toCharArray()) {
			if(c==' ') { 
				answer+= c; 
				index=0;
			}else {
				answer += (index%2==0)? (char)(c-('a'-'A')):c;
				index++;
			}
		}
        return answer;
    }
	
}
