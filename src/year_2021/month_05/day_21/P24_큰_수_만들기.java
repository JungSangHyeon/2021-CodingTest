package year_2021.month_05.day_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class P24_큰_수_만들기 {

	/**
	 * 시간 빡빡하네.
	 * 진짜 10번 진짜 통과 안되네!
	 * 그래도 효율에 대해 진짜 많이 배웠다....
	 */
	public static void main(String[] args) {
		System.out.println(solution4("4321", 2)+"\r\n");
		System.out.println(solution7("4321", 2)+"\r\n");
//		System.out.println(solution4("1924", 2)+"\r\n");
//		System.out.println(solution5("1924", 2)+"\r\n");
		System.out.println(solution4("1231234", 3)+"\r\n");
		System.out.println(solution7("1231234", 3)+"\r\n");
		
		System.out.println(solution4("4177252841", 4)+"\r\n");
		System.out.println(solution7("4177252841", 4)+"\r\n");
	}

	public static String solution7(String number, int k) {
		StringBuilder sbuilder = new StringBuilder(number);
		int i=0, ci=0;
        for(i=0; i<k; i++) {
        	for(ci=0; ci<sbuilder.length(); ci++) {
        		if(ci==sbuilder.length()-1 || sbuilder.charAt(ci)<sbuilder.charAt(ci+1)) {sbuilder.deleteCharAt(ci); break;}
        	}
        }
        return sbuilder.toString();
    }
	
	public String solutionM(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
	
//	public static String solution6(String number, int k) {
////		Long arrayMakeStartTime = System.nanoTime(); // 이거 진짜 느리네. 아래보다 천배 느려
////		LinkedList<Character> chars = new LinkedList<>(Arrays.asList(number.chars().mapToObj(i->(char)i).toArray(Character[]::new)));
////		System.out.println("Array Make ConsumeTime: "+(System.nanoTime()-arrayMakeStartTime));
//		
//		Long allTime = System.nanoTime();
//		Long arrayMakeStartTime2 = System.nanoTime();
//		LinkedList<Character> chars = new LinkedList<>();
//		for(int i=0; i<number.length(); i++) chars.add(number.charAt(i));
//		System.out.println("Array Make ConsumeTime2: "+(System.nanoTime()-arrayMakeStartTime2));
//		
//		for (int i = 0; i < k; i++) {
//			int removeTargetIndex = chars.size() - 1;
//			Long getStartTime = System.nanoTime();
//			for (int ci = 0; ci < chars.size() - 1; ci++) {
//				if (chars.get(ci) < chars.get(ci+1)) {removeTargetIndex = ci; break;}
//			}
//			System.out.println("Get ConsumeTime: "+(System.nanoTime()-getStartTime));
//			Long removeStartTime = System.nanoTime();
//			chars.remove(removeTargetIndex);
//			System.out.println("Remove ConsumeTime: "+(System.nanoTime()-removeStartTime));
//		}
//		
//		Long forGetStartTime = System.nanoTime();
//		for(int i=0;i<chars.size(); i++) {
//			chars.get(i);
//		}
//		System.out.println("For Get ConsumeTime: "+(System.nanoTime()-forGetStartTime));
//		
//		Long whileGetStartTime = System.nanoTime();
//		int size = chars.size();
//		while(size!=0) {
//			chars.peek();
//			chars.remove();
//			size--;
//		}
//		System.out.println("While Get ConsumeTime: "+(System.nanoTime()-whileGetStartTime));
//		
//		Long buildTime = System.nanoTime();
//		StringBuilder builder = new StringBuilder();
//		Iterator<Character> i = chars.iterator();
//		while(i.hasNext()) builder.append(i.next());
//		System.out.println("Build ConsumeTime: "+(System.nanoTime()-buildTime));
//		
//		System.out.println("All ConsumeTime: "+(System.nanoTime()-allTime));
//		return builder.toString();
//	}
	
	public static String solution5(String number, int k) { // Linked List가 삭제랑 순서대로 보기 유리해서 바꿈
		LinkedList<Character> chars = new LinkedList<>(Arrays.asList(number.chars().mapToObj(i->(char)i).toArray(Character[]::new)));
		
		for (int i = 0; i < k; i++) {
			int removeTargetIndex = chars.size() - 1;
			for (int ci = 0; ci < chars.size() - 1; ci++) {
				if (chars.get(ci) < chars.get(ci+1)) {removeTargetIndex = ci; break;}
			}
			chars.remove(removeTargetIndex);
		}
		
		StringBuilder builder = new StringBuilder();
		Iterator<Character> i = chars.iterator();
		while(i.hasNext()) builder.append(i.next()); 
		return builder.toString();
	}
	
	public static String solution4(String number, int k) { // 시간 초과 걸려서 삭제 대상을 찾는 새 방법 사용
		Long allTime = System.nanoTime();
        for(int i=0; i<k; i++) {
        	int removeTargetIndex=number.length()-1;
//        	Long getStartTime = System.nanoTime();
        	for(int ci=0; ci<number.length()-1; ci++) {
        		if(number.charAt(ci)<number.charAt(ci+1)) {removeTargetIndex = ci; break;}
        	}
//        	System.out.println("Get ConsumeTime: "+(System.nanoTime()-getStartTime));
//        	Long removeStartTime = System.nanoTime();
        	number = new StringBuilder(number).deleteCharAt(removeTargetIndex).toString();
//        	System.out.println("Remove ConsumeTime: "+(System.nanoTime()-removeStartTime));
        }
        System.out.println("All ConsumeTime: "+(System.nanoTime()-allTime));
        return number;
    }
	
	public static String solution3(String number, int k) { // 배열을 없애고 대신 String 1개만 사용
        for(int i=0; i<k; i++) {
        	String maxString = " ";
        	for(int ci=0; ci<number.length(); ci++) {
        		String nowString = new StringBuilder(number).deleteCharAt(ci).toString();
        		if(nowString.compareTo(maxString)>0) maxString = nowString; 
        	}
        	number = maxString;
        }
        return number;
    }
	
	public static String solution2(String number, int k) { // 문자열로 바꿨는데 메모리 초과 
        for(int i=0; i<k; i++) {
        	ArrayList<String> cases = new ArrayList<>();
        	for(int ci=0; ci<number.length(); ci++) {
        		cases.add(new StringBuilder(number).deleteCharAt(ci).toString());
        	}
        	number = cases.stream().max((s1, s2)->s1.compareToIgnoreCase(s2)).get();
        }
        return number;
    }
	
	public static String solution(String number, int k) { // number가 백만자리라 인테저가 터짐
        for(int i=0; i<k; i++) {
        	ArrayList<Integer> cases = new ArrayList<>();
        	for(int ci=0; ci<number.length(); ci++) {
        		System.out.println(new StringBuilder(number).deleteCharAt(ci).toString());
        		cases.add(Integer.valueOf(new StringBuilder(number).deleteCharAt(ci).toString()));
        	}
        	number = Integer.toString(cases.stream().mapToInt(x->x).max().getAsInt());
        }
        return number;
    }
}
