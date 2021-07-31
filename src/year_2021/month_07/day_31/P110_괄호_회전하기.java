package year_2021.month_07.day_31;

import java.util.EmptyStackException;
import java.util.Stack;

public class P110_괄호_회전하기 {

	public static void main(String[] args) {
		String[] testCases = {
				"[](){}", "}]()[{", 
				"([{)}]" // 0
		};
		
		for(String testCase : testCases) {
			System.out.println(solution(testCase));
		}
	}

	public static int solution(String s) {
		int answer = 0;
		for(int i=0; i<s.length(); i++) {
			StringBuilder sb = new StringBuilder(s);
			for(int j=0; j<i; j++) {
				sb.append(sb.charAt(0));
				sb.deleteCharAt(0);
			}
			if(isCorrect(sb.toString())) answer++;
		}
		return answer;
	}
	
	private static boolean isCorrect(String s) {
		Stack<Character> stack = new Stack<>();
		for(char c : s.toCharArray()) {
			if(c=='(' || c=='{' || c=='[') stack.push(c);
			else {
				try {
					Character peekChar = stack.peek();
					if((peekChar=='(' && c==')') || peekChar=='{' && c=='}' || peekChar=='[' && c==']') stack.pop();
					else return false;
				}catch(EmptyStackException e) { return false; }
			}
		}
		return stack.size()==0;
	}
}
