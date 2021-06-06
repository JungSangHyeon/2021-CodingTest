package year_2021.month_06.day_06;

import java.util.ArrayList;
import java.util.Stack;

public class P41_짝지어_제거하기 {

	/**
	 * 지금 쯤 보니 여러 문제 풀어 보면서 다양한 방법을 사용할 수 있게 되었네
	 * 모범 답안이네
	 */
	
	public static void main(String[] args) {
		System.out.println(solution3("baabaa"));
	}

	public static int solution3(String s) {
		if(s.length()%2==1) return 0;
		Stack<Character> stack = new Stack<>();
		for(char c : s.toCharArray()) {
			if(stack.size()==0) stack.add(c);
			else if(stack.peek()==c) stack.pop(); 
			else stack.add(c);
		}
		return (stack.size()==0)? 1:0;
	}
	
	public static int solution(String s) {
		char[] chars = s.toCharArray();
		for(int i=0; i<s.length()-1; i++) {
			System.out.println(s);
			System.out.println(i);
			System.out.println(s.charAt(i)==s.charAt(i+1));
			if(s.charAt(i)==s.charAt(i+1)) {
				s = new StringBuilder(s).delete(i, i+2).toString();
				if(i!=0) i-=2; else i-=1;
				System.out.println("edit: "+s+", "+i);
			}
		}
		return (s.length()==0)? 1:0;
	}
	
	public static int solution2(String s) {
		ArrayList<Character> chars = new ArrayList<>();
		for(char c : s.toCharArray()) chars.add(c);
		for(int i=0; i<chars.size()-1; i++) {
			if(chars.get(i)==chars.get(i+1)) {
				chars.remove(i+1);
				chars.remove(i);
				if(i!=0) i-=2; else i-=1;
			}
		}
		return (chars.size()==0)? 1:0;
	}
	
	
}
