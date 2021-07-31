package year_2021.month_07.day_31;

public class P107_¿Ã¹Ù¸¥_°ýÈ£ {

	public static void main(String[] args) {

		String[] testCases = {
				"()()", "(())()", ")()(", "(()("
		};
		
		for(String testCase : testCases) {
			System.out.println(solution(testCase));
		}
	}

	static boolean solution(String s) {
		int flag = 0;
		for(char c : s.toCharArray()) {
			flag += (c=='(')? 1 : -1;
			if(flag<0) return false;
		}
		return flag==0;
	}
}
