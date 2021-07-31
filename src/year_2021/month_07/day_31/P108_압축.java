package year_2021.month_07.day_31;

import java.util.ArrayList;
import java.util.Arrays;

public class P108_æ–√‡ {

	public static void main(String[] args) {

		String[] testCases = {
				"KAKAO", "ABABABABABABABAB"
		};
		
		for(String testCase : testCases) {
			System.out.println(Arrays.toString(solution(testCase)));
		}
	}

	
	
	public static int[] solution(String msg) {
		ArrayList<Integer> tempAnswer = new ArrayList<>();
		ArrayList<String> dictionary = new ArrayList<>();
		for(int c='A'; c<'Z'+1; c++) dictionary.add(Character.toString(c));
		
		int targetIndex = 0;
		while(targetIndex < msg.length()) {
			String input = "";
			for(int i=targetIndex; i<msg.length(); i++) {
				char c = msg.charAt(i);
				if(dictionary.contains(input+c)) {input+=c; targetIndex++;}
				else break;
			}
			tempAnswer.add(dictionary.indexOf(input)+1);

			if(targetIndex < msg.length()) {
				String next = Character.toString(msg.charAt(targetIndex));
				dictionary.add(input + next);
			}
		}
		
		int[] answer = tempAnswer.stream().mapToInt(i -> i).toArray(); 
        return answer;
    }
}
